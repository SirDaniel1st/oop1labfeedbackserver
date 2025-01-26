'use client';
import { MainNav } from '@/components/main-nav';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Shield, Users } from 'lucide-react';
import Link from 'next/link';
import { useAuth } from '@clerk/clerk-react'
import { useUser } from '@clerk/clerk-react'

export default async function Home() {
  const { userId  } = useAuth();
  const { user} = useUser()
  const isAuthenticated = !!userId;

  return (
    <div className="min-h-screen bg-background">
      <main className="container py-6">
        <div className="flex flex-col gap-4">
          <h1 className="text-3xl font-bold">Welcome {user?.fullName} to the OOP 1 Lab FeedbackDashboard</h1>
          {isAuthenticated ? (
            <div className="grid gap-4 md:grid-cols-2">
              <Card>
                <CardHeader>
                  <Users className="h-8 w-8 mb-2" />
                  <CardTitle>OOP Student Dashboard</CardTitle>
                  <CardDescription>Here is where you submit your Labs for feedback! <br></br> Go ahead and choose a Lab in the sidebar there that you are working on! </CardDescription>
                </CardHeader>
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