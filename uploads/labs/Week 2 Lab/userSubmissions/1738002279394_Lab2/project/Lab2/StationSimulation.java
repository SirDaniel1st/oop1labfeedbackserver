import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StationSimulation{
    public static void main(String[] args){
        FuelStation station = new FuelStation();
        String statement = station.toString();
        System.out.println(statement + '\n');
        try{
            File vehicles = new File("vehicles.txt");
            Scanner reader = new Scanner(vehicles);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String regex = "[,\\.\\s]";
                String[] dimensions = line.split(regex);
                int length = Integer.parseInt(dimensions[0]);
                int width = Integer.parseInt(dimensions[1]);
                int breadth = Integer.parseInt(dimensions[2]);
                Vehicle vehicle = new Vehicle(length, width, breadth);
                System.out.println(vehicle.toString());
                boolean filled = station.dispense(vehicle.getType(), length * width * breadth);
                if (filled == true){
                    System.out.println("Filled up: true");
                }
                else{
                    System.out.println("Filled up: false");
                }
                statement = station.toString();
                System.out.println(statement + '\n');
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        
    }
}