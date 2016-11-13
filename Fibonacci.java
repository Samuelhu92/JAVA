/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA3-This is a program that returns the first n(a input number) consecutive fibonacci numbers.
 *Bugs: None
 */
import java.util.*;
public class Fibonacci{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of finonacci sequence you want:");
        int number = console.nextInt();
        for(int i=0; i<number; i++){
            System.out.printf("%d ", fibonacci(i));
        }
    }
    public static int fibonacci(int number){
        if(number == 0){
            return 0;
        } else if(number == 1){
            return 1;
        } else {
            int a=0;
            int b=1;
            int result=0;
            for (int i=2;i<=number;i++){
                result=a+b;
                a=b;
                b=result;
            }
            return result;
        }
    }
}