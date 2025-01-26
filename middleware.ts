import { authMiddleware } from "@clerk/nextjs";

export default authMiddleware({
  publicRoutes: ["/"],
  afterAuth(auth, req) {
    const url = new URL(req.url);

    // Fetch the admin user ID from environment variables
    const ADMIN_USER_ID = process.env.NEXT_PUBLIC_ADMIN_USER_ID;

    // Handle admin access
    if (url.pathname.startsWith('/admin')) {
      const userId = auth.userId; // Get the current user's ID
      if (userId !== ADMIN_USER_ID) {
        console.log(`Access denied to /admin: User ${userId} is not an admin`);
        const homeUrl = new URL('/', req.url);
        return Response.redirect(homeUrl);
      }
    }
  },
});

export const config = {
  matcher: ['/((?!.+\\.[\\w]+$|_next).*)', '/', '/(api|trpc)(.*)'],
};
