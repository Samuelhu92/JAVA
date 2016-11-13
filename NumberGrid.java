/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that output a number grid.
 *Bugs: None
 */
import java.util.*;
public class NumberGrid{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter numbers of row and column:");
        int row = console.nextInt();
        int column = console.nextInt();
        for(int i=1; i<=row; i++){
            for(int k=1; k<=column; k++){
                System.out.print((i+row*(k-1))+"\t");
            }
            System.out.print("\n");
        }
    }
}