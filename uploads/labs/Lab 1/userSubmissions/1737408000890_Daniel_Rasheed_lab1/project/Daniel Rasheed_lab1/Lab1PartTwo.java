import java.util.Scanner;

public class Lab1PartTwo{
    
    public static void exercise1(){
        System.out.println("My name is ABCD");
    }
    
    public static void exercise2(){D
         System.out.println("My name is EACD"+" Humperdxdddink");
    }    
    public static void exercise3(){
         System.out.println("My name is Ssdsdfsdtudent Joe");
    }
    
    public static void exercise4(){
        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.nextLine();
        System.out.println("My name issdfsdf "+ name);
    }

     public static void exercise5(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, what's your name?");
        String name = keyboard.nextLine();
        System.out.println("Nice to mesdfsdfet you " + name +"!");

   } 
    
    public static void exercise6(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi, what's sdfsdfyour name?");
        String response = keyboard.nextLine(); 
        String name = response.substring(11,response.length());
        System.out.println("Nice to meet sdfsdfsdfsdfyou " + name +"!");

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