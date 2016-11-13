/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA4-This is a program that convert a Arabic number into a Roman number
 *in the case that the range is less than 5000, so that the limitation that at most three
 *same consecutive Roman symbols is not applicable in thousand digit.
 *Bugs: None
 */
import java.util.*;
public class intToRoman{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter the number you'd like to convert...");
        int num = console.nextInt();
        String roman = toRoman(num);
        System.out.printf("The Roman number of %d is %s\n", num, roman);
    }
    public static String toRoman(int num){
        String result = "";
        for (int i=num; i>0; i=i/10){
            String numStr = String.valueOf(i);
            String symbol1 = "";
            String symbol2 = "";
            String symbol3 = "";

            if (numStr.length()==4){
                symbol1 = "I"; symbol2 = "V"; symbol3 = "X";
            } else if (numStr.length()==3){
                symbol1 = "X"; symbol2 = "L"; symbol3 = "C";
            } else if (numStr.length()==2){
                symbol1 = "C"; symbol2 = "D"; symbol3 = "M";
            } else if (numStr.length()==1){
                symbol1 = "M"; symbol2 = "MMM"; symbol3 = "";
            }
            result = toRoman_new(i%10, symbol1, symbol2, symbol3)+result;
        }
        return result;
    }
    public static String toRoman_new(int v, String symbol1, String symbol2, String symbol3){
        String result = "";
        if (v<=3){
            for(int i=v; i>0; i--){
                result = symbol1 + result;
            }
        } else if (v == 4){
            result = symbol1 + symbol2;
        } else if (v > 5 && v < 9){
            result = symbol2;
            for (int i=v; i>5; i--){
                result = result + symbol1;
            }
        } else if (v == 9){
            result = symbol1+symbol3;
        }
        return result;
    }
}