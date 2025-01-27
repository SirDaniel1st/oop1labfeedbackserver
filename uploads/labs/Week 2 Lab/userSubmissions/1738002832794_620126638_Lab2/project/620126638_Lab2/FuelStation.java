public class FuelStation{
    private String fuelType = "gasoline";
    private double fuelVolume = 75000;
    private double fuelRate = 2;
    private double fuelSales = 0;
    
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
    
    public String toString(){
        return String.format("FUEL: %s VOL: %.1fL PRICE PER L: $%.2f SALES: $%.2f",
                         getFuelType(),
                         getFuelVolume(),
                         getFuelRate(),
                         getFuelSales());
    }
    
    private boolean sellFuel(double volume){
        if (volume <= getFuelVolume()) {
            fuelVolume = getFuelVolume() - volume;
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (fuelType == getFuelType()){
            return true;
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if (canDispenseFuelType(fuelType)){
            if (sellFuel(volume)){
                fuelSales += volume * fuelRate;
                return true;
            }
        }
        return false;
    }
}