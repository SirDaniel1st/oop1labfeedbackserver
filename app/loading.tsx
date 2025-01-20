import { Card, CardContent } from '@/components/ui/card';

export default function Loading() {
  return (
    <div className="min-h-screen bg-background flex items-center justify-center p-4">
      <Card>
        <CardContent className="p-8">
          <div className="flex items-center space-x-4">
            <div className="h-6 w-6 animate-spin rounded-full border-b-2 border-primary"></div>
            <p className="text-lg font-medium">Loading...</p>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}