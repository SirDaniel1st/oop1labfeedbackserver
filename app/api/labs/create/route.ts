import { NextResponse } from 'next/server';
import { writeFile, mkdir } from 'fs/promises';
import { join } from 'path';
import * as fs from 'fs';
import * as unzipper from 'unzipper';
import { auth } from '@clerk/nextjs';

export async function POST(request: Request) {
  try {
    // Check if user is authenticated and is admin
    const { userId, sessionClaims } = auth();
    if (!userId || !sessionClaims?.admin) {
      return NextResponse.json(
        { error: 'Unauthorized' },
        { status: 401 }
      );
    }

    const formData = await request.formData();
    const labName = formData.get('labName') as string;
    const testFiles = formData.get('testFiles') as File;

    if (!labName || !testFiles) {
      return NextResponse.json(
        { error: 'Missing required fields' },
        { status: 400 }
      );
    }

    // Create lab directory structure
    const labBasePath = join(process.cwd(), 'uploads', 'labs', labName);
    const testFilesZipPath = join(labBasePath, 'testfiles.zip');
    const testFilesDir = join(labBasePath, 'testfiles');
    const userSubmissionsDir = join(labBasePath, 'userSubmissions');

    // Create all necessary directories
    await mkdir(labBasePath, { recursive: true });
    await mkdir(testFilesDir, { recursive: true });
    await mkdir(userSubmissionsDir, { recursive: true });

    // Save the test files zip
    const arrayBuffer = await testFiles.arrayBuffer();
    const buffer = new Uint8Array(arrayBuffer); // Convert ArrayBuffer to Uint8Array
    await writeFile(testFilesZipPath, buffer);

    // Extract test files
    await new Promise((resolve, reject) => {
      fs.createReadStream(testFilesZipPath)
        .pipe(unzipper.Extract({ path: testFilesDir }))
        .on('close', resolve)
        .on('error', reject);
    });

    return NextResponse.json({ success: true });
  } catch (error) {
    console.error('Error creating lab:', error);
    return NextResponse.json(
      { error: 'Failed to create lab' },
      { status: 500 }
    );
  }
}