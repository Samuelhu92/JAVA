/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct27,2016
 *PA5-This is a program that plays the triditional Hangman game with user, user input a word and its 
 *letter number, and the computer would guess each letter, each round when computer gives its guess user
 *would decide whether the letter in the word if yes, user should also tell how many letters in theword
 *additionally, I add one more question about the position the letter in the word in order to print the 
 *already guessed word. While if guessed letter isn't in the word, "the man" is one step closer to death.
 *accumulated 7 wrongs lead to a gameover and the user win.
 *Bugs: None
 */

import java.util.*;
public class Hangman{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.printf("This program plays a game of reverse hangman.\nYou think up a word(by typing it on the computer) and I'll try to guess\nthe letters.");
        System.out.printf("\nHow many letters are in your word?\n");
        int length=console.nextInt();
        System.out.println("Please enter the word for me to guess(letters only):");
        String wordForGuess=console.next();
        while (wordForGuess.length()!=length){                  // check whether the length user enter matches the length of word entered
            System.out.printf("Sorry, it seems the length of word you'd like me to guess is not %d. Please verify again.\n",length);
            System.out.println("Please enter the word for me to guess(letters only):");
            wordForGuess=console.next();
        }
        String guess="";                                        // generate a original word slot
        for (int i=0;i<length;i++){
            guess+="-";
        }                                      
        String alreadyGuess="";                                 // store Chars that already guessed
        int countWrong=0;                                       // count wrong times
        int countCorrect=0;                                     // count correct letters
        do {
            Random rand=new Random();
            System.out.println();
            printWordSlot(guess);
            hangManGra(countWrong);
            System.out.printf("I've got %d of the %d letters so far\n",countCorrect,length);
            char guessChar=(char)(rand.nextInt(26)+97);
            while (!checkRepeat(alreadyGuess,guessChar)){              // check whether random      
                guessChar=(char)(rand.nextInt(26)+97);
            }
            alreadyGuess+=guessChar;
            String troublesome=""+guessChar; 
            System.out.println("I guess:"+troublesome.toUpperCase());
            System.out.println("Is that letter in the word?(y or n)");
            String judge=console.next();
            // this part accords to user's response if guess is correct, then ask for number of repeated
            // number and the position of each. renew the guess word slot and update those counts number
            // if failed just update count wrong number. Repeat the process until the word was completed 
            // or "the man" was hanged.
            if (judge.equals("y")){                                                                         
                System.out.println("How many of the letter are in the word?");
                int times=console.nextInt();
                while (times<=0 || times>(length-countCorrect)){
                    System.out.println("it seems the number you entered is invalid,please check");
                    times=console.nextInt();
                }
                if (times==1){
                    System.out.println("Then tell me the position of the letter in the word(position start from 0)");
                    int position1=console.nextInt();
                    guess=guessWord(guess,guessChar,position1);
                    countCorrect+=1;
                } else{
                    int i=1;
                    System.out.println("Then tell me the position of the letter in the word(position start from 0)");
                    int position2=console.nextInt();
                    guess=guessWord(guess,guessChar,position2);
                    countCorrect+=1;
                    do {
                        System.out.println("Then tell me another position of the letter in the word(position start from 0)");
                        int position3=console.nextInt();
                        guess=guessWord(guess,guessChar,position3);
                        i+=1;
                        countCorrect+=1;
                    } while (i<times);
                System.out.println(guess);
                }
            } else if (judge.equals("n")){
                countWrong+=1;
            }
        } while (countWrong<7 && countCorrect!=length);
        if (countCorrect==length){
            System.out.println("Yeap, I win this time. The word is "+guess);
        } else {
            hangManGra(6);
            System.out.println("You beat me this time.");
        }
    }
    public static Boolean checkRepeat(String word,char guessChar){ // the method is used to check whether the generated char was guessed before
        for (int i=0;i<word.length();i++){
            if (word.charAt(i)==guessChar){
                return false;
            } 
        }
        return true;
    }
    public static void printWordSlot(String word){ // the method print the partial word guessed already, each letters was sepreated by a space
        for (int i=0;i<word.length();i++){
            System.out.print(word.charAt(i)+" ");
        }
        System.out.print("\n");
    }
    public static String guessWord(String original, char character, int position){ // the method is to update the partial word that guessed according the information user provide
        if (position==original.length()-1){
            String left=original.substring(0,position);
            String c=""+character;
            String newWord=left+c;
            return newWord;
        } else if (position==0){
            String right=original.substring(position+1);
            String c=""+character;
            String newWord=c+right;
            return newWord;
        } else {
            String left=original.substring(0,position);
            String right=original.substring(position+1);
            String c=""+character;
            String newWord=left+c+right;
            return newWord;
        }
    }
    public static void hangManGra(int steps){   // the method draws how a man was hanged step by step
        System.out.printf(" +--+  \n |  |\n");  // the first line and second line are all the same
        if (steps==0){                          // the third line changes after first wrong 
            System.out.printf(" |\n");
        } else {
            System.out.printf(" |  o\n");
        }
        if (steps<2){                           // the forth line has 4 patterns.
            System.out.printf(" |\n");
        } else if (steps>=2 && steps <5){
            System.out.printf(" |  |\n");
        } else if (steps==5){
            System.out.printf(" |  |\\\n");
        } else {
            System.out.printf(" | /|\\\n");
        }
        if (steps<3){                           // the fifth line has three patterns
            System.out.printf(" |\n");
        } else if (steps==3){
            System.out.printf(" |   \\\n");
        } else {
            System.out.printf(" | / \\\n");
        }
        System.out.printf(" |\n");
        System.out.printf(" +-----\n");
    }
}