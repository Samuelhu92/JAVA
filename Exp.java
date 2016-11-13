/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that calculate the expotential number of 2.
 *Bugs: None
 */
import java.util.*;
public class Exp{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter an integer for operation.");
        int number = console.nextInt();
        for(int i=0;i<=number;i++){
            int results=1;
            for(int j=0;j<i;j++){
                results *= 2;
            }
            System.out.println(results);
        }
    }
}