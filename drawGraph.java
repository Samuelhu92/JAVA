/* Name: Shangyu Hu
 *Email: samuelhu92@brandeis.edu
 *Date: Oct16,2016
 *PA4-This is a program that draws some graphy consisted of * , /, \, and space
 *bugs: None
 */
public class drawGraph{
    public static void main(String[] args){
        for(int i=5;i>=0;i--){
            stars(i);
            space(5-i+1);
            slash(i*2);
            backslash(2*(5-i));
            space(5-i+1);
            stars(i);
            System.out.print("\n");
        }

    }
    public static void stars(int num){
        for(int i=1;i<=num;i++){
            System.out.print("*");
        }
    }
    public static void slash(int num){
        for(int i=1;i<=num;i++){
            System.out.print("/");
        }
    }
    public static void backslash(int num){
        for(int i=1;i<=num;i++){
            System.out.print("\\");
        }
    }
    public static void space(int num){
        for(int i=1;i<=num;i++){
            System.out.print(" ");
        }
    }
}