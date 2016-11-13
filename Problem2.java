import java.util.*;
public class Problem2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a temperature in degrees Fahrenheit:");
        int degreesF = console.nextInt();
        double degreesC = (double)(5.0*(degreesF-32)/9.0);
        degreesC = (int)(degreesC*10)%10/10.0+(int)degreesC;
        System.out.println(degreesF+" degrees Fahrenheit is "+degreesC+" degrees Celsius.");

    }
}