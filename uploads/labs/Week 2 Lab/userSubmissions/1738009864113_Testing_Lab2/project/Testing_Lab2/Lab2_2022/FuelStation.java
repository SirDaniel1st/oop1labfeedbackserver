public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000; 
        fuelRate = 2.00;
        fuelSales = 0;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    public double getFuelVolume(){
        return fuelVolume;
    }
 
    public double getFuelRate(){
        return fuelRate;
    }
    public double getFuelSales(){
        return fuelSales;
    }   
    
    private boolean sellFuel(double volume){
        if(this.fuelVolume > volume){
            fuelVolume = fuelVolume - volume;
            fuelSales += (volume * fuelRate) ;
            return true;
        }
        return false;
    }
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null)
            return fuelType.equals(getFuelType());
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){  
            return sellFuel(volume);
        }
        return false;
    }
    
    public String toString(){
        String details = "";
        return "FUEL: " + getFuelType() + " VOL: " + getFuelVolume() 
        + "L PRICE PER L: $" +getFuelRate() + " SALES: $" +getFuelSales() ;
    }
    
    
    
}