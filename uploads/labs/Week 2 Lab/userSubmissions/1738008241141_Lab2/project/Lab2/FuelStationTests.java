import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class FuelStationTests {

    private StringBuilder feedback = new StringBuilder();
    private int totalScore = 0;

    public int runTests() {
        totalScore += testDefaultConstructor();
        totalScore += testToStringMethod();
        totalScore += testSellFuelPrivateMethod();
        totalScore += testCanDispenseFuelType();
        totalScore += testDispenseMethod();
        return totalScore;
    }

    public int testDefaultConstructor() {
        int score = 0;
        feedback.append("\nTest: Default Constructor\n");
        try {
            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Field fuelType = fuelStationClass.getDeclaredField("fuelType");
            Field fuelVolume = fuelStationClass.getDeclaredField("fuelVolume");
            Field fuelRate = fuelStationClass.getDeclaredField("fuelRate");
            Field fuelSales = fuelStationClass.getDeclaredField("fuelSales");

            fuelType.setAccessible(true);
            fuelVolume.setAccessible(true);
            fuelRate.setAccessible(true);
            fuelSales.setAccessible(true);

            boolean isCorrect = true;

            if (!"gasoline".equals(fuelType.get(fuelStation))) {
                feedback.append("❌ The default fuelType should be 'gasoline'.\n");
                isCorrect = false;
            }

            if ((double) fuelVolume.get(fuelStation) != 75000.0) {
                feedback.append("❌ The default fuelVolume should be 75000.0 liters.\n");
                isCorrect = false;
            }

            if ((double) fuelRate.get(fuelStation) != 2.0) {
                feedback.append("❌ The default fuelRate should be $2.0 per liter.\n");
                isCorrect = false;
            }

            if ((double) fuelSales.get(fuelStation) != 0.0) {
                feedback.append("❌ The default fuelSales should be $0.0.\n");
                isCorrect = false;
            }

            if (isCorrect) {
                feedback.append("✅ Default constructor initializes all attributes correctly.\n");
                score += 1;
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test the default constructor. " + e.getMessage() + "\n");
        }
        return score;
    }

    public int testToStringMethod() {
        int score = 0;
        feedback.append("\nTest: toString Method\n");
        try {
            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Method toStringMethod = fuelStationClass.getDeclaredMethod("toString");
            String result = (String) toStringMethod.invoke(fuelStation);

            String expected = "FUEL: gasoline VOL: 75000.0L PRICE PER L: $2.0 SALES: $0.0";

            if (!result.equals(expected)) {
                feedback.append("❌ The toString method output is incorrect.\n");
                feedback.append("   Expected: " + expected + "\n");
                feedback.append("   Got: " + result + "\n");
            } else {
                feedback.append("✅ toString method produces the correct output.\n");
                score += 1;
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test the toString method. " + e.getMessage() + "\n");
        }
        return score;
    }

    public int testSellFuelPrivateMethod() {
        int score = 0;
        feedback.append("\nTest: Private sellFuel Method\n");
        try {
            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Method sellFuel = fuelStationClass.getDeclaredMethod("sellFuel", double.class);
            sellFuel.setAccessible(true);

            boolean result = (boolean) sellFuel.invoke(fuelStation, 5000.0);

            Method getFuelVolume = fuelStationClass.getDeclaredMethod("getFuelVolume");
            double remainingFuel = (double) getFuelVolume.invoke(fuelStation);

            Method getFuelSales = fuelStationClass.getDeclaredMethod("getFuelSales");
            double sales = (double) getFuelSales.invoke(fuelStation);

            if (!result) {
                feedback.append("❌ sellFuel method failed. The fuelVolume might be insufficient.\n");
            } else if (remainingFuel != 70000.0 || sales != 10000.0) {
                feedback.append("❌ sellFuel method did not update fuelVolume or fuelSales correctly.\n");
                feedback.append("   Expected remaining fuel: 70000.0\n");
                feedback.append("   Got: " + remainingFuel + "\n");
                feedback.append("   Expected sales: $10000.0\n");
                feedback.append("   Got: $" + sales + "\n");
            } else {
                feedback.append("✅ sellFuel method works as expected.\n");
                score += 1;
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test the sellFuel method. " + e.getMessage() + "\n");
        }
        return score;
    }

    public int testCanDispenseFuelType() {
        int score = 0;
        feedback.append("\nTest: canDispenseFuelType Method\n");
        try {
            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Method canDispenseFuelType = fuelStationClass.getDeclaredMethod("canDispenseFuelType", String.class);

            boolean gasolineResult = (boolean) canDispenseFuelType.invoke(fuelStation, "gasoline");
            boolean dieselResult = (boolean) canDispenseFuelType.invoke(fuelStation, "diesel");

            if (!gasolineResult) {
                feedback.append("❌ The station should dispense gasoline but returned false.\n");
            } else if (dieselResult) {
                feedback.append("❌ The station should not dispense diesel but returned true.\n");
            } else {
                feedback.append("✅ canDispenseFuelType method works correctly.\n");
                score += 1;
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test the canDispenseFuelType method. " + e.getMessage() + "\n");
        }
        return score;
    }

    public int testDispenseMethod() {
        int score = 0;
        feedback.append("\nTest: dispense Method\n");
        try {
            Class<?> fuelStationClass = Class.forName("FuelStation");
            Object fuelStation = fuelStationClass.getDeclaredConstructor().newInstance();

            Method dispense = fuelStationClass.getDeclaredMethod("dispense", String.class, double.class);

            boolean gasolineDispenseResult = (boolean) dispense.invoke(fuelStation, "gasoline", 5000.0);
            boolean dieselDispenseResult = (boolean) dispense.invoke(fuelStation, "diesel", 5000.0);

            Method getFuelVolume = fuelStationClass.getDeclaredMethod("getFuelVolume");
            double remainingFuel = (double) getFuelVolume.invoke(fuelStation);

            if (!gasolineDispenseResult) {
                feedback.append("❌ dispense method failed to dispense gasoline.\n");
            } else if (dieselDispenseResult) {
                feedback.append("❌ dispense method incorrectly dispensed diesel.\n");
            } else if (remainingFuel != 70000.0) {
                feedback.append("❌ dispense method did not update fuelVolume correctly.\n");
                feedback.append("   Expected remaining fuel: 70000.0\n");
                feedback.append("   Got: " + remainingFuel + "\n");
            } else {
                feedback.append("✅ dispense method works correctly.\n");
                score += 1;
            }
        } catch (Exception e) {
            feedback.append("❌ Error: Could not test the dispense method. " + e.getMessage() + "\n");
        }
        return score;
    }

    public String getFeedback() {
        return feedback.toString();
    }
}
