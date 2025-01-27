public class Vehicle{
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int lenght, int breadth, int width){
        this.tankCapacity = lenght*breadth*width;
        if(tankCapacity%2==0){
            fuelType = "gasoline";
        }
        else{
            fuelType = "disel";
        }
    }
    
    public int gettankCapacity(){return this.tankCapacity;}
    public String getFuelType(){return this.fuelType;}
    
    public String toString(){
        return("VEHICLE TANK CAPACITY:"+ this.tankCapacity+ "FUEL TYPE"+this.fuelType);
    }
}