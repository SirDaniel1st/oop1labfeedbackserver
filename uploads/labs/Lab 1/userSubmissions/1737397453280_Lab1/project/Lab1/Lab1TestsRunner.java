import java.io.File;
import java.io.IOException;

public class Lab1TestsRunner {
    public static int labNum = 1;
    public static void main(String[] args) {
        try {
            // Create instances of test classes
            Lab1Part1Tests part1 = new Lab1Part1Tests();
            Lab1Part2Tests part2 = new Lab1Part2Tests();
            Lab1Part3Tests part3 = new Lab1Part3Tests();

            int totalScore = 0;
            StringBuilder feedback = new StringBuilder();

            int totalSteps = 14; // Update total steps to match the number of tests
            int currentStep = 0;
            int previousPercent = 0;

            // Track execution time
            long start = System.currentTimeMillis();

            // Run Lab 1 Part 1 tests
            feedback.append("Lab 1 Part 1 tests: \n\n");
            try {
                int part1Score = part1.testHelloWorldClass();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part1Score += part1.testHelloWorldOutput();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                feedback.append(part1.getFeedback());
                totalScore += part1Score;
            } catch (Exception e) {
                feedback.append("❌ Error during Lab 1 Part 1 tests: ").append(e.getMessage()).append("\n");
            }

            // Run Lab 1 Part 2 tests
            feedback.append("\nLab 1 Part 2 tests: \n\n");
            try {
                int part2Score = part2.testLab1PartTwoClass();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise1();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise2();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise3();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise4();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise5();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part2Score += part2.testExercise6();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                feedback.append(part2.getFeedback());
                totalScore += part2Score;
            } catch (Exception e) {
                feedback.append(" Error during Lab 1 Part 2 tests: ").append(e.getMessage()).append("\n");
            }

            // Run Lab 1 Part 3 tests
            feedback.append("\nLab 1 Part 3 tests: \n\n");
            try {
                int part3Score = part3.testLab1PartThreeClass();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part3Score += part3.testExercise1();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part3Score += part3.testExercise2();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part3Score += part3.testExercise3();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                part3Score += part3.testExercise4();
                currentStep++;
                printProgressBar(currentStep, totalSteps, previousPercent);

                feedback.append(part3.getFeedback());
                totalScore += part3Score;
            } catch (Exception e) {
                feedback.append("❌ Error during Lab 1 Part 3 tests: ").append(e.getMessage()).append("\n");
            }

            // Completion message and timing
            long end = System.currentTimeMillis();
            System.out.println("\n\nAll tests completed in: " + (end - start) + " ms");

            // Generate feedback
            try {
                start = System.currentTimeMillis();
                File currentDir = new File("."); // Points to the current directory
                String folderName = currentDir.getCanonicalFile().getParentFile().getParentFile().getName();
                FeedbackGenerator.generateFeedback(folderName, labNum, feedback.toString(), totalScore);
                end = System.currentTimeMillis();
                System.out.println("Feedback generation took: " + (end - start) + " ms");
            } catch (IOException e) {
                System.err.println("Error generating feedback: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
        }
    }

    // Optimized progress bar
    private static void printProgressBar(int currentStep, int totalSteps, int previousPercent) {
        int progressBarWidth = 30;
        int percentComplete = (int) ((currentStep / (double) totalSteps) * 100);

        if (percentComplete > previousPercent) {
            int progress = (int) ((currentStep / (double) totalSteps) * progressBarWidth);

            StringBuilder progressBar = new StringBuilder("[");
            for (int i = 0; i < progressBarWidth; i++) {
                progressBar.append(i < progress ? "=" : " ");
            }
            progressBar.append("] ");
            progressBar.append(percentComplete).append("%");

            System.out.print("\r" + progressBar.toString());
        }
    }
}
