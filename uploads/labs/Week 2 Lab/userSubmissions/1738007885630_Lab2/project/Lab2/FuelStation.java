public class FuelStation{
    private String fuelType = "gasoline";
    private double fuelVolume = 75000;
    private double fuelRate = 2;
    private double fuelSales = 0;
    
    public FuelStation(){
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
    
    public String toString(){
        return "FUEL: " + fuelType + " VOL: " + fuelVolume + "L PRICE PER L: $" + String.format("%.2f",fuelRate) + " SALES: $" + String.format("%.2f", fuelSales);
    }
    
    
    public static void main(String[] args){
        FuelStation f = new FuelStation();
        System.out.print(f.toString());
    }
    
    private boolean sellFuel(double volume){
        if(fuelVolume >= volume){
            fuelVolume = fuelVolume - volume;
            
            fuelSales = fuelSales + (volume * fuelRate);
            
            return true;
        }
        
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        String myFuelType = getFuelType();
        
        if(fuelType == myFuelType){
            return true;
        }
        
        return false;
    }
    
    public boolean dispense(String fuelType, double volume){
        double myVolume = getFuelVolume();
        
        if(canDispenseFuelType(fuelType) && (myVolume >= volume)){
            sellFuel(volume);
            
            return true;
        }
        
        return false;
    }
}