import java.util.*;
public class Problem1{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a four-digit positive integer.");
        int number = console.nextInt();
        int units = number%10;
        int tens = (number%100-units)/10;
        int hundreds = (number%1000-tens*10-units)/100;
        int thousands = (number-hundreds*100-tens*10-units)/1000;
        System.out.println(thousands);
        System.out.println(hundreds);
        System.out.println(tens);
        System.out.println(units);

    }

}