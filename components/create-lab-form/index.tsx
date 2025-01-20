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

// Updated validation schema
const formSchema = z.object({
  labName: z.string().min(1, 'Lab name is required'),
  testFiles: z
    .custom<FileList>(
      (files) => files instanceof FileList && files.length > 0,
      'Please select a file'
    )
    .refine((files) => files.length === 1, 'Please select exactly one file')
    .refine(
      (files) => files[0]?.type === 'application/zip',
      'File must be a ZIP archive'
    ),
});

type FormValues = z.infer<typeof formSchema>;

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
        <FormField
          control={form.control}
          name="labName"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Lab Name</FormLabel>
              <FormControl>
                <Input placeholder="Lab 1" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <FormField
          control={form.control}
          name="testFiles"
          render={({ field: { onChange } }) => (
            <FormItem>
              <FormLabel>Test Files (ZIP)</FormLabel>
              <FormControl>
                <Input
                  type="file"
                  accept=".zip"
                  onChange={(e) => {
                    const files = e.target.files;
                    if (files?.length) {
                      onChange(files); // Update react-hook-form state
                    }
                  }}
                />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />

        <Button type="submit" disabled={isSubmitting}>
          {isSubmitting ? 'Creating...' : 'Create Lab'}
        </Button>
      </form>
    </Form>
  );
}
