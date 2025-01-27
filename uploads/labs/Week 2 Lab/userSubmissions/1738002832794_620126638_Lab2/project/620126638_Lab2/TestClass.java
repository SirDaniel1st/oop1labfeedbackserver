import java.util.Scanner;

public class TestClass{
    
    public static void main(String[] args){
        FuelStation fstation = new FuelStation();
        Scanner sc= new Scanner(System.in);
        System.out.println(fstation.toString());
        while(fstation.getFuelVolume()!=0){
            System.out.println("Enter FuelType");
            String myFuelType= sc.nextLine();
            System.out.println("Enter FuelTVolume");
            double myVolume= sc.nextDouble();
            if (fstation.dispense(myFuelType,myVolume)){
                System.out.println("Sucess");
                System.out.println(fstation.toString());
            }
            else{
                System.out.println("Failure");
                System.out.println(fstation.toString());
            }
        }
    }
}