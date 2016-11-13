/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA4-This is a program that treat a positive integer by some steps as follows:
 *If the value is even, halve it.
 *If it's odd, multiply by 3 and add 1.
 *Repeat this process until the value is 1, printing out each value.
 *Finally print out how many of these operations you performed. 
 *bugs: None
 */
import java.util.*;
public class numTreats{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("please enter a positive integer...");
        int num=console.nextInt();
        System.out.println("Initial value is: "+num);
        for (int i=num; i>1;i=num){
            if (num%2==0){
                num/=2;
            } else{
                num=num*3+1;
            }
            System.out.println("Next value is: "+num);
        }
    }
}