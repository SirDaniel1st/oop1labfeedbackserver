
public class Vehicle {
    
    private int tankCapacity;
    private String fuelType;

    public Vehicle(int length, int breath, int width) 
    {
        this.tankCapacity = length * breath * width;
        if (tankCapacity % 2 == 0) {
            fuelType = "gasoline";
        }
        else {
            fuelType = "disel";
        }
    }

    public int getTankCapacity() {return this.tankCapacity;}
    public String getFuelType() {return this.fuelType;}
    
    public String toString() {
        return "VEHICLE TANK CAPACITY: " + this.tankCapacity + " FUEL TYPE: " + this.fuelType;
    }
}
