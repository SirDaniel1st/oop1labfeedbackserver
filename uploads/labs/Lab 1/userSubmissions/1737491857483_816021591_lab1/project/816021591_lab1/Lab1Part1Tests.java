import java.lang.reflect.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part1Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    /**
     * Tests whether the HelloWorld class exists and verifies the main method's
     * existence and signature.
     * @return The accumulated score for this test.
     */
    public int testHelloWorldClass() {
        try {
            // Attempt to load the HelloWorld class
            Class<?> helloWorldClass = Class.forName("HelloWorld");
            feedback.append("✅ Class HelloWorld exists in the project.\n");
            score += 5;

            try {
                // Check if the main method exists and has the correct signature
                Method mainMethod = helloWorldClass.getDeclaredMethod("main", String[].class);

                if (Modifier.isPublic(mainMethod.getModifiers()) && Modifier.isStatic(mainMethod.getModifiers())) {
                    feedback.append("✅ Method main(String[] args) exists and is correctly defined as public and static.\n");
                    score += 5;
                } else {
                    feedback.append("❌ Method main(String[] args) exists but is not correctly defined. Ensure it is public and static.\n");
                }
            } catch (NoSuchMethodException e) {
                feedback.append("❌ Method main(String[] args) is missing. Ensure the HelloWorld class has a properly defined entry point.\n");
            }
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class HelloWorld does not exist. Ensure you have created the HelloWorld class and compiled it correctly.\n");
        }
        return score;
    }

    /**
     * Tests the output of the HelloWorld main method by simulating input and capturing output.
     * @return The accumulated score for this test.
     */
    public int testHelloWorldOutput() {
        PrintStream originalOut = System.out; // Save the original System.out
        InputStream originalIn = System.in;   // Save the original System.in

        try {
            // Prepare simulated input and output streams
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            ByteArrayInputStream inputStream = new ByteArrayInputStream("John\n".getBytes());
            System.setIn(inputStream); // Simulate user input

            // Attempt to invoke the HelloWorld main method
            Class<?> helloWorldClass = Class.forName("HelloWorld");
            Method mainMethod = helloWorldClass.getDeclaredMethod("main", String[].class);

            try {
                mainMethod.invoke(null, (Object) new String[]{});
                String rawOutput = outputStream.toString();
                String normalizedOutput = normalizeString(rawOutput);

                // Define the expected output and normalize it
                String expectedOutput = "Hi what's your name?\nHello John , nice to meet you!";
                String normalizedExpectedOutput = normalizeString(expectedOutput);

                if (normalizedOutput.equals(normalizedExpectedOutput)) {
                    feedback.append("✅ Output matches expected interaction.\n");
                    score += 10;
                } else {
                    feedback.append("❌ Output does not match the expected result.\n")
                            .append("   - Expected:\n")
                            .append(expectedOutput)
                            .append("\n   - Actual:\n")
                            .append(rawOutput.trim())
                            .append("\n   - Suggestions: Check string formatting, newline characters, and ensure no extra spaces.\n");
                }
            } catch (Exception e) {
                feedback.append("❌ Failed to execute HelloWorld main method. Ensure your method does not throw exceptions during runtime.\n")
                        .append("   - Exception Details: ").append(e.getCause() != null ? e.getCause().getMessage() : e.getMessage()).append("\n");
            }
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class HelloWorld does not exist. Ensure you have created and compiled the HelloWorld class.\n");
        } catch (NoSuchMethodException e) {
            feedback.append("❌ Method main(String[] args) is missing. Ensure the HelloWorld class contains a public static main method.\n");
        } finally {
            // Restore the original System.out and System.in
            System.setOut(originalOut);
            System.setIn(originalIn);
        }
        return score;
    }

    /**
     * Normalizes a string by trimming, collapsing multiple spaces, and unifying newline characters.
     * @param input The raw string to normalize.
     * @return A normalized version of the string.
     */
    private String normalizeString(String input) {
        return input.replaceAll("\\s+", " ").trim().replaceAll("\r\n", "\n").replaceAll("\r", "\n");
    }

    /**
     * Retrieves the comprehensive feedback from all tests.
     * @return A string containing all feedback messages.
     */
    public String getFeedback() {
        return feedback.toString();
    }
}
