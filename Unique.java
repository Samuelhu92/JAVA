/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Nov11,2016
 *PA6-This is a program that determine whether the series of numbers that user inputs
 *show more than once, if so the return will be boolean False, otherwise,True. 
 *bugs: None
 */
import java.util.*;
public class Unique{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("How many numbers you're going to enter...");//prompt user to define the length of array 
        int length=console.nextInt();
        int[] array=new int[length];//declare and initialize a new array
        for (int i=0;i<length;i++) {//use iteration to assign value that user enters into array
            System.out.println("Enter a number...");
            int num=console.nextInt();
            array[i]=num;
        }
        boolean isUnique=isUnique(array);
        if (isUnique) {
            System.out.println("All numbers you enter are unique.");
        } else {
            System.out.println("Numbers are not unique,One or more than one number you entered more than once.");
        }
    }
    public static boolean isUnique(int[] array) {
        for (int i=0;i<array.length;i++){//traverse the array and each time the num only compares to number that is located behind
            int num=array[i];            // if any one else equals to the number return false, else if no false return until the end of traversal returns true
            for (int j=i;j<array.length;j++){
                if (num==array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}