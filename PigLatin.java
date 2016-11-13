/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct4,2016
 *PA3-This is a program that implementing some fancy word transformation.
 *Bugs: None
 */
import java.util.*;
public class PigLatin{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your first name.");
        String first = console.next();
        System.out.println("Enter your last name.");
        String last = console.next();
        String newFirst = first.toLowerCase().substring(1,2).toUpperCase()+first.toLowerCase().substring(2)+first.toLowerCase().substring(0,1)+"ay";
        String newLast = last.toLowerCase().substring(1,2).toUpperCase()+last.toLowerCase().substring(2)+last.toLowerCase().substring(0,1)+"ay";
        System.out.println(newFirst+" "+newLast);
    }
}