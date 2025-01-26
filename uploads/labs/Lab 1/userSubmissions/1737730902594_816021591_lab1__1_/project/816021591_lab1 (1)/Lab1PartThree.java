import java.util.Scanner;
import java.util.Random;
public class Lab1PartThree{
    
    public static void exercise1(){
        //Area of circle = pi * r *r
        Scanner keyboard = new Scanner(System.in);
        double radius = keyboard.nextDouble();
        double area = radius * radius * java.lang.Math.PI;
        System.out.println("A circle with radius " + radius + " has an area of " + String.format("%.02f", area) + " units");
        
    }
    
    public static void exercise2(){
         // number / 2 = no remainder
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Enter a positive integer");
         int n = keyboard.nextInt();
         System.out.println("Even numbers from " + n + " : ");
         int count = 1;
         while(count <= n){
           if(count % 2 == 0) {
               System.out.print( count + " " );
           }
           count ++;
        }
    }  
    
    public static void exercise3(){
         Random r = new Random();   
         int num1 = r.nextInt(999);
         int num2 = r.nextInt(999);
         int answer = num1 * num2;
         System.out.println("What is the product of " + num1 + " and " + num2 + " ?");
         System.out.println("The answer is " + answer );
   
    }

    public static void exercise4(){
         Scanner keyboard = new Scanner(System.in);
         System.out.println("hi");
         String response = keyboard.nextLine();
         String[] triggerWords = {"hey", "howdy-doo", "oye"};
         java.util.Random r = new java.util.Random();     
         while(!response.equals("exit")){
             System.out.println(triggerWords[r.nextInt(3)]);
             response = keyboard.nextLine(); 
             
         }
    }
    


    
    public static void main(String[] args){
       
        /* exercise1();
        exercise2();
        exercise3();
        */
        exercise4();
        
    }

}
