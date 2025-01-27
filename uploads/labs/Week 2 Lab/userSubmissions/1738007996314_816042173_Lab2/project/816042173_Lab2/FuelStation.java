public class FuelStation {
    private String fuelType = "gasoline";
    private double fuelVolume = 75000;
    private double fuelRate = 2;
    private double fuelSales = 0;
    
    public FuelStation() {
        fuelType = "gasoline";
        fuelVolume = 75000;
        fuelRate = 2;
        fuelSales = 0;
    }
    
    public String getFuelType() {return fuelType;}
    public double getFuelVolume() {return fuelVolume;}
    public double getFuelRate() {return fuelRate;}
    public double getFuelSales() {return fuelSales;}
    
    public String toString() {
        return getFuelType() + " VOL: " + getFuelVolume() + "L PRICE PER L: $" + getFuelRate() + " SALES: $" + getFuelSales();
    }
    
    public void setFuelType (String fuelType) {
        this.fuelType = fuelType;
    }
    
    public void setFuelVolume (double fuelVolume) {
        if (fuelVolume > 0) {
            this.fuelVolume = fuelVolume;
        }
    }
    
    public void setFuelRate (double fuelRate) {
        if (fuelRate > 0) {
            this.fuelRate = fuelRate;
        }
    }
    
    public void setFuelSales (double fuelSales) {
        if (fuelSales > 0) {
            this.fuelSales = fuelSales;
        }
    }
    
    private boolean sellFuel(double volume) {
        if (this.fuelVolume > volume) {
            fuelVolume = fuelVolume - volume;
            fuelSales = fuelSales + (volume * fuelRate);        
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType (String fueltype) {
        if (fuelType != null) {
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense (String fuelType, double volume) {
        if (canDispenseFuelType(fuelType)) {
            return sellFuel(volume);
        }
        return false;
    }
}