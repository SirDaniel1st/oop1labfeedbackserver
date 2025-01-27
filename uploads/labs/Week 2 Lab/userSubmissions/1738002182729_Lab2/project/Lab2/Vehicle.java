public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int width, int breadth){
        this.tankCapacity = length * width * breadth;
        if (this.tankCapacity % 2 == 0){
            this.fuelType = "gasoline";
        }
        else{
            this.fuelType = "diesel";
        }
    }
    
    public int getCapacity(){
        return this.tankCapacity;
    }
    
    public String getType(){
        return this.fuelType;
    }
    
    public String toString(){
        return("VEHICLE TANK CAPACITY: " + this.tankCapacity + " FUEL TYPE:" + this.fuelType);
    }
}