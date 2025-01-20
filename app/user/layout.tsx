import { MainNav } from '@/components/main-nav';
import { LabsSidebar } from '@/components/labs-sidebar';

export default function UserLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div className="min-h-screen bg-background">
      <header className="border-b">
        <div className="container flex h-16 items-center">
          <MainNav />
        </div>
      </header>
      <div className="flex">
        <aside className="w-64 flex-shrink-0">
          <LabsSidebar />
        </aside>
        <main className="flex-1 p-6">
          {children}
        </main>
      </div>
    </div>
  );
}