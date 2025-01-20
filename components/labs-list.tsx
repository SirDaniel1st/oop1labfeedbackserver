'use client';

import { useEffect, useState } from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from '@/components/ui/table';

type Lab = {
  id: string;
  name: string;
  createdAt: string;
};

export function LabsList() {
  const [labs, setLabs] = useState<Lab[]>([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    async function fetchLabs() {
      try {
        const response = await fetch('/api/labs');
        if (!response.ok) throw new Error('Failed to fetch labs');
        const data = await response.json();
        setLabs(data);
      } catch (error) {
        console.error('Error fetching labs:', error);
      } finally {
        setIsLoading(false);
      }
    }

    fetchLabs();
  }, []);

  if (isLoading) {
    return <div>Loading labs...</div>;
  }

  if (labs.length === 0) {
    return <div>No labs created yet.</div>;
  }

  return (
    <Table>
      <TableHeader>
        <TableRow>
          <TableHead>Lab Name</TableHead>
          <TableHead>Created At</TableHead>
        </TableRow>
      </TableHeader>
      <TableBody>
        {labs.map((lab) => (
          <TableRow key={lab.id}>
            <TableCell>{lab.name}</TableCell>
            <TableCell>{new Date(lab.createdAt).toLocaleDateString()}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}