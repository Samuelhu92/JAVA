/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct27,2016
 *PA5-This is a program that plays the Rock,Paper and Scissor game with user. The Rule
 * of the game is simple, user pick one item from above three each time and computer does
 * so, then compare, Rock defeat Scissor, Scissor defeat Paper and Paper defeat Rock. The 
 * user can choose alogrithms computer use to pick one is as random as user does another 
 * one is based on the recent 10 user's behaviors. 
 *Bugs: None
 */
import java.util.*;
public class RockPaperScissor{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("Please choose the game strategy that you'd like to play with...(Random,Advanced)");
        String strategy=console.next();
        while (!(strategy.equals("Random") || strategy.equals("Advanced"))){
            System.out.println("Please enter the valid strategy");
            strategy=console.next();
        }
        System.out.println("enetr start to start, else enter exit to exit");
        String start=console.next();
        int count=0;
        int win=0;
        int[] history=new int[10];
        while (start.equals("start") || start.equals("continue")){
            count+=1;
            System.out.println("Please choose an item...(Rock,Paper,Scissor)");
            String item = console.next();
            int userChoice;
            while (!(item.equals("Rock") || item.equals("Paper") || item.equals("Scissor"))){
                System.out.println("Please enter a valid choice");
                item=console.next();
            }
            if (item.equals("Rock")){
                userChoice=0;
            } else if (item.equals("Paper")){
                userChoice=1;
            } else {
                userChoice=2;
            }
            int[] result={0,0};
            if (strategy.equals("Random")){
                result=random(userChoice);
            } else if (strategy.equals("Advanced")){
                result=advanced(userChoice, history);
                history[count%10-1]=userChoice;
            }
            String compChoice="";
            switch (result[1]){
                case 0:
                    compChoice="Rock";
                    break;
                case 1:
                    compChoice="Paper";
                    break;
                case 2:
                    compChoice="Scissor";
                    break;
            }
            if (result[0]==1){
                win+=1;
                System.out.println("The computer chose "+compChoice+". You win!");
            } else if (result[0]==0){
                System.out.println("The computer chose "+compChoice+". Tied.");
            } else {
                System.out.println("The computer chose "+compChoice+". You lose.");
            }
            System.out.println("enetr continue to continue, else enter exit to exit");
            start=console.next();
        }
        System.out.printf("You played %d games and you won %d of them.\n", count, win);
    } 
    public static int[] advanced(int userChoice, int[] history){
        Random rand=new Random();
        int result=-2;
        int rock=0;int paper=0;int scissor=0;
        int compChoice=0;
        for (int i=0;i<history.length;i++){
            if (history[i]==0){
                rock+=1;
            } else if (history[i]==1){
                paper+=1;
            } else if(history[i]==2){
                scissor+=1;
            }
        }
        if (rock >5 ){
            if (rock >=8){
                compChoice=rand.nextInt(2);  // when among 10th recent history, rock counts more than 80%
            } else {                         // computer only choose from Rock and paper
                compChoice=rand.nextInt(4);  // when history result rock has 50% to 80%, computer has 50% p
                if (compChoice==3){          // to choose paper.
                    compChoice=1;
                } else {
                    compChoice=compChoice;
                }
            }
        } else if (paper > 5){
            if (paper>=8){
                compChoice=rand.nextInt(2)+1;
            } else {
                compChoice=rand.nextInt(4);
                if (compChoice==3){
                    compChoice=2;
                }
            }
        } else if (scissor>5){
            if (scissor>=8){
                compChoice=rand.nextInt(2);
                if (compChoice==1){
                    compChoice=2;
                } else {
                    compChoice=compChoice;
                }
            } else {
                compChoice=rand.nextInt(4);
                if (compChoice==3){
                    compChoice=0;
                } else {
                    compChoice=compChoice;
                }
            }
        } else {
            compChoice=rand.nextInt(3);
        }
        int battle=userChoice-compChoice;
        switch (battle) {
            case 2:
                result=-1;
                break;
            case -1:
                result=-1;
                break;
            case 1:
                result=1;
                break;
            case -2:
                result=1;
                break;
            case 0:
                result=0;
                break;
        }
        return new int[] {result, compChoice};
    }
    public static int[] random(int userChoice){
        Random rand=new Random();
        int result=-2;
        int compChoice=rand.nextInt(3);
        int battle=userChoice-compChoice;
        switch (battle) {
            case 2:
                result=-1;
                break;
            case -1:
                result=-1;
                break;
            case 1:
                result=1;
                break;
            case -2:
                result=1;
                break;
            case 0:
                result=0;
                break;
            }
        return new int[] {result, compChoice};
    }
}