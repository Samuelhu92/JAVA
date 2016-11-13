/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that calculates the factor of certain inputs.
 *Bugs: None
 */
import java.util.*;
public class Factor{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int first = console.nextInt();
        System.out.println("Enter the second number:");
        int second = console.nextInt();
        System.out.println("Enter the third number:");
        int third = console.nextInt();
        int[] number = {first,second,third};
        for(int i=0; i<=2; i++){
            System.out.println(number[i]+"! = "+factor(number[i]));
        }
    }
    public static int factor(int number){
        int result=1;
        for(int i=1; i<=number; i++){
            result*=i;
        }
        return result;
    }
}