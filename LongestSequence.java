/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA6-This is a program that find out the longest sequence(ascending) from a series numbers that
 *user input 
 *bugs: None
 */
import java.util.*;
public class LongestSequence{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("Tell me how many numbers you'd like to enter...");//prompts the user to determine the length of array
        int length=console.nextInt();
        int[] array=new int[length];
        for (int i=0;i<length;i++) {//create an array to store series of numbers
            System.out.println("Please enter a number...");
            int num=console.nextInt();
            array[i]=num;
        }
        int longest=longestSortedSequence(array);
        System.out.println("The longest ascending sequence has "+longest+" numbers.");
    }
    public static int longestSortedSequence(int[] array){
        if (array.length==0){
            return 0;
        } else {
            int largest=array[0];//store the current largest value, starts from the first element of the array
            int pivot=1;//a pointer store the current position
            int len=1;//store the length of current sequence
            int longest=0;
            while (pivot<array.length) {
                while (largest<=array[pivot]) {//compare the current largest one to the next value
                    largest=array[pivot];      //if the next number is larger than current largest then update largest value
                    pivot++;                   //move one position forward
                    len++;                     //add the continuous sequence length by one
                }
                if (longest<len){              //until the next number is less than the largest one, the sequence ends
                    longest=len;               //so update the longest sequence len by comparing the previous longest length with current length 
                }
                largest=array[pivot];          //when a sequence ends, set a new sequence start from the next index
                pivot++;                       //and adjust pivot and sequence length, then repeat
                len=1;
            }
            return longest;
        }
    }
}