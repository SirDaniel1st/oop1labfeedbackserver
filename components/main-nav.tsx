'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { Button } from '@/components/ui/button';
import { AuthButton } from './auth-button';
import { useAuth } from '@clerk/nextjs';

export function MainNav() {
  const pathname = usePathname();
  const { isLoaded, userId,sessionId } = useAuth();

  // Ensure the component doesn't render until user data is loaded
  if (!isLoaded) {
    return null; // Optionally, render a loading indicator here
  }

  // Fetch the admin user ID from environment variables
  const ADMIN_USER_ID = process.env.NEXT_PUBLIC_ADMIN_USER_ID;

  // Check if the current user's ID matches the admin user ID
  const isAdmin = userId === ADMIN_USER_ID;

  return (
    <nav className="flex items-center justify-between w-full">
      <div className="flex items-center space-x-4 lg:space-x-6">
        <Button asChild variant={pathname === '/' ? 'default' : 'ghost'}>
          <Link href="/">Home</Link>
        </Button>
        {isAdmin && (
          <Button asChild variant={pathname === '/admin' ? 'default' : 'ghost'}>
            <Link href="/admin">Staff</Link>
          </Button>
        )}
        <Button asChild variant={pathname === '/user' ? 'default' : 'ghost'}>
          <Link href="/user">Student</Link>
        </Button>
      </div>
      <AuthButton />
    </nav>
  );
}
