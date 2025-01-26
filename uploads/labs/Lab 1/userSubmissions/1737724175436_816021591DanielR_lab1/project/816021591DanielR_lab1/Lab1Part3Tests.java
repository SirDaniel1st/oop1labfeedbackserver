import java.lang.reflect.*;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part3Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    /**
     * Tests whether the Lab1PartThree class and its required methods exist.
     * @return The accumulated score for this test.
     */
    public int testLab1PartThreeClass() {
        try {
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            feedback.append("✅ The class 'Lab1PartThree' exists, which indicates the foundational structure is correct.\n");
            score += 5;

            // Check methods
            Method exercise1 = lab1PartThreeClass.getDeclaredMethod("exercise1");
            Method exercise2 = lab1PartThreeClass.getDeclaredMethod("exercise2");
            Method exercise3 = lab1PartThreeClass.getDeclaredMethod("exercise3");
            Method exercise4 = lab1PartThreeClass.getDeclaredMethod("exercise4");

            feedback.append("✅ Methods 'exercise1()', 'exercise2()', 'exercise3()', and 'exercise4()' are present in the 'Lab1PartThree' class.\n")
                    .append("   - These methods are necessary for fulfilling the exercise requirements.\n");
            score += 10;

        } catch (ClassNotFoundException e) {
            feedback.append("❌ The class 'Lab1PartThree' does not exist.\n")
                    .append("   - Ensure the class is named exactly 'Lab1PartThree' and compiled properly.\n")
                    .append("   - Verify the class is in the correct package if applicable.\n");
        } catch (NoSuchMethodException e) {
            feedback.append("❌ One or more required methods ('exercise1()', 'exercise2()', 'exercise3()', or 'exercise4()') are missing.\n")
                    .append("   - Verify the methods are correctly defined in the 'Lab1PartThree' class.\n");
        }
        return score;
    }
 public int testExercise1() {
        PrintStream originalOut = System.out; // Save the original System.out
        InputStream originalIn = System.in;   // Save the original System.in

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Simulate user input
            String simulatedInput = "12\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            // Reflectively invoke exercise1
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            Method exercise1 = lab1PartThreeClass.getDeclaredMethod("exercise1");
            exercise1.invoke(null);

            // Capture and process the output
            String output = outputStream.toString().trim().toLowerCase(); // Normalize case
            String expectedOutput = "a circle with radius 12.0 has an area of 452.39 units".toLowerCase();

            // Match output ignoring case and whitespace differences
            if (output.replaceAll("\\s+", "").contains(expectedOutput.replaceAll("\\s+", ""))) {
                feedback.append("✅ Exercise 1 successfully calculates the area of a circle given a radius.\n")
                        .append("   - Input Validation: The program correctly handled the user input for radius.\n")
                        .append("   - Calculation: The area was calculated using the correct formula: πr².\n")
                        .append("   - Formatting: The output is well-structured and readable.\n");
                score += 10;
            } else {
                feedback.append("❌ Exercise 1 output mismatch.\n")
                        .append("   - Expected:\n")
                        .append(expectedOutput)
                        .append("\n   - Actual:\n")
                        .append(output)
                        .append("\n   - Suggestions:\n")
                        .append("     - Ensure the area calculation formula is implemented correctly.\n")
                        .append("     - Verify that output formatting matches the expected result.\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing Exercise 1: ").append(e.getMessage()).append("\n");
        } finally {
            System.setOut(originalOut); // Restore System.out
            System.setIn(originalIn); // Restore System.in
        }
        return score;
    }

    /**
     * Tests Exercise 2 - Printing even numbers from 1 to n.
     */
    public int testExercise2() {
        PrintStream originalOut = System.out; // Save the original System.out
        InputStream originalIn = System.in;   // Save the original System.in

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Simulate user input
            String simulatedInput = "22\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            // Reflectively invoke exercise2
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            Method exercise2 = lab1PartThreeClass.getDeclaredMethod("exercise2");
            exercise2.invoke(null);

            // Capture and process the output
            String output = outputStream.toString().trim().toLowerCase(); // Normalize case
            String expectedOutput = "even numbers from 22 : 2 4 6 8 10 12 14 16 18 20 22".toLowerCase();

            // Match output ignoring case and whitespace differences
            if (output.replaceAll("\\s+", "").contains(expectedOutput.replaceAll("\\s+", ""))) {
                feedback.append("✅ Exercise 2 correctly lists all even numbers from 1 to n.\n")
                        .append("   - Input Validation: The program successfully accepted the upper limit as input.\n")
                        .append("   - Logic: The program correctly iterated through the range and identified even numbers.\n")
                        .append("   - Output Formatting: The output is concise and matches the expected structure.\n");
                score += 10;
            } else {
                feedback.append("❌ Exercise 2 output mismatch.\n")
                        .append("   - Expected:\n")
                        .append(expectedOutput)
                        .append("\n   - Actual:\n")
                        .append(output)
                        .append("\n   - Suggestions:\n")
                        .append("     - Check the iteration logic to ensure only even numbers are printed.\n")
                        .append("     - Verify that the output format matches the specification.\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing Exercise 2: ").append(e.getMessage()).append("\n");
        } finally {
            System.setOut(originalOut); // Restore System.out
            System.setIn(originalIn); // Restore System.in
        }
        return score;
    }
    /**
     * Tests Exercise 3 - Random multiplication question.
     */
    public int testExercise3() {
        PrintStream originalOut = System.out; // Save the original System.out
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Reflectively invoke exercise3
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            Method exercise3 = lab1PartThreeClass.getDeclaredMethod("exercise3");
            exercise3.invoke(null);

            // Capture the output
            String output = outputStream.toString().trim();

            // Split output into lines and validate structure
            String[] lines = output.split("\\r?\\n"); // Handles different OS newline characters
            if (lines.length == 2) {
                String question = lines[0].trim();
                String answer = lines[1].trim();

                // Validate the format of the question
                if (question.startsWith("What is the product of") && question.endsWith("?")) {
                    // Extract numbers from the question
                    String[] parts = question.replaceAll("[^0-9 ]", "").trim().split("\\s+");
                    if (parts.length == 2) {
                        try {
                            int num1 = Integer.parseInt(parts[0]);
                            int num2 = Integer.parseInt(parts[1]);
                            int expectedAnswer = num1 * num2;

                            // Validate the format of the answer
                            String expectedAnswerString = "The answer is " + expectedAnswer;
                            if (answer.equals(expectedAnswerString)) {
                                feedback.append("✅ Exercise 3 generates a valid random multiplication question and computes the product correctly.\n")
                                        .append("   - Question format: 'What is the product of <num1> and <num2>?'\n")
                                        .append("   - Numbers: ").append(num1).append(", ").append(num2).append("\n")
                                        .append("   - Correct Answer: ").append(expectedAnswer).append("\n");
                                score += 10;
                            } else {
                                feedback.append("❌ Exercise 3 answer mismatch.\n")
                                        .append("   - Expected: '").append(expectedAnswerString).append("'\n")
                                        .append("   - Got: '").append(answer).append("'\n");
                            }
                        } catch (NumberFormatException e) {
                            feedback.append("❌ Exercise 3 failed to parse numbers from the question: ").append(question).append("\n");
                        }
                    } else {
                        feedback.append("❌ Exercise 3 question does not contain two numbers. Got: ").append(question).append("\n");
                    }
                } else {
                    feedback.append("❌ Exercise 3 question format is incorrect. Expected format: 'What is the product of <num1> and <num2>?'\nGot: ").append(question).append("\n");
                }
            } else {
                feedback.append("❌ Exercise 3 output format is incorrect. Expected 2 lines:\n")
                        .append("What is the product of <num1> and <num2>?\n")
                        .append("The answer is <product>\nGot:\n").append(output).append("\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing Exercise 3: ").append(e.getMessage()).append("\n");
        } finally {
            System.setOut(originalOut); // Restore System.out
        }
        return score;
    }

    /**
     * Tests Exercise 4 - Simulated Chat Program.
     */
    public int testExercise4() {
        PrintStream originalOut = System.out; // Save the original System.out
        InputStream originalIn = System.in;   // Save the original System.in

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Simulate user input: "hello", then "exit"
            String simulatedInput = "hello\nexit\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            // Reflectively invoke exercise4
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            Method exercise4 = lab1PartThreeClass.getDeclaredMethod("exercise4");
            exercise4.invoke(null);

            // Capture the output
            String output = outputStream.toString().trim();
            String[] lines = output.split("\\r?\\n"); // Handle newline variations

            // Define valid program responses
            String[] validResponses = {"hey", "howdy-doo", "oye"};
            boolean validChat = true;

            // Step 1: Validate initial greeting
            if (lines.length > 0 && !lines[0].equalsIgnoreCase("hi")) {
                feedback.append("❌ First program response should be 'hi'. Got: '").append(lines[0]).append("'.\n");
                validChat = false;
            }

            // Step 2: Validate the chat loop
            for (int i = 1; i < lines.length; i++) {
                if (i % 2 == 1) { // User input
                    if (lines[i].equalsIgnoreCase("exit")) {
                        feedback.append("✅ Chat terminates correctly upon receiving 'exit'.\n");
                        score += 10;
                        break;
                    }
                } else { // Program response
                    if (!Arrays.asList(validResponses).contains(lines[i].toLowerCase())) {
                        feedback.append("❌ Invalid program response: '").append(lines[i]).append("'. Expected one of: ")
                                .append(Arrays.toString(validResponses)).append("\n");
                        validChat = false;
                    }
                }
            }

            if (validChat) {
                feedback.append("✅ Exercise 4 simulates a chat correctly, responds appropriately, and terminates on 'exit'.\n");
                score += 10;
            }
        } catch (Exception e) {
            feedback.append("❌ Error testing Exercise 4: ").append(e.getMessage()).append("\n");
        } finally {
            System.setOut(originalOut); // Restore System.out
            System.setIn(originalIn);   // Restore System.in
        }
        return score;
    }

    /**
     * Retrieves all accumulated feedback.
     * @return A string containing feedback messages for all tests.
     */
    public String getFeedback() {
        return feedback.toString();
    }
}
