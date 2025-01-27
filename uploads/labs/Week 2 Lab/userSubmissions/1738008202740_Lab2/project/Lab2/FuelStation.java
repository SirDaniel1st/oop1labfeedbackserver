public class FuelStation{
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    
    public FuelStation( ){
    String fuelType ="gasoline";
    double fuelVolume = 75000;
    double fuelRate = 2;
    double fuelSales = 0;
    }
    
    //Accessors
    public String getFuelType(){ return fuelType;}
    public double getFuelVolume(){return fuelVolume;}
    public double getFuelRate(){return fuelRate;}
    public double getFuelSales(){return fuelSales;}
    
    public String toString(){
        return ("FUEL:"+fuelType+" VOL:"+fuelVolume+" PRICE PER L:$"+String.format("%.02f",fuelRate)+" SALES:$"+String.format("%.02f",fuelSales));
    }
    
    //Methods
    private boolean sellFuel(double volume){
        if(fuelVolume>volume){
            fuelVolume=fuelVolume - volume;
            fuelSales = volume*fuelRate;
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType!= null){
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





