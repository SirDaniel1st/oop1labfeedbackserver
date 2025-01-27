import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
public class StationSimulation{

    public static void main(String[] args){
        FuelStation station1 = new FuelStation();
        System.out.println(station1);
        
        try{
            File dataFile = new File("vehicles.txt");
            Scanner scanner = new Scanner(dataFile);
            String carData = "";
            while(scanner.hasNextLine()){
                 carData = scanner.nextLine();
                 System.out.println(carData);
                 Vehicle v =createVehicle(carData.split(","));
                 serviceVehicle(v, station1);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimensions){
        int length = Integer.parseInt(dimensions[0]);
        int breadth = Integer.parseInt(dimensions[1]);
        int width = Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(length,breadth,width);
        return v;
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
        
        
    }
    
}
