import { MainNav } from '@/components/main-nav';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Shield } from 'lucide-react';
import { CreateLabForm } from '@/components/create-lab-form';
import { LabsList } from '@/components/labs-list';

export default function AdminPage() {
  return (
    <div className="min-h-screen bg-background">
      <header className="border-b">
        <div className="container flex h-16 items-center">
          <MainNav />
        </div>
      </header>
      <main className="container py-6 space-y-6">
        <Card>
          <CardHeader>
            <div className="flex items-center space-x-4">
              <Shield className="h-8 w-8" />
              <div>
                <CardTitle>Create New Lab</CardTitle>
                <CardDescription>Add a new lab with test files</CardDescription>
              </div>
            </div>
          </CardHeader>
          <CardContent>
            <CreateLabForm />
          </CardContent>
        </Card>

        <Card>
          <CardHeader>
            <CardTitle>Existing Labs</CardTitle>
            <CardDescription>View and manage existing labs</CardDescription>
          </CardHeader>
          <CardContent>
            <LabsList />
          </CardContent>
        </Card>
      </main>
    </div>
  );
}