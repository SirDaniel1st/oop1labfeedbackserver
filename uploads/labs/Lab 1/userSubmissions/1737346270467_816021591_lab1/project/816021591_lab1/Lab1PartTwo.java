import java.util.Scanner;

public class Lab1PartTwo{
    
    public static void exercise1(){
        System.out.println("My name is Englebert");
    }
    
    public static void exercise2(){
         System.out.println("My name is Englebert"+" Humperdink");
    }    
    public static void exercise3(){
         System.out.println("My name is Student Joe");
    }
    
    public static void exercise4(){
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.println("My name is "+ name);
    }

     public static void exercise5(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, what's your name?");
        String name = keyboard.nextLine();
        System.out.println("Nice to meet you " + name +"!");

   } 
    
    public static void exercise6(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, what's your name?");
        String response = keyboard.nextLine(); 
        String name = response.substring(11,response.length());
        System.out.println("Nice to meet you " + name +"!");

   }
    
    public static void main(String[] args){
       
        /*
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        */
       String abracadabra = "abracadabra";
       String abc = abracadabra.substring(0,2) + abracadabra.substring(4,5);
       System.out.println(abc);
       
       
    }

}