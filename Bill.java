/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that calculates the purchase bill and print it in a tidy format.
 *Bugs: None
 */

import java.util.*;
public class Bill{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        // here I am using array to store variables so that the process can be iterable
        // not sure whether it's beyond the coverage of the course.
        String[] item = new String[3];
        int[] quantity = new int[3];
        double[] price = new double[3];
        double[] total = new double[3];
        double subtotal=0;
        for(int i=0; i<=2; i++){
            System.out.println("Input name of item "+(i+1)+":");
            String[] parts = console.next().split("_");
            int length = parts.length;
            String newItem = "";
            for(int k=0;k<length;k++){
                newItem+=parts[k];
            }
            item[i] = newItem;
            System.out.println("Input quantity of item "+(i+1)+":");
            quantity[i] = console.nextInt();
            System.out.println("Input price of item "+(i+1)+":");
            price[i] = console.nextDouble();
            total[i] = price[i]*quantity[i];
            subtotal +=total[i];
        }
        System.out.println("Your bill:");
        System.out.printf("%-30s%-10s%-10s%-10s\n","Item","Quantity","Price","Total");
        for(int i=0;i<=2;i++){
            System.out.printf("%-30s%-10d%-10.2f%-10.2f\n",item[i],quantity[i],price[i],total[i]);
        }
        System.out.println();
        System.out.printf("%-50s%-10.2f\n","Subtotal", subtotal);
        System.out.printf("%-50s%-10.2f\n","6.25% sales tax", subtotal*0.0625);
        System.out.printf("%-50s%-10.2f\n","Total", subtotal*1.0625);       
    }
}