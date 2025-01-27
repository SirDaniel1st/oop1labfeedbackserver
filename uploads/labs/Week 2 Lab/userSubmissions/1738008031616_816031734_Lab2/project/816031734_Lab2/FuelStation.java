public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        fuelType = "gasoline";
        fuelVolume = 75000.0;
        fuelRate = 2.00;
        fuelSales = 0.00;
    }
    
    public String getFuelType(){
        return this.fuelType;
    }
    
    public double getFuelVolume(){
        return this.fuelVolume;
    }
    
    public double getFuelRate(){
        return this.fuelRate;
    }
    
    public double getFuelSales(){
        return this.fuelSales;
    }
    
    public String toString(){
        return "FUEL: " + getFuelType()+ " VOL: " + getFuelVolume()+ "L PRICE PER L: $" + getFuelRate()+ " SALES: $" + getFuelSales();
    }
    
    public boolean sellFuel(double volume){
        if(fuelVolume >= volume && volume > 0){
            fuelVolume = fuelVolume - volume;
            fuelSales = fuelSales + (volume * fuelRate);
            return true;
        } else 
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (fuelType != null){
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
}


