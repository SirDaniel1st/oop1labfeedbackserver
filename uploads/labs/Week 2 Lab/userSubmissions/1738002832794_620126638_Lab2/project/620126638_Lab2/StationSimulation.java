import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StationSimulation{
    public static void main(String[] args){
        
        FuelStation station = new FuelStation();
        System.out.println(station.toString());
        System.out.println();
        
        try {
            File file = new File("vehicles.txt");
            
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                
                String[] data = line.split(",");
                
                int length = Integer.parseInt(data[0]);
                int width = Integer.parseInt(data[1]);
                int breadth = Integer.parseInt(data[2]);
                
                Vehicle vehicle = new Vehicle();
                vehicle.calcTankCapacity(length, width, breadth);
                
                System.out.println(vehicle.toString());
                boolean filledUp = station.dispense(vehicle.getFuelType(), vehicle.getTankCapacity());
                System.out.println("Filled up: " + filledUp);
                System.out.println(station.toString());
                System.out.println();
            }
            
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("No such file!");
        }
    }
    
    
}