public class FuelStation {
    
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation() {
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2;
        fuelSales = 0;
    }
    
    public String getFuelType() {
        return fuelType;
    }
    
    public double getFuelVolume() {
        return fuelVolume;
    }
    
    public double getFuelRate() {
        return fuelRate;
    }
    
    public double getFuelSales() {
        return fuelSales;
    }
    
    public String toString() {
        return "FUEL: " + getFuelType() + " VOL: " + getFuelVolume() + " PRICE PER L: $" + getFuelRate() + " SALES: $" + getFuelSales();
    }
    
    private boolean sellFuel(double volume)  {
        if (fuelVolume >= volume) {
            fuelVolume = fuelVolume - volume;
            fuelSales = fuelSales + (fuelRate * volume);
            return true; 
        }
        else {
            return false;
        }
    }
    
    public boolean canDispenseFuelType(String fuelType) {
        if(fuelType != null) {
            return fuelType.equals(getFuelType());
        }
        else {
            return false;
        }
    }
    
    public boolean dispense(String fuelType, double volume) {
        if (canDispenseFuelType(fuelType)) {
                return sellFuel(volume);
        }
        else {
            return false;
        }
    }   
}