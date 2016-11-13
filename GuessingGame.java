/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct27,2016
 *PA5-This is a program that plays a number guessing game with user. The rule is pretty simple
 *user think up a number in the range that programme provide. then the computer will guess until 
 *the guess is correct. since there is no requirement of pseudorandom functions to make guesses.
 *I am using binary search algorithms.
 *Bugs: None
 */
import java.util.*;
public class GuessingGame{
    public static final int CONSTANT=100; 
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.printf("This is program allows you to play a guessing game.\nThink of a number between 1 and %d\nand I will guess until I get it.\nFor each guess, tell me if the\nright answer is higher or lower than your guess, or if it is corret.",CONSTANT);
        char again='y';
        int games=0;
        int totalGuesses=0;
        int maxGuess=0;
        do {
            System.out.println("Think of a number...");
            int low=1;
            int high=CONSTANT;
            int prevGuess=0;
            int[] result={low,high,0};
            String compare="Not yet";
            int count=0;
            do {
                result=guess(compare,prevGuess,low,high);
                prevGuess=result[2];
                low=result[0];
                high=result[1];
                System.out.println("My guess: "+prevGuess);
                System.out.println("Please tell me whether higher, lower or correct...");
                compare=console.next();
                count+=1;
            } while (!compare.equals("correct"));
            totalGuesses+=count;
            maxGuess=Math.max(maxGuess,count);
            System.out.println("I got it right in "+count+" guesses");
            System.out.println();
            System.out.println("Do you what to play again?");
            String nextRound=console.next();
            again=nextRound.toLowerCase().charAt(0);
            games+=1;
        } while (again=='y');
        System.out.printf("Overall results:\n\ttotal games   = %d\n\ttotal guesses = %d\n\tguesses/game  = %.1f\n\tmax guess   = %d\n",games,totalGuesses,totalGuesses/(double) games,maxGuess);
        
    }
    public static int[] guess (String compare, int prevGuess, int low, int high) {
        int mid=0;
        if (compare.equals("higher")){
            low=prevGuess+1;
        } else if (compare.equals("lower")){
            high=prevGuess-1;
        } 
        mid = (high+low)/2;
        return new int[] {low,high,mid};
    }
}