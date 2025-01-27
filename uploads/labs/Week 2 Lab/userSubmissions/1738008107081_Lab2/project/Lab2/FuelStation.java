public class FuelStation{
  
        private String fuelType;
        private double fuelVolume;
        private double fuelRate;
        private double fuelSales;
        
        public FuelStation(){
            fuelType ="gasoline";
            fuelVolume = 75000.0;
            fuelRate=2.0;
            fuelSales=0;
        }
        //Accessors
        public String getfuelType(){return fuelType;}
        public double getfuelVolume(){return fuelVolume;}
        public double getfuelRate(){return fuelRate;}
        public double getfuelSales(){return fuelSales;}

        
        public String toString(){
            return "FUEL:" + fuelType +" Vol:" + fuelVolume + "L PRICE PER L: $" + fuelRate +" SALES: $" +fuelSales;
        }
        
        private boolean sellFuel(double volume){
            if(this.fuelVolume>volume){
                this.fuelVolume = this.fuelVolume - volume;
                this.fuelSales = volume * this.fuelRate;
                return true;
            }
            return false;
        }
        
        public boolean canDispenseFuelType(String fuelType){
            if(this.fuelType != null){
                return fuelType.equals(this.fuelType); // if (fuelType == getFuelType())
            }
            return false;
        }
    
        public boolean dispense(String fuelType, double volume){
            if(canDispenseFuelType(fuelType) ){
                return sellFuel(volume);
            }
            return false;
        }
}
