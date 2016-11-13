import java.util.*;
public class Problem5{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of people attending the party:");
        int people = console.nextInt();
        System.out.println("Enter the diameter of the pizza you'd like to order:");
        double diameter = console.nextDouble();
        double radius = diameter/2;
        double size = 3.14*radius*radius;
        double totalSize = people*4*14.125;
        int num = (int)(totalSize/size)+1;
        System.out.println("You should buy "+num+" pizza.");   
    }
}