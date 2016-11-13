import java.util.*;
public class Problem4{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the diameter of the pizza in inches:");
        double diameter = console.nextDouble();
        double radius = diameter/2;
        double size = 3.14*radius*radius;
        int slice = (int)(size/14.125);
        System.out.println("You may have "+slice+" slices.");
    }
}