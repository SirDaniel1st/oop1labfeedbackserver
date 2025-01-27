
/**
 * Write a description of class FuelStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FuelStation
{
    // instance variables - replace the example below with your own
    private String fuelType;
    private double fuelVolume;
    private double fuelRate;
    private double fuelSales;
    /**
     * Constructor for objects of class FuelStation
     */
    public FuelStation()
    {
        fuelType="gasoline";
        fuelVolume=75000;
        fuelRate=2;
        fuelSales=0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getfuelType(){ //Accessors
        return fuelType;}
    public double getfuelVolume(){
    return fuelVolume;}
    public double getfuelRate (){
    return fuelRate;}
    public double getfuelSales(){
    return fuelSales;}
    
    public String toString(){
        return("FUEL:" + fuelType +"Volume: " + fuelVolume +"Price per L: $" +String.format("%.02f",fuelRate)+"Sales:$" + String.format("%.2f",fuelSales));
    }
    
    private boolean sellFuel(double volume){
        
        if(this.fuelVolume>volume){
            fuelVolume=fuelVolume-volume;
            fuelSales=volume+fuelRate;
            return true;
        }
        return false;
    }
    
    public boolean canDispenseFuelType(String fuelType){
        if(fuelType!=null){
            return fuelType.equals(getfuelType());
        }
        return false;
    }
    
    public boolean dispense (String fuelType, double volume){
        if(canDispenseFuelType(fuelType)){
            return sellFuel(volume);
        }
        return false;
    }
    }

