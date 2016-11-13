/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct21,2016
 *PA4-This is a program that return the user the weekday of date that user input.
 *Bugs: None
 */
import java.util.*;
public class weekday{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int num_days=days(console)-1;
        int weekday=num_days%7+1;
        if (weekday==1){
            System.out.println("It's a Monday");
        } else if (weekday==2){
            System.out.println("It's a Tuesday");
        } else if (weekday==3){
            System.out.println("It's a Wednsday");
        } else if (weekday==4){
            System.out.println("It's a Thursday");
        } else if (weekday==5){
            System.out.println("It's a Friday");
        } else if (weekday==6){
            System.out.println("It's a Saturday");
        } else {
            System.out.println("It's a Sunday");
        }
        
    }
    public static int days(Scanner console){
        System.out.println("Please enter the year of your date...");
        int year=console.nextInt();
        System.out.println("Please enter the month of the date...(in numerical format, like 1,2,3...11,12)");
        int month=console.nextInt();
        System.out.println("Please enter the day of the date...(in numerical format,like 1,2,3...11,12...");
        int day=console.nextInt();
        int num_leap_years=(int)Math.floor((year-1601)/4)-(int)Math.floor((year-1601)/100)+(int)Math.floor((year-1601)/400);
        // Basically for the year there are two cases, leap year or not. when it is leap year we should consider
        // Feburary. As for month we have two special cases Feburary which has 28 or 29(leap year) days and July 
        // August that are adjacented months but both 31 days.
        if (year%400==0 || (year%4==0 && year%100!=0)){
            if (month>2 && month!=9){
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31-1+day;
                return num_days;
                } else if (month==9){
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31+day;
                return num_days;
                } else {
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31+day;
                return num_days;
            }
        } else {
            if (month>2 && month!=9){
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31-2+day;
                return num_days;
            } else if (month==9){
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31-1+day;
                return num_days;
            } else {
                int num_days=365*(year-1601)+num_leap_years+(month-1)/2*30+(int)Math.ceil((month-1)/2.0)*31+day;
                return num_days;
            }
        }
    }
}