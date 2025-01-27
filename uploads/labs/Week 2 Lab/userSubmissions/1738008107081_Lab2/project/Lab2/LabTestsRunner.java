import java.io.File;

public class LabTestsRunner {
    public static int labNum = 2;

    public static void main(String[] args) {
        try {
            // Get student ID or name from FeedbackGenerator
            File currentDir = new File(".");
            String folderName = currentDir.getCanonicalFile().getParentFile().getParentFile().getName();
            FeedbackGenerator.generateFeedback(folderName, labNum, "", 0); // Initialize to get student details
            String studentName = FeedbackGenerator.getStudentName();

            // Create instances of test classes
            StationSimulationTests part1 = new StationSimulationTests();
            VehicleTests part2 = new VehicleTests();
            FuelStationTests part3 = new FuelStationTests();

            // Initialize CSV tracker
            String csvPath = "../../../../lab2progress.csv"; // Adjusted path for the CSV file
            CSVProgressTracker tracker = new CSVProgressTracker(csvPath);
            String[] headers = {
                "Student Name",
                "StationSimulation TestStationSimulation",
                "StationSimulation TestCreateVehicle",
                "StationSimulation TestServiceVehicle",
                "Vehicle TestVehicleClass",
                "Vehicle TestConstructor",
                "Vehicle TestToString",
                "FuelStation TestDefaultConstructor",
                "FuelStation TestToStringMethod",
                "FuelStation TestSellFuelPrivateMethod",
                "FuelStation TestCanDispenseFuelType",
                "FuelStation TestDispenseMethod"
            };
            tracker.initializeCSV(headers);

            // Initialize variables
            int totalScore = 0;
            StringBuilder feedback = new StringBuilder();
            int[] studentResults = new int[headers.length - 1]; // Exclude "Student Name" from results

            // Run part1 tests (StationSimulationTests)
            feedback.append("Lab 2 Part 1 tests: \n\n");
            try {
                studentResults[0] = part1.testStationSimulation();
                studentResults[1] = part1.testCreateVehicle();
                studentResults[2] = part1.testServiceVehicle();
                feedback.append(part1.getFeedback());
                totalScore += studentResults[0] + studentResults[1] + studentResults[2];
            } catch (Exception e) {
                feedback.append("❌ Error during Station Simulation tests: ").append(e.getMessage()).append("\n");
            }

            // Run part2 tests (VehicleTests)
            feedback.append("Lab 2 Part 2 tests: \n\n");
            try {
                studentResults[3] = part2.testVehicleClass();
                studentResults[4] = part2.testConstructor();
                studentResults[5] = part2.testToString();
                feedback.append(part2.getFeedback());
                totalScore += studentResults[3] + studentResults[4] + studentResults[5];
            } catch (Exception e) {
                feedback.append("❌ Error during Vehicle tests: ").append(e.getMessage()).append("\n");
            }

            // Run part3 tests (FuelStationTests)
            feedback.append("Lab 2 Part 3 tests: \n\n");
            try {
                studentResults[6] = part3.testDefaultConstructor();
                studentResults[7] = part3.testToStringMethod();
                studentResults[8] = part3.testSellFuelPrivateMethod();
                studentResults[9] = part3.testCanDispenseFuelType();
                studentResults[10] = part3.testDispenseMethod();
                feedback.append(part3.getFeedback());
                totalScore += studentResults[6] + studentResults[7] + studentResults[8] + studentResults[9] + studentResults[10];
            } catch (Exception e) {
                feedback.append("❌ Error during Fuel Station tests: ").append(e.getMessage()).append("\n");
            }

            // Append student results to the CSV
            tracker.appendStudentResults(studentName, studentResults);

            // Generate feedback PDF
            FeedbackGenerator.generateFeedback(folderName, labNum, feedback.toString(), totalScore);

            // Print final feedback
            System.out.println(feedback.toString());
        } catch (Exception e) {
            System.err.println("❌ Error during test execution: " + e.getMessage());
        }
    }
}
