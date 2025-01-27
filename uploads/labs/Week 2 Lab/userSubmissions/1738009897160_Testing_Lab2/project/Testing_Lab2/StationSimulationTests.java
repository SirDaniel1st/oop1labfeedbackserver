import java.io.PrintWriter;
import java.lang.reflect.Method;

public class StationSimulationTests {
    private StringBuilder feedback = new StringBuilder();
    private int score = 0;
    // Method to test the StationSimulation main method
    public int testStationSimulation() {
        int score = 0;
        try {
            Class<?> stationSimulationClass = Class.forName("StationSimulation");
            Method mainMethod = stationSimulationClass.getDeclaredMethod("main", String[].class);

            feedback.append("Running StationSimulation Main...\n");
            mainMethod.invoke(null, (Object) new String[]{});

            feedback.append("✅ StationSimulation ran successfully.\n\n");
            score += 1; // Assign points for passing this test
        } catch (Exception e) {
            feedback.append("❌ Error in StationSimulation.main: ").append(e.getMessage()).append("\n\n");
        }
        return score;
    }

    // Method to test the createVehicle method
    public int testCreateVehicle() {
        double score = 0;
        try {
            Class<?> stationSimulationClass = Class.forName("StationSimulation");
            Method createVehicleMethod = stationSimulationClass.getDeclaredMethod("createVehicle", String[].class);

            // Test case 1: Gasoline vehicle
            feedback.append("Testing Vehicle 1 (Gasoline)...\n");
            String[] dimensions1 = {"10", "10", "10"};
            Object vehicle1 = createVehicleMethod.invoke(null, (Object) dimensions1);

            Class<?> vehicleClass = Class.forName("Vehicle");
            Method getTankCapacity = vehicleClass.getDeclaredMethod("getTankCapacity");
            Method getFuelType = vehicleClass.getDeclaredMethod("getFuelType");

            int tankCapacity1 = (int) getTankCapacity.invoke(vehicle1);
            String fuelType1 = (String) getFuelType.invoke(vehicle1);

            if (tankCapacity1 == 1000 && "gasoline".equalsIgnoreCase(fuelType1)) {
                feedback.append("✅ Vehicle 1 created successfully.\n\n");
                score += .5; // Assign points for passing this test case
            } else {
                feedback.append("❌ Vehicle 1 creation failed.\n")
                        .append("Expected: TankCapacity=1000, FuelType=gasoline\n")
                        .append("Got:      TankCapacity=").append(tankCapacity1)
                        .append(", FuelType=").append(fuelType1).append("\n\n");
            }

            // Test case 2: Diesel vehicle
            feedback.append("Testing Vehicle 2 (Diesel)...\n");
            String[] dimensions2 = {"15", "15", "15"};
            Object vehicle2 = createVehicleMethod.invoke(null, (Object) dimensions2);

            int tankCapacity2 = (int) getTankCapacity.invoke(vehicle2);
            String fuelType2 = (String) getFuelType.invoke(vehicle2);

            if (tankCapacity2 == 3375 && "diesel".equalsIgnoreCase(fuelType2)) {
                feedback.append("✅ Vehicle 2 created successfully.\n\n");
                score += .5; // Assign points for passing this test case
            } else {
                feedback.append("❌ Vehicle 2 creation failed.\n")
                        .append("Expected: TankCapacity=3375, FuelType=diesel\n")
                        .append("Got:      TankCapacity=").append(tankCapacity2)
                        .append(", FuelType=").append(fuelType2).append("\n\n");
            }
        } catch (Exception e) {
            feedback.append("❌ Error in createVehicle Method: ").append(e.getMessage()).append("\n\n");
        }
        return (int)score;
    }

    // Method to test the serviceVehicle method
    public int testServiceVehicle() {
        double score = 0;
        try {
            Class<?> stationSimulationClass = Class.forName("StationSimulation");
            Method serviceVehicleMethod = stationSimulationClass.getDeclaredMethod("serviceVehicle", Class.forName("Vehicle"), Class.forName("FuelStation"));

            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Class<?> vehicleClass = Class.forName("Vehicle");
            Object gasolineVehicle = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(10, 10, 10); // Gasoline vehicle

            Object dieselVehicle = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(15, 15, 15); // Diesel vehicle

            feedback.append("Servicing gasoline vehicle...\n");
            serviceVehicleMethod.invoke(null, gasolineVehicle, fuelStation);

            Method getFuelVolume = fuelStationClass.getDeclaredMethod("getFuelVolume");
            double remainingFuel = (double) getFuelVolume.invoke(fuelStation);

            if (remainingFuel == 74000.0) {
                feedback.append("✅ Fuel levels updated successfully for gasoline vehicle.\n\n");
                score += .5; // Assign points for passing this test case
            } else {
                feedback.append("❌ Fuel level mismatch after servicing gasoline vehicle.\n")
                        .append("Expected remaining fuel: 74000.0\n")
                        .append("Got remaining fuel:      ").append(remainingFuel).append("\n\n");
            }

            feedback.append("Servicing diesel vehicle...\n");
            serviceVehicleMethod.invoke(null, dieselVehicle, fuelStation);

            remainingFuel = (double) getFuelVolume.invoke(fuelStation);
            if (remainingFuel == 74000.0) {
                feedback.append("✅ No incorrect effect on fuel levels for diesel vehicle.\n\n");
                score += .5; // Assign points for passing this test case
            } else {
                feedback.append("❌ Diesel vehicle incorrectly affected fuel levels.\n\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error in serviceVehicle Method: ").append(e.getMessage()).append("\n\n");
        }
        return (int)score;
    }

    // Helper method to create the vehicles.txt file
    private void createVehiclesFile() {
        try {
            PrintWriter writer = new PrintWriter("vehicles.txt");
            writer.println("10,10,10"); // Vehicle with capacity 1000 (gasoline)
            writer.println("15,15,15"); // Vehicle with capacity 3375 (diesel)
            writer.println("20,20,20"); // Vehicle with capacity 8000 (gasoline)
            writer.close();
            feedback.append("✅ Created vehicles.txt with sample data.\n\n");
        } catch (Exception e) {
            feedback.append("❌ Failed to create vehicles.txt: ").append(e.getMessage()).append("\n\n");
        }
        
    }
    
    public String getFeedback() {
        return feedback.toString();
    }
}
