public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation(){
        this.fuelType="gasoline";
        this.fuelVolume=75000;
        this.fuelRate=2;
        this.fuelSales=0;
    }
    
    public String getType(){
        return fuelType;
    }
    
    public double getVolume(){
        return fuelVolume;
    }
    
    public double getRate(){
        return fuelRate;
    }
    
    public double getSales(){
        return fuelSales;
    }
    
    public String toString(){
        return ("FUEL:" + getType() + " VOL:" + String.format("%.1f",getVolume()) + "L PRICE PER L:$" + String.format("%.2f",getRate()) + " SALES:$" + String.format("%.2f",getSales()));
    }
    
    private boolean sellFuel(double volume){
        if(volume<0 || volume>this.fuelVolume){
            return false;
        }
        this.fuelSales += (volume * this.fuelRate);
        this.fuelVolume -= volume;

        return true;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType != null){
            return fuelType.equals(this.fuelType);
        }
        return false;
    }
    
    public boolean dispense(String fuelType,double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
}
