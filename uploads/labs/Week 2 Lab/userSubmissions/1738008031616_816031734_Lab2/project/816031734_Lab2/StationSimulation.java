import java.util.Scanner;
import java.util.Random;
import java.io.File;

public class StationSimulation{
    public static void main (String args[]){
        FuelStation station1 = new FuelStation();
        
        String out = station1.toString();
        System.out.println(out);
        
        double vol = 100.0;
        boolean a = station1.dispense("gasoline", vol);
        out = station1.toString();
        System.out.println(out);
        
        try{
            File dataFile = new File("vehicles.txt");
            Scanner sc = new Scanner(dataFile);
            String carData = "";
            
            while(sc.hasNextLine()){
                carData=sc.nextLine();
                System.out.println(carData);
                Vehicle v = createVehicle(carData.split(","));
            }
            
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
        
    public static Vehicle createVehicle(String[] dimensions){
        int l = Integer.parseInt(dimensions[0]);
        int b = Integer.parseInt(dimensions[1]);
        int w = Integer.parseInt(dimensions[2]);
        Vehicle v = new Vehicle(l,b,w);
        return v;
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
        System.out.println(v);
        System.out.println(
        "Filled Up: " + f.dispense(v.getFuelType(), v.getTankCapacity()));
        System.out.println(f);
    }
}

