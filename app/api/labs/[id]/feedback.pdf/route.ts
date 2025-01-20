import { NextResponse } from 'next/server';
import { join } from 'path';
import * as fs from 'fs/promises';
import * as fsSync from 'fs'; // Use synchronous methods for path checking

export async function GET(
  request: Request,
  { params }: { params: { id: string } }
) {
  try {
    // Define the base directory for user submissions
    const userSubmissionsDir = join(
      process.cwd(),
      'uploads',
      'labs',
      params.id,
      'userSubmissions'
    );

    // Get all submission directories
    const submissions = await fs.readdir(userSubmissionsDir);

    if (submissions.length === 0) {
      console.error(`No submissions found in: ${userSubmissionsDir}`);
      return NextResponse.json(
        { error: 'No submissions found' },
        { status: 404 }
      );
    }

    // Sort and get the latest submission folder
    const latestSubmission = submissions.sort().pop();

    if (!latestSubmission) {
      console.error('Failed to determine the latest submission.');
      return NextResponse.json(
        { error: 'Failed to determine the latest submission' },
        { status: 404 }
      );
    }

    // Define the project folder path inside the latest submission
    const projectFolder = join(userSubmissionsDir, latestSubmission, 'project');

    // Ensure the project folder exists
    if (!fsSync.existsSync(projectFolder)) {
      console.error(`Project folder does not exist: ${projectFolder}`);
      return NextResponse.json(
        { error: 'Project folder not found' },
        { status: 404 }
      );
    }

    // Recursively search for the feedback PDF
    const findPdfFile = async (dir: string): Promise<string | null> => {
      const files = await fs.readdir(dir, { withFileTypes: true });

      for (const file of files) {
        const filePath = join(dir, file.name);
        if (file.isDirectory()) {
          const nestedPdf = await findPdfFile(filePath);
          if (nestedPdf) return nestedPdf;
        } else if (file.name.toLowerCase().endsWith('.pdf')) {
          return filePath;
        }
      }

      return null;
    };

    const pdfPath = await findPdfFile(projectFolder);

    if (!pdfPath) {
      console.error(`No PDF file found in: ${projectFolder}`);
      return NextResponse.json(
        { error: 'Feedback PDF not found' },
        { status: 404 }
      );
    }

    console.log(`Serving feedback PDF from: ${pdfPath}`);

    // Read and serve the PDF file
    const pdfBuffer = await fs.readFile(pdfPath);

    return new NextResponse(pdfBuffer, {
      headers: {
        'Content-Type': 'application/pdf',
        'Content-Disposition': `inline; filename="${pdfPath.split('/').pop()}"`,
      },
    });
  } catch (error) {
    console.error('Error serving feedback PDF:', error);

    if (error instanceof Error) {
      return NextResponse.json(
        { error: 'Failed to serve feedback PDF', details: error.message },
        { status: 500 }
      );
    }

    return NextResponse.json(
      { error: 'Failed to serve feedback PDF', details: String(error) },
      { status: 500 }
    );
  }
}
