import java.io.File; //for file reading
import java.util.Scanner;//for scanner


public class StationSimulation{
    public static void main (String[] args){
        FuelStation fStation = new FuelStation(); //instance a class
        //Classname variablename = new classConstructor();
        //TestClass tClass = new TestClass();
        System.out.println(fStation);
        
        try{
            File dataFile = new File("vehicles.txt");
            Scanner sc = new Scanner(dataFile);
            String carData ="";
            
            while(sc.hasNextLine()){
                carData = sc.nextLine();
                System.out.println(carData);
                
                Vehicle v = createVehicle(carData.split(","));
            }
            
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public static Vehicle createVehicle(String[] dimension){
        int l = Integer.parseInt(dimension[0]);
        int b = Integer.parseInt(dimension[1]);
        int w = Integer.parseInt(dimension[2]);
        Vehicle v = new Vehicle(l,b,w);
        
        return v;
    }
    
    public static void serviceVehicle(Vehicle v, FuelStation f){
      System.out.println(v);
      System.out.println(
          "Filled Up: " + f.dispense (v.getFuelType(), v.getTankCapacity())
      );
      System.out.println(f);
    }
    
}