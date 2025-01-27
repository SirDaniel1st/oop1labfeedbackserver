import java.lang.reflect.*;
import java.util.*;

public class VehicleTests {

    private StringBuilder feedback = new StringBuilder();

    
        public int runTests() {
        int score=0;
        feedback.append("===== Running Vehicle Class Tests =====\n\n");

        score += testVehicleClass();
        score += testConstructor();
        score += testToString();

        feedback.append("\n===== Vehicle Class Tests Completed =====\n\n");
        return score;
    }

    public int testVehicleClass() {
        double score=0;
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");
            feedback.append("✅ Class Vehicle exists.\n");
            score += .2;

            // Check constructor
            Constructor<?> constructor = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class);
            feedback.append("✅ Constructor for Vehicle(int, int, int) exists.\n");
            score += .4;

            // Check toString method
            Method toStringMethod = vehicleClass.getDeclaredMethod("toString");
            feedback.append("✅ Method toString() exists in Vehicle class.\n");
            score += .4;

        } catch (ClassNotFoundException e) {
            feedback.append("❌ Class Vehicle does not exist.\n");
        } catch (NoSuchMethodException e) {
            feedback.append("❌ Required methods or constructor are missing in Vehicle class.\n");
        }
        return (int)score;
    }

    public int testConstructor() {
        double score=0;
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");

            // Create a vehicle with dimensions (10, 10, 10)
            Object vehicle1 = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(10, 10, 10);

            // Access attributes using reflection
            Field tankCapacityField = vehicleClass.getDeclaredField("tankCapacity");
            Field fuelTypeField = vehicleClass.getDeclaredField("fuelType");

            tankCapacityField.setAccessible(true);
            fuelTypeField.setAccessible(true);

            int tankCapacity = (int) tankCapacityField.get(vehicle1);
            String fuelType = (String) fuelTypeField.get(vehicle1);

            // Check attributes
            if (tankCapacity == 1000 && "gasoline".equalsIgnoreCase(fuelType)) {
                feedback.append("✅ Constructor correctly initializes a vehicle with dimensions (10, 10, 10).\n");
                score += .5;
            } else {
                feedback.append("❌ Constructor failed for vehicle with dimensions (10, 10, 10).\n")
                        .append("Expected: tankCapacity=1000, fuelType=gasoline\n")
                        .append("Got: tankCapacity=").append(tankCapacity)
                        .append(", fuelType=").append(fuelType).append("\n");
            }

            // Create another vehicle with dimensions (15, 15, 15)
            Object vehicle2 = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(15, 15, 15);

            tankCapacity = (int) tankCapacityField.get(vehicle2);
            fuelType = (String) fuelTypeField.get(vehicle2);

            if (tankCapacity == 3375 && "diesel".equalsIgnoreCase(fuelType)) {
                feedback.append("✅ Constructor correctly initializes a vehicle with dimensions (15, 15, 15).\n");
                score += .5;
            } else {
                feedback.append("❌ Constructor failed for vehicle with dimensions (15, 15, 15).\n")
                        .append("Expected: tankCapacity=3375, fuelType=diesel\n")
                        .append("Got: tankCapacity=").append(tankCapacity)
                        .append(", fuelType=").append(fuelType).append("\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error testing constructor: ").append(e.getMessage()).append("\n");
        }
        return (int)score;
    }

    public int testToString() {
        double score=0;
        try {
            Class<?> vehicleClass = Class.forName("Vehicle");

            // Create a vehicle with dimensions (10, 10, 10)
            Object vehicle = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(10, 10, 10);

            // Call toString method
            Method toStringMethod = vehicleClass.getDeclaredMethod("toString");
            String result = (String) toStringMethod.invoke(vehicle);

            String expected = "VEHICLE TANK CAPACITY: 1000 FUEL TYPE: gasoline";
            if (result.equals(expected)) {
                feedback.append("✅ toString() method correctly formats a vehicle with dimensions (10, 10, 10).\n");
                score += .5;
            } else {
                feedback.append("❌ toString() method failed for vehicle with dimensions (10, 10, 10).\n")
                        .append("Expected: ").append(expected).append("\n")
                        .append("Got: ").append(result).append("\n");
            }

            // Create another vehicle with dimensions (15, 15, 15)
            vehicle = vehicleClass.getDeclaredConstructor(int.class, int.class, int.class)
                    .newInstance(15, 15, 15);

            result = (String) toStringMethod.invoke(vehicle);
            expected = "VEHICLE TANK CAPACITY: 3375 FUEL TYPE: diesel";

            if (result.equals(expected)) {
                feedback.append("✅ toString() method correctly formats a vehicle with dimensions (15, 15, 15).\n");
                score += .5;
            } else {
                feedback.append("❌ toString() method failed for vehicle with dimensions (15, 15, 15).\n")
                        .append("Expected: ").append(expected).append("\n")
                        .append("Got: ").append(result).append("\n");
            }

        } catch (Exception e) {
            feedback.append("❌ Error testing toString() method: ").append(e.getMessage()).append("\n");
        }
        return (int)score;
    }

    public String getFeedback() {
        return feedback.toString();
    }
}
