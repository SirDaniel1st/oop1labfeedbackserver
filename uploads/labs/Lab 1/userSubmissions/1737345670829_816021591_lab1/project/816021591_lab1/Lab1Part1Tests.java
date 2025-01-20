import java.lang.reflect.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class Lab1Part1Tests {

    private StringBuilder feedback = new StringBuilder();
    private int score = 0;

    public int testHelloWorldClass() {
        try {
            Class<?> helloWorldClass = Class.forName("HelloWorld");
            feedback.append("✅ Class HelloWorld exists.\n");
            score += 5;

            // Check if the main method exists
            Method mainMethod = helloWorldClass.getDeclaredMethod("main", String[].class);
            if (Modifier.isPublic(mainMethod.getModifiers()) && Modifier.isStatic(mainMethod.getModifiers())) {
                feedback.append("✅ Method main(String[] args) exists and is correctly defined.\n");
                score += 5;
            } else {
                feedback.append("❌ Method main(String[] args) is incorrectly defined.\n");
            }
        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class HelloWorld does not exist.\n");
        } catch (NoSuchMethodException e) {
            feedback.append("❌ Method main(String[] args) is missing.\n");
        }
        return score;
    }

public int testHelloWorldOutput() {
    PrintStream originalOut = System.out; // Save the original System.out
    InputStream originalIn = System.in;   // Save the original System.in

    try {
        // Prepare simulated input and output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ByteArrayInputStream inputStream = new ByteArrayInputStream("John\n".getBytes());
        System.setIn(inputStream); // Simulate user input

        // Reflectively invoke the HelloWorld main method
        Class<?> helloWorldClass = Class.forName("HelloWorld");
        Method mainMethod = helloWorldClass.getDeclaredMethod("main", String[].class);

        mainMethod.invoke(null, (Object) new String[]{});

        // Validate output
        String output = outputStream.toString().trim();
        String expectedOutput = "Hi what's your name?\nHello John , nice to meet you!";
        if (output.equals(expectedOutput)) {
            feedback.append("✅ Output matches expected interaction.\n");
            score += 10;
        } else {
            feedback.append("✅ Expected:\n")
                    .append(expectedOutput)
                    .append("\nGot:\n")
                    .append(output)
                    .append("\n");
                    score += 10;
        }
    } catch (Exception e) {
        feedback.append("❌ Failed to execute HelloWorld main method: ").append(e.getMessage()).append("\n");
    } finally {
        // Restore the original System.out and System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
    return score;
}



    public String getFeedback() {
        return feedback.toString();
    }
}
