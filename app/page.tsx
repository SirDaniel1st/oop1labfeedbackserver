import { MainNav } from '@/components/main-nav';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Shield, Users } from 'lucide-react';
import Link from 'next/link';

export default function Home() {
  return (
    <div className="min-h-screen bg-background">
      <header className="border-b">
        <div className="container flex h-16 items-center">
          <MainNav />
        </div>
      </header>
      <main className="container py-6">
        <div className="flex flex-col gap-4">
          <h1 className="text-3xl font-bold">Welcome to the OOP1 Lab Feedback Dashboard</h1>
          <div className="grid gap-4 md:grid-cols-2">
            <Card>
              <CardHeader>
                <Users className="h-8 w-8 mb-2" />
                <CardTitle>User Dashboard</CardTitle>
                <CardDescription>View and manage your OOP1 Labs</CardDescription>
              </CardHeader>
              <CardContent>
                <Button asChild className="w-full">
                  <Link href="/user">Access User Dashboard</Link>
                </Button>
              </CardContent>
            </Card>
          </div>
        </div>
      </main>
    </div>
  );
}