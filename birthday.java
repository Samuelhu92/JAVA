/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct21,2016
 *PA4-This is a program that compares two birthday and today's date. then returns that how many days 
 *remain until those birthdays and whihc one is sooner. The basic alogrithm is to set a pivot date 
 *which is 1/1. Compare three dates to the pivot date instead of comparing with each other since three
 *variable makes case more complicated.
 *Bugs: None
 */
import java.util.*;
public class birthday{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter today's date(month,day)...");//the month should be numerical format and with no zero appended.
        int monthToday = console.nextInt();
        int dayToday = console.nextInt();
        System.out.println("Please enter first friend birthday(month, day)...");
        int monthB1 = console.nextInt();
        int dayB1 = console.nextInt();
        System.out.println("Please enter the second friend birthday(month, day)...");
        int monthB2 = console.nextInt();
        int dayB2 = console.nextInt();
        int birth1ToPivot = daysToPivot(monthB1, dayB1);
        int birth2ToPivot = daysToPivot(monthB2, dayB2);
        int todayToPivot = daysToPivot(monthToday, dayToday);
        int daysToBirth1 = daysToBirthday(birth1ToPivot,todayToPivot,monthToday,dayToday,monthB1,dayB1);
        int daysToBirth2 = daysToBirthday(birth2ToPivot,todayToPivot,monthToday,dayToday,monthB2,dayB2);
        System.out.printf("The first friend's birthday is %d days away, and the second one's is %d days away\n", daysToBirth1, daysToBirth2);
        if (daysToBirth1 > daysToBirth2){
            System.out.println("The second friend's birthday is sooner.");
        } else {
            System.out.println("The first friend's birthday is sooner.");
        }
    }
    public static int daysToBirthday(int birthToPivot, int todayToPivot, int monthToday,int dayToday,int monthB, int dayB){
        int daysToBirth;
        if (monthB > monthToday){
            daysToBirth = todayToPivot - birthToPivot;
            return daysToBirth;
        } else if (monthB < monthToday){
            daysToBirth = 365-(todayToPivot-birthToPivot);
            return daysToBirth;
        } else if (monthB == monthToday){
            if (dayB < dayToday){
                daysToBirth = 365-(todayToPivot-birthToPivot);
                return daysToBirth;
            } else {
                daysToBirth = todayToPivot - birthToPivot;
                return daysToBirth;
            }
        }
        return 0;
    }
    public static int daysToPivot(int month, int day){
        int pivotMonth = 1;// instead of compare directly, compare both to a pivot date and compare again
        int pivotDay = 1;
        if (month>2 && month!=9){
                int num_days=(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31-1+day;
                return num_days;
                } else if (month==9){
                int num_days=(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31+day;
                return num_days;
                } else {
                int num_days=(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31+day;
                return num_days;
            }
    }

}
