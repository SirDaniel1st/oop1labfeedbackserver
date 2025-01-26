import java.util.Scanner;

public class HelloWorld{
    
    public static void main (String[] args){
   
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hi what's your name?" );
        String name=keyboard.nextLine();
        //String lastName = new String("Mohammed");
        System.out.println("Hello " + name  + " , nice to meet you!");
    }
}