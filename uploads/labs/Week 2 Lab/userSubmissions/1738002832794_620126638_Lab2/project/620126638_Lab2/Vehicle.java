public class Vehicle {
    private int tankCapacity;
    private String fuelType;
    
    public double calcTankCapacity(int length, int width, int breadth){
        tankCapacity = (length * width * breadth);
        if (tankCapacity %2 == 0){
            fuelType = "gasoline";
        }
        else fuelType = "diesel";
        return tankCapacity;
    }
    
    public int getTankCapacity(){
        return tankCapacity;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    public String toString(){
        return "VEHICLE TANK CAPACITY: " + getTankCapacity() + " FUEL TYPE: " + getFuelType();
    }
}