import java.util.Scanner;
import java.util.Random;

public class Lab1PartThree{
    public static void exercise1(){
        Scanner keyboard = new Scanner(System.in);
        String radius = keyboard.nextLine();
        double r = Double.parseDouble(radius);
        
        double area = Math.PI * Math.pow (r,2);
        
        System.out.format("A circle with a radius " + r + " has an area of "  + "%.2f",area); 
        
        
    }
    
    public static void exercise2(){
        Scanner keyboard = new Scanner(System.in);
        String n = keyboard.nextLine();
        int nInt = Integer.parseInt(n);
        
        int evenNumbers = 0;
        
        System.out.print("Even numbers from " + n + " :");
        
        while (evenNumbers <= nInt) {
            System.out.print(" " + evenNumbers);
            evenNumbers = evenNumbers + 2;
        }
        
        
        
    }
    
   public static void exercise3(){
        Random r = new Random();
        int someRandomInt1 = r.nextInt(999);
        int someRandomInt2 = r.nextInt(999);
        
        System.out.println("What is the product of " + someRandomInt1 + " and " + someRandomInt2 + " ?");
        
        int product = someRandomInt1 * someRandomInt2;
        
        System.out.println("The answer is " + product);
        
    }
    
   public static void exercise4(){
        String[] intros;
        intros = new String[3];
        intros[0] = "hi";
        intros[1] = "hey";
        intros[2] = "howdy-doo";
        
        Random intro = new Random();
        Scanner keyboard = new Scanner(System.in);
        
        
        while (true){
            int randomIntro = intro.nextInt(3);
            System.out.println(intros[randomIntro]);
            
            String userIntro = keyboard.nextLine();
            
            if (userIntro.equalsIgnoreCase("exit")){
                break;
            }
        
    }
    
    keyboard.close();
    
}
    
    public static void main (String[] args){
        exercise1();
        exercise2();
        exercise3();
        exercise4();
    }
}