import java.util.*;
public class Problem3{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter price of item");
        System.out.println("(from 25 cents to a dollar, in 5-cents increments):");
        int price = console.nextInt();
        int change = 100 - price;
        int quarters = (price-price%25)/25;
        int dimes = (price-quarters*25)/10;
        int nickel = (price-quarters*25-dimes*10)/5;
        System.out.println("You bought an item for "+price+" cents and gave me a dollar, so your");
        System.out.println("change is:");
        System.out.println(quarters+" quarters,");
        System.out.println(dimes+" dimes,");
        System.out.println(nickel+" nickel");
    }
}