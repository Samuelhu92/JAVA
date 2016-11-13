import java.util.*;
public class Problem6{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of cookies you'd like to make:");
        int num = console.nextInt();
        //massy way to keep one decimal in results.
        double sugar  = (int)(1.5/48*num)+(int)(1.5/48*num*10)%10/10.0;
        double butter = (int)(1.0/48*num)+(int)(1.0/48*num*10)%10/10.0;
        double flour = (int)(2.75/48*num)+(int)(2.75/48*num*10)%10/10.0;
        System.out.println("To make "+num+" cookies you need:");
        System.out.println(sugar+" cups of sugur");
        System.out.println(butter+" cups of butter");
        System.out.println(flour+" cups of flour");
    }
}