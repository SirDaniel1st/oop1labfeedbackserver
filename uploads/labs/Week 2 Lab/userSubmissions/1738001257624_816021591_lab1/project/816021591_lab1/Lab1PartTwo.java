import java.util.Scanner;

public class Lab1PartTwo{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Hi, What is your name?");
        String screenData=keyboard.nextLine();
        
        System.out.println("Nice to meet you " + screenData);
    }
}