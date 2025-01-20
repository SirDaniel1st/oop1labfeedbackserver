import { MainNav } from '@/components/main-nav';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Shield, Users } from 'lucide-react';
import Link from 'next/link';
import { auth } from '@clerk/nextjs';

export default async function Home() {
  const { userId } = auth();
  const isAuthenticated = !!userId;

  return (
    <div className="min-h-screen bg-background">
      <header className="border-b">
        <div className="container flex h-16 items-center">
          <MainNav />
        </div>
      </header>
      <main className="container py-6">
        <div className="flex flex-col gap-4">
          <h1 className="text-3xl font-bold">Welcome to the Dashboard</h1>
          {isAuthenticated ? (
            <div className="grid gap-4 md:grid-cols-2">
              <Card>
                <CardHeader>
                  <Shield className="h-8 w-8 mb-2" />
                  <CardTitle>Staff Portal</CardTitle>
                  <CardDescription>Access Staff tools</CardDescription>
                </CardHeader>
                <CardContent>
                  <Button asChild className="w-full">
                    <Link href="/admin">Access Staff Portal</Link>
                  </Button>
                </CardContent>
              </Card>
              <Card>
                <CardHeader>
                  <Users className="h-8 w-8 mb-2" />
                  <CardTitle>OOP Student Dashboard</CardTitle>
                  <CardDescription>Here is where you submit your Labs for feedback</CardDescription>
                </CardHeader>
                <CardContent>
                  <Button asChild className="w-full">
                    <Link href="/user">Access Student Dashboard</Link>
                  </Button>
                </CardContent>
              </Card>
            </div>
          ) : (
            <Card>
              <CardHeader>
                <CardTitle>Welcome</CardTitle>
                <CardDescription>Please sign in to access the dashboard</CardDescription>
              </CardHeader>
            </Card>
          )}
        </div>
      </main>
    </div>
  );
}