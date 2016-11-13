/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that calculate batting average of a player, the return was four digits length.
 *Bugs: None
 */

import java.util.*;
public class BattingAverage{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of times this player was at bat");
        int times = console.nextInt();
        System.out.println("Enter the number of hits he earned.");
        int hits = console.nextInt();
        double battingAverage = (double)hits/times;
        System.out.printf("The batting average of this player is %.4f.\n", battingAverage);
    }
}
