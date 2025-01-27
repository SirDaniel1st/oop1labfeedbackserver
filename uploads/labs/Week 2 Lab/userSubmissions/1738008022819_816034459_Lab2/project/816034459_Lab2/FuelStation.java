public class FuelStation{
        private String fuelType;
        private double fuelVolume;
        private double fuelRate;
        private double fuelSales;
        
        //no argument constructor
        public FuelStation(){
            fuelType="gasoline";
            fuelVolume=75000;
            fuelRate=2;
            fuelSales=0;            
        }
        
        //accessors
        public String getFuelType(){
            return fuelType;
        }
        
        public double getFuelVolume(){
            return fuelVolume;
        }
        
        public double getFuelrate(){
            return fuelRate;
        }
        
        public double getFuelSales(){
            return fuelSales;
        }
        
        public String toString(){
            return ("FUEL:"+fuelType+" VOL:"+fuelVolume+" PRICE PER L:"+String.format("%.02f",fuelRate)+" SALES:$"+String.format("%.02f",fuelSales));
        }
        
        private boolean sellFuel(double volume){
            if(fuelVolume>volume){
                fuelVolume=fuelVolume-volume;
                fuelSales=fuelSales+(volume*fuelRate);
                return true;
            }
            return false;
        }
        
        public boolean canDispenseFuelType(String fuelType){
            if(fuelType!=null){
                return fuelType.equals(this.fuelType); //if (fuelType==getFuelType())
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
