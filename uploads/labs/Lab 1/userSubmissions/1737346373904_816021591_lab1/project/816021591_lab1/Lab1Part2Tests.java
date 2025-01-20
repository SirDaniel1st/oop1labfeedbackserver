import java.lang.reflect.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part2Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    public int testLab1PartTwoClass() {
        try {
            Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
            feedback.append("✅ Class Lab1PartTwo exists.\n");
            score += 5;
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class Lab1PartTwo does not exist.\n");
        } catch (Exception e) {
            feedback.append("❌ Unexpected error while testing Lab1PartTwo class: ").append(e.getMessage()).append("\n");
        }
        return score;
    }

   public int testExercise1() {
    PrintStream originalOut = System.out; // Save the original System.out
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Reflectively invoke exercise1
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise1 = lab1PartTwoClass.getDeclaredMethod("exercise1");
        exercise1.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case
        String expectedOutput = "my name is englebert".toLowerCase();

        // Match ignoring case and whitespace differences
        if (output.replaceAll("\\s+", "").equals(expectedOutput.replaceAll("\\s+", ""))) {
            feedback.append("✅ Exercise 1 produces the correct output.\n");
            score += 5;
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
    }
    return score;

    }
    public int testExercise2() {
    PrintStream originalOut = System.out; // Save the original System.out
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Reflectively invoke exercise2
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise2 = lab1PartTwoClass.getDeclaredMethod("exercise2");
        exercise2.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case
        String expectedOutput = "my name is englebert humperdink".toLowerCase();

        // Match ignoring case and whitespace differences
        if (output.replaceAll("\\s+", "").equals(expectedOutput.replaceAll("\\s+", ""))) {
            feedback.append("✅ Exercise 2 produces the correct output.\n");
            score += 5;
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
    }
    return score;
}


public int testExercise3() {
    PrintStream originalOut = System.out; // Save the original System.out
    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Reflectively invoke exercise3
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise3 = lab1PartTwoClass.getDeclaredMethod("exercise3");
        exercise3.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case

        // Define the pattern for the output
        String pattern1 = "my name is (.+)"; // Matches "My name is <name>"
        String pattern2 = "(.+)"; // Matches just "<name>"

        if (output.matches(pattern1) || output.matches(pattern2)) {
            feedback.append("✅ Exercise 3 produces a valid output: '").append(output).append("'.\n");
            score += 5;
        } else {
            feedback.append("❌ Exercise 3 output mismatch. Expected any valid name output like 'My name is <name>' or '<name>'.\nGot: '")
                    .append(output)
                    .append("'\n");
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

        // Simulate user input
        String simulatedInput = "Englebert\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Reflectively invoke exercise4
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise4 = lab1PartTwoClass.getDeclaredMethod("exercise4");
        exercise4.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case
        String expectedOutput = "my name is englebert".toLowerCase();

        // Match output ignoring case and whitespace differences
        if (output.replaceAll("\\s+", "").contains(expectedOutput.replaceAll("\\s+", ""))) {
            feedback.append("✅ Exercise 4 interaction is correct.\n");
            score += 10;
        } else {
            feedback.append("❌ Exercise 4 interaction mismatch. Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 4: ").append(e.getMessage()).append("\n");
    } finally {
        System.setOut(originalOut); // Restore System.out
        System.setIn(originalIn); // Restore System.in
    }
    return score;
}

public int testExercise5() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in; // Save the original System.in

    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate user input
        String simulatedInput = "Englebert\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Reflectively invoke exercise5
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise5 = lab1PartTwoClass.getDeclaredMethod("exercise5");
        exercise5.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case
        String expectedOutput = "hi, what's your name?\nnice to meet you englebert!".toLowerCase();

        // Match output ignoring case and whitespace differences
        if (output.replaceAll("\\s+", "").equals(expectedOutput.replaceAll("\\s+", ""))) {
            feedback.append("✅ Exercise 5 interaction is correct.\n");
            score += 10;
        } else {
            feedback.append("❌ Exercise 5 interaction mismatch. Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 5: ").append(e.getMessage()).append("\n");
    } finally {
        System.setOut(originalOut); // Restore System.out
        System.setIn(originalIn); // Restore System.in
    }
    return score;
}

public int testExercise6() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in; // Save the original System.in

    try {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Simulate user input
        String simulatedInput = "My name is Englebert\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Reflectively invoke exercise6
        Class<?> lab1PartTwoClass = Class.forName("Lab1PartTwo");
        Method exercise6 = lab1PartTwoClass.getDeclaredMethod("exercise6");
        exercise6.invoke(null);

        // Capture and process the output
        String output = outputStream.toString().trim().toLowerCase(); // Normalize case
        String expectedOutput = "hi, what's your name?\nnice to meet you englebert!".toLowerCase();

        // Match output ignoring case and whitespace differences
        if (output.replaceAll("\\s+", "").equals(expectedOutput.replaceAll("\\s+", ""))) {
            feedback.append("✅ Exercise 6 interaction is correct.\n");
            score += 10;
        } else {
            feedback.append("❌ Exercise 6 interaction mismatch. Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
        }
    } catch (Exception e) {
        feedback.append("❌ Error testing Exercise 6: ").append(e.getMessage()).append("\n");
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
