import java.util.Scanner;
import java.io.File;

public class StationSimulation {
    public static void main (String[] args) {
        FuelStation fStation = new FuelStation();
        String s = fStation.toString();
        System.out.println(s);
        
        Vehicle v = new Vehicle(10, 20, 30);
        String ss = v.toString();
        System.out.println(ss);
        
        try {
            File dataFile = new File("vehicles.txt");
            Scanner sc = new Scanner(dataFile);
            String carData = "";
            
            while (sc.hasNextLine()){
                carData = sc.nextLine();
                System.out.println(carData);
                Vehicle vv = createVehicle(carData.split(","));
                serviceVehicle(v, fStation);
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimension) {
        int l = Integer.parseInt (dimension[0]);
        int b = Integer.parseInt (dimension[1]);
        int w = Integer.parseInt (dimension[2]);
        Vehicle v = new Vehicle (l, b ,w);
        return v;
    }
    
    public static void serviceVehicle (Vehicle v, FuelStation f) {
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
}