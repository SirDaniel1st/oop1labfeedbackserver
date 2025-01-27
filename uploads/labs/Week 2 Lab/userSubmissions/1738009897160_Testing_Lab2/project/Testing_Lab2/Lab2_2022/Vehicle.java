public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int breadth, int width){
        tankCapacity = length * breadth * width;
        if(tankCapacity%2 == 0)
            fuelType = "gasoline";
        else
            fuelType = "diesel";
    }
    public int getTankCapacity(){
        return tankCapacity;
    }
    public String getFuelType(){
        return fuelType;
    }
    public String toString(){
        return "VEHICLE TANK CAPACITY: "+ getTankCapacity() + " FUEL TYPE: "+ getFuelType();
    }
    
}