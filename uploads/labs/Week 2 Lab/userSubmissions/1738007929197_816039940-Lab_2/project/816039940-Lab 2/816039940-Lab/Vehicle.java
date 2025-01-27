public class Vehicle{
    
    private int tankCapacity;
    private String fuelType;
    
    public Vehicle(int length, int breadth, int width ) {
        this.tankCapacity=length*breadth*width;
        if(tankCapacity % 2 == 0){
            fuelType= "gasoline";
        }
        else{
            fuelType="diesel";
        }
    }
    
    public int getTankCapacity(){
    return this.tankCapacity;}
    public String getFuelType(){
    return this.fuelType;}
    
    public String toString(){
        return("Vehicle Tank Capacity :" + this.tankCapacity + "Fuel Type :" + this.fuelType);
    }
}