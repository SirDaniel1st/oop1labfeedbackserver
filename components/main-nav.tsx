'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { AuthButton } from './auth-button';
import { useUser } from '@clerk/nextjs';

export function MainNav() {
  const pathname = usePathname();
  const { user } = useUser();
  const isAdmin = user?.publicMetadata?.role === 'admin';

  return (
    <nav className="flex items-center justify-between w-full">
      <div className="flex items-center space-x-4 lg:space-x-6">
        <Button
          asChild
          variant={pathname === '/' ? 'default' : 'ghost'}
        >
          <Link href="/">Home</Link>
        </Button>
        {isAdmin && (
          <Button
            asChild
            variant={pathname === '/admin' ? 'default' : 'ghost'}
          >
            <Link href="/admin">Staff</Link>
          </Button>
        )}
        <Button
          asChild
          variant={pathname === '/user' ? 'default' : 'ghost'}
        >
          <Link href="/user">Student</Link>
        </Button>
      </div>
      <AuthButton />
    </nav>
  );
}