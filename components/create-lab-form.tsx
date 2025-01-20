'use client';

import { useState } from 'react';
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import * as z from 'zod';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from '@/components/ui/form';
import { toast } from 'sonner';

// Define the schema without relying on `FileList` during SSR
const formSchema = z.object({
  labName: z.string().min(1, 'Lab name is required'),
  testFiles: z.any().refine(
    (files) =>
      typeof window !== 'undefined' && files instanceof FileList && files.length === 1,
    'Please select exactly one ZIP file'
  ),
});

type FormValues = {
  labName: string;
  testFiles: FileList | null;
};

export function CreateLabForm() {
  const [isSubmitting, setIsSubmitting] = useState(false);

  const form = useForm<FormValues>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      labName: '',
      testFiles: null,
    },
  });

  async function onSubmit(values: FormValues) {
    if (!values.testFiles?.[0]) return;

    try {
      setIsSubmitting(true);

      const formData = new FormData();
      formData.append('labName', values.labName);
      formData.append('testFiles', values.testFiles[0]);

      const response = await fetch('/api/labs/create', {
        method: 'POST',
        body: formData,
      });

      if (!response.ok) {
        throw new Error('Failed to create lab');
      }

      toast.success('Lab created successfully');
      form.reset();
    } catch (error) {
      toast.error('Failed to create lab');
      console.error('Error creating lab:', error);
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
        {/* Lab Name Field */}
        <FormField
          control={form.control}
          name="labName"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Lab Name</FormLabel>
              <FormControl>
                <Input placeholder="Enter lab name" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        {/* File Upload Field */}
        <FormField
          control={form.control}
          name="testFiles"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Test Files (ZIP)</FormLabel>
              <FormControl>
                <Input
                  type="file"
                  accept=".zip"
                  onChange={(e) => {
                    const files = e.target.files;
                    form.setValue('testFiles', files || null); // Update form state
                  }}
                />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        {/* Submit Button */}
        <Button type="submit" disabled={isSubmitting}>
          {isSubmitting ? 'Creating...' : 'Create Lab'}
        </Button>
      </form>
    </Form>
  );
}
