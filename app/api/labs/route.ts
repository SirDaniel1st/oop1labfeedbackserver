import { NextResponse } from 'next/server';
import { readdir, stat, mkdir } from 'fs/promises';
import { join } from 'path';
import { auth } from '@clerk/nextjs';

export async function GET() {
  try {

     // Check if user is authenticated
     const { userId } = auth();
     if (!userId) {
       return NextResponse.json(
         { error: 'Unauthorized' },
         { status: 401 }
       );
     }

     

    const labsDir = join(process.cwd(), 'uploads', 'labs');
    
    // Create the labs directory if it doesn't exist
    try {
      await stat(labsDir);
    } catch {
      await mkdir(labsDir, { recursive: true });
      return NextResponse.json([]);
    }

    // Read lab directories
    const labs = await readdir(labsDir);
    
    // Get metadata for each lab
    const labsWithMetadata = await Promise.all(
      labs.map(async (labName) => {
        const labPath = join(labsDir, labName);
        const stats = await stat(labPath);
        
        return {
          id: labName,
          name: labName,
          createdAt: stats.birthtime.toISOString(),
        };
      })
    );

    return NextResponse.json(labsWithMetadata);
  } catch (error) {
    console.error('Error fetching labs:', error);
    return NextResponse.json(
      { error: 'Failed to fetch labs' },
      { status: 500 }
    );
  }
}