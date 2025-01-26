import { authMiddleware } from "@clerk/nextjs";
import { NextResponse } from "next/server";

export default authMiddleware({
  publicRoutes: ["/"], // Make the home page public
  afterAuth(auth, req) {
    const url = new URL(req.url);

    // Fetch admin user ID from environment variables
    const ADMIN_USER_ID = process.env.NEXT_PUBLIC_ADMIN_USER_ID;

    // Admin route protection
    if (url.pathname.startsWith("/admin")) {
      const userId = auth.userId;

      // Check if the user is an admin
      if (userId !== ADMIN_USER_ID) {
        console.log(`Access denied: User ${userId} is not an admin`);
        return NextResponse.redirect(new URL("/", req.url));
      }
    }
  },
});

export const config = {
  matcher: ["/((?!.*\\..*|_next).*)", "/", "/(api|trpc)(.*)"],
};
