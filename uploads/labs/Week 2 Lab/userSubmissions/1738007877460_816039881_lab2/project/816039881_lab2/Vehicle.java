import java.util.Scanner;
import java.io.File;

public class Vehicle{ 
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int breadth, int width) {
        this.tankCapacity = length + breadth * width;
        if(tankCapacity % 2 == 0) {
            fuelType = "gasoline";
        }
        else {
            fuelType = "disel";
        }
    }
    
    public int getTankCapacity() {
        return this.tankCapacity;
    }
    
    public String getFuelType() {
        return this.fuelType;
    }
    
    public String toString() {
        return ("VEHICLE TANK CAPACITY: " + this.tankCapacity + " FUEL TYPE: " + this.fuelType);
    }
    
    public static void main(String[] args) {
        
    }
    
}
