public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        this.fuelType = "gasoline";
        this.fuelVolume = 75000.00;
        this.fuelRate = 2.00;
        this.fuelSales = 0.00;
    }
    
    public String getType(){
        return this.fuelType;
    }
    
    public double getVolume(){
        return this.fuelVolume;
    }
    
    public double getRate(){
        return this.fuelRate;
    }
    
    public double getSales(){
        return this.fuelSales;
    }
    
    public String toString(){
        return ("FUEL: " + getType() + " VOL: " + getVolume() + "L PRICE PER L: $" + getRate() + " SALES: $" + getSales());
    }
    
    private boolean sellFuel(double volume){
        if (getVolume() >= volume){
            this.fuelVolume = getVolume() - volume;
            this.fuelSales = this.fuelSales + (volume * getRate());
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if (getType() == fuelType){
            return true;
        }
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        if ((getType() == fuelType) && (getVolume() >= volume)){
            boolean fill = this.sellFuel(volume);
            return true;
        }
        return false;
    }
}
