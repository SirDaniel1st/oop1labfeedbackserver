import java.lang.reflect.*;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part3Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    public int testLab1PartThreeClass() {
        try {
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            feedback.append("✅ Class Lab1PartThree exists.\n");
            score += 5;

            // Check methods
            Method exercise1 = lab1PartThreeClass.getDeclaredMethod("exercise1");
            Method exercise2 = lab1PartThreeClass.getDeclaredMethod("exercise2");

            feedback.append("✅ Methods exercise1() and exercise2() exist.\n");
            score += 10;

        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class Lab1PartThree does not exist.\n");
        } catch (NoSuchMethodException e) {
            feedback.append("❌ Methods exercise1() or exercise2() are missing.\n");
        }
        return score;
    }

    public int testExercise1() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in; // Save the original System.in

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
            feedback.append("✅ Exercise 1 correctly calculates and formats the area of a circle.\n");
            score += 10;
        } else {
            feedback.append("❌ Exercise 1 output mismatch. Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 1: ").append(e.getMessage()).append("\n");
    } finally {
        System.setOut(originalOut); // Restore System.out
        System.setIn(originalIn); // Restore System.in
    }
    return score;
}
public int testExercise2() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in; // Save the original System.in

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
            feedback.append("✅ Exercise 2 correctly prints all even numbers from 1 to n.\n");
            score += 10;
        } else {
            feedback.append("❌ Exercise 2 output mismatch. Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 2: ").append(e.getMessage()).append("\n");
    } finally {
        System.setOut(originalOut); // Restore System.out
        System.setIn(originalIn); // Restore System.in
    }
    return score;
}
public int testExercise3() {
    PrintStream originalOut = System.out; // Save the original System.out
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Reflectively invoke exercise4
        Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
        Method exercise4 = lab1PartThreeClass.getDeclaredMethod("exercise3");
        exercise4.invoke(null);

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
                            feedback.append("✅ Exercise 3 correctly generates random numbers, asks the question, and computes the product.\n");
                            score += 10;
                        } else {
                            feedback.append("❌ Exercise 3 answer mismatch. Expected: ")
                                    .append(expectedAnswerString)
                                    .append(", Got: ")
                                    .append(answer)
                                    .append("\n");
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
            feedback.append("❌ Exercise 3 output format is incorrect. Expected 2 lines:\nWhat is the product of <num1> and <num2>?\nThe answer is <product>\nGot:\n").append(output).append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 3: ").append(e.getMessage()).append("\n");
    } finally {
        System.setOut(originalOut); // Restore System.out
    }
    return score;
}
public int testExercise4() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in; // Save the original System.in

    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate user input: "hello", then "exit"
        String simulatedInput = "hello\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        try {
            // Reflectively invoke exercise4
            Class<?> lab1PartThreeClass = Class.forName("Lab1PartThree");
            Method exercise4 = lab1PartThreeClass.getDeclaredMethod("exercise4");
            exercise4.invoke(null);
        } catch (InvocationTargetException e) {
            // Log the root cause of the exception
            Throwable cause = e.getCause();
            feedback.append("❌ Error executing exercise4: ").append(cause.getClass().getName())
                    .append(": ").append(cause.getMessage()).append("\n");
            return score; // Return the score and exit the test
        } catch (Exception e) {
            // Catch other reflection-related exceptions
            feedback.append("❌ Unexpected error invoking exercise4: ").append(e.getMessage()).append("\n");
            return score; // Return the score and exit the test
        }

        // Capture the output
        String output = outputStream.toString().trim();
        String[] lines = output.split("\\r?\\n"); // Handle newline variations

        // Define possible responses (trigger words)
        String[] triggerWords = {"hey", "howdy-doo", "oye"};
        boolean validChat = true;

        // Step 1: Validate initial greeting
        if (lines.length > 0 && !lines[0].equalsIgnoreCase("hi")) {
            feedback.append("❌ First line should be 'hi'. Got: '").append(lines[0]).append("'.\n");
            validChat = false;
        }

        // Step 2: Validate chat loop until "exit"
        int userInputIndex = 1;
        for (int i = 1; i < lines.length; i++) {
            if (userInputIndex % 2 == 0) { // User input
                if (lines[i].equalsIgnoreCase("exit")) {
                    feedback.append("✅ Chat correctly ends with 'exit'.\n");
                    score += 10;
                    break; // Exit the loop after "exit"
                }
            } else { // Program response
                if (!Arrays.asList(triggerWords).contains(lines[i].toLowerCase())) {
                    feedback.append("❌ Invalid program response: '").append(lines[i]).append("'. Expected one of: ")
                            .append(Arrays.toString(triggerWords)).append("\n");
                    validChat = false;
                }
            }
            userInputIndex++;
        }

        // Ensure no extra lines after "exit"
        if (validChat && lines.length > userInputIndex + 1) {
            feedback.append("❌ Program produced unexpected output after 'exit'.\n");
            for (int i = userInputIndex + 1; i < lines.length; i++) {
                feedback.append(lines[i]).append("\n");
            }
            validChat = false;
        }

        // Final feedback
        if (validChat) {
            feedback.append("✅ Exercise 4 simulates a chat correctly and terminates on 'exit'.\n");
            score += 10;
        } else {
            feedback.append("Conversation log:\n");
            for (String line : lines) {
                feedback.append(line).append("\n");
            }
        }

    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 4: ").append(e.getClass().getName()).append(": ").append(e.getMessage()).append("\n");
        e.printStackTrace(); // Debugging purposes
    } finally {
        System.setOut(originalOut); // Restore System.out
        System.setIn(originalIn); // Restore System.in
    }
    return score;
}



    public String getFeedback() {
        return feedback.toString();
    }
}
