import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.StringTokenizer;
public class StationSimulation{
    public static void main(String[] args){
        FuelStation f = new FuelStation();
        
        /*System.out.println(f.toString());
        
        if(f.canDispenseFuelType("gasoline")){
            System.out.println("Operation completed, gasoline can be dispensed");
        }
        else{
            System.out.println("That fuel type cannot be dispensed");
        }
        
        if(f.dispense("gasoline", 200)){
            System.out.println("Operation completed successfully");
            System.out.println(f.toString());
        }
        else{
            System.out.println("Failed to dispense.");
        }*/
        
        try{
            File myFile = new File("vehicles.txt");
            Scanner s = new Scanner(myFile);
            
            Vehicle v;
            int length, width, breadth;
            String line;
            StringTokenizer st;
            
            System.out.println(f.toString());
            System.out.println(" ");
            
            while(s.hasNextLine()){
                line = s.nextLine();
                st = new StringTokenizer(line, ",");
                
                v = new Vehicle(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
                
                System.out.println(v.toString());
                
                if(f.dispense(v.getFuelType(), v.getTankCapacity())){
                    System.out.println("Filled up: true");
                }
                else{
                    System.out.println("Filled up: false");
                }
                
                System.out.println(f.toString());
                
                System.out.println(" ");
            
            }
            
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}