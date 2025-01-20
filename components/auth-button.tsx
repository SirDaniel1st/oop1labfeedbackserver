'use client';

import { SignInButton, SignUpButton, SignOutButton, useUser } from "@clerk/nextjs";
import { Button } from "./ui/button";

export function AuthButton() {
  const { isSignedIn } = useUser();

  if (isSignedIn) {
    return (
      <SignOutButton>
        <Button variant="outline">Sign Out</Button>
      </SignOutButton>
    );
  }

  return (
    <div className="flex items-center gap-4">
      <SignInButton>
        <Button variant="outline">Sign In</Button>
      </SignInButton>
      <SignUpButton>
        <Button>Sign Up</Button>
      </SignUpButton>
    </div>
  );
}