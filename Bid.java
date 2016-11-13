/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Nov11,2016
 *PA6-This is a program that gives user the cloest smaller bid price against the real price
 *bugs: None
 */
import java.util.*;
public class Bid{
    public static void main(String[] args){
        Scanner console=new Scanner(System.in);
        System.out.println("Enter the right price");//prompts user to enter the right price
        int right=console.nextInt();
        System.out.println("How many bids there will be");
        int length=console.nextInt();
        int[] bids=new int[length];
        for (int i=0;i<length;i++) {
            System.out.println("Enter a bid price");
            bids[i]=console.nextInt();
        }
        int result=priceIsRight(bids,right);
        if (result!=-1) {
            System.out.println("The closest bid price is "+result);
        } else {
            System.out.println("All bids are too high");
        }
    }
    public static int priceIsRight(int[] bids, int rightPrice) {
        int closest=0;
        for (int i=0;i<bids.length;i++){
            if (bids[i]<=rightPrice){
                if (bids[i]>=closest) {
                    closest=bids[i];
                }
            }
        }
        if (closest>0){
            return closest;
        } else {
            return -1;
        }
    }
}