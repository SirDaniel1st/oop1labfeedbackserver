'use client';

import { useEffect, useState } from 'react';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { ScrollArea } from '@/components/ui/scroll-area';
import { Beaker } from 'lucide-react';

type Lab = {
  id: string;
  name: string;
};

export function LabsSidebar() {
  const [labs, setLabs] = useState<Lab[]>([]);
  const pathname = usePathname();

  useEffect(() => {
    async function fetchLabs() {
      try {
        const response = await fetch('/api/labs');
        if (!response.ok) throw new Error('Failed to fetch labs');
        const data = await response.json();
        setLabs(data);
      } catch (error) {
        console.error('Error fetching labs:', error);
      }
    }

    fetchLabs();
  }, []);

  return (
    <ScrollArea className="h-[calc(100vh-4rem)] border-r">
      <div className="space-y-4 py-4">
        <div className="px-3 py-2">
          <h1 className="mb-2 px-4 text-lg font-semibold">Labs</h1>
          <div className="space-y-1">
            {labs.map((lab) => (
              <Button
                key={lab.id}
                variant={pathname === `/user/labs/${lab.id}` ? 'secondary' : 'ghost'}
                className={cn('w-full justify-start')}
                asChild
              >
                <Link href={`/user/labs/${lab.id}`}>
                  <Beaker className="mr-2 h-4 w-4" />
                  {lab.name}
                </Link>
              </Button>
            ))}
          </div>
        </div>
      </div>
    </ScrollArea>
  );
}