import { authMiddleware } from "@clerk/nextjs";
 
export default authMiddleware({
  publicRoutes: ["/"],
  afterAuth(auth, req) {
    // Handle admin access
    if (req.url.includes('/admin') && !auth.sessionClaims?.admin) {
      const homeUrl = new URL('/', req.url);
      return Response.redirect(homeUrl);
    }
  }
});
 
export const config = {
  matcher: ['/((?!.+\\.[\\w]+$|_next).*)', '/', '/(api|trpc)(.*)'],
};