import java.lang.reflect.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part2Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    /**
     * Tests whether the Lab1PartTwo class exists.
     * @return The accumulated score for this test.
     */
    public int testLab1PartTwoClass() {
        try {
            Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
            feedback.append("✅ The class 'Lab1PartTwo' exists and is properly accessible. This ensures the base structure is correct.\n");
            score += 5;
        } catch (ClassNotFoundException e) {
            feedback.append("❌ The class 'Lab1PartTwo' does not exist.\n")
                    .append("   - Ensure that the class is named exactly 'Lab1PartTwo' and compiled properly.\n")
                    .append("   - Verify that the file containing the class is placed in the correct package (if applicable).\n");
        } catch (Exception e) {
            feedback.append("❌ Unexpected error while testing Lab1PartTwo class: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

    /**
     * Generic test method to validate exercises.
     * @param methodName Name of the method to test.
     * @param expectedOutput Expected output of the method.
     * @param caseSensitive Whether the comparison should be case-sensitive.
     * @param simulatedInput Simulated user input for System.in (if applicable).
     * @param maxScore The score to add for passing the test.
     * @param isFlexible Whether to allow minor variations in output like extra spaces or newlines.
     */
    private void testExercise(
        String methodName, 
        String expectedOutput, 
        boolean caseSensitive, 
        String simulatedInput, 
        int maxScore, 
        boolean isFlexible
    ) {
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;

        try {
            // Set up simulated output and input
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
            if (simulatedInput != null) {
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
            }

            // Invoke the method reflectively
            Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
            Method method = lab1PartTwoClass.getDeclaredMethod(methodName);
            method.invoke(null);

            // Capture and process the output
            String output = outputStream.toString().trim();
            if (!caseSensitive) {
                output = output.toLowerCase();
                expectedOutput = expectedOutput.toLowerCase();
            }

            // Compare outputs
            boolean isMatch;
            if (isFlexible) {
                isMatch = output.replaceAll("\\s+", "").equals(expectedOutput.replaceAll("\\s+", ""));
            } else {
                isMatch = output.equals(expectedOutput);
            }

            if (isMatch) {
                feedback.append("✅ ").append(methodName).append(" executed successfully.\n")
                        .append("   - The program produced the expected behavior.\n")
                        .append("   - Logical flow: The method properly formatted the output, handled input (if any), and adhered to the specifications.\n")
                        .append("   - Validation: The expected result matches the method's output after normalization of spaces and case.\n");
                score += maxScore;
            } else {
                feedback.append("❌ ").append(methodName).append(" output mismatch.\n")
                        .append("   - Expected:\n")
                        .append(expectedOutput)
                        .append("\n   - Actual:\n")
                        .append(output)
                        .append("\n   - Suggestions:\n")
                        .append("     - Check string formatting (extra spaces or newlines).\n")
                        .append("     - Verify output matches exactly, including punctuation.\n");
            }
        } catch (NoSuchMethodException e) {
            feedback.append("❌ Method ").append(methodName).append(" is missing.\n")
                    .append("   - Ensure the method exists in the Lab1PartTwo class and is properly defined.\n");
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class 'Lab1PartTwo' does not exist.\n")
                    .append("   - Verify the class name and ensure it is compiled.\n");
        } catch (Exception e) {
            feedback.append("❌ Error testing ").append(methodName).append(": ").append(e.getMessage()).append("\n");
        } finally {
            // Restore original System.out and System.in
            System.setOut(originalOut);
            if (simulatedInput != null) {
                System.setIn(originalIn);
            }
        }
    }

    // Test each exercise
    public int testExercise1() {
        testExercise("exercise1", "my name is englebert", false, null, 5, true);
        return score;
    }

    public int testExercise2() {
        testExercise("exercise2", "my name is englebert humperdink", false, null, 5, true);
        return score;
    }

    public int testExercise3() {
        // More flexible to allow different name formats
        testExercise("exercise3", "my name is englebert", false, null, 5, true);
        return score;
    }

    public int testExercise4() {
        testExercise("exercise4", "my name is englebert", false, "Englebert\n", 10, true);
        return score;
    }

    public int testExercise5() {
        testExercise("exercise5", "hi, what's your name?\nnice to meet you englebert!", false, "Englebert\n", 10, true);
        return score;
    }

    public int testExercise6() {
        testExercise("exercise6", "hi, what's your name?\nnice to meet you englebert!", false, "My name is Englebert\n", 10, true);
        return score;
    }

    /**
     * Retrieves the comprehensive feedback from all tests.
     * @return A string containing all feedback messages.
     */
    public String getFeedback() {
        return feedback.toString();
    }
}
