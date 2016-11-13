/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA4-This is a program that convert a binary number into a decimal number
 *the input is a binary number and the program print out it's decimal number.
 *Bugs: None
 */
import java.util.*;
public class binaryToDecimal{
    public static void main (String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("Please enter a binary number you'd like to convert...");
        String num=console.next();
        int result=0;
        for(int i=(num.length()-1);i>=0;i--){
            if(num.charAt(i)=='1'){
            result+=Math.pow(2,num.length()-1-i);
            }
        }
        System.out.printf("The decimal number of binary %s is %d.\n", num, result); 
    }
    public static String weekday(Scanner console){
        
    }
}