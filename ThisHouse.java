/* Name: Shangyu Hu
 * Email: samuelhu92@brandeis.edu
 * Date: Sept 6, 2016
 */

public class ThisHouse{
//This class is defined to print out a nursery rhyme
// output will be displayed as lines of strings
    public static void main(String[] args){
        verseOne();
        verseTwo();
        verseThree();
        verseFour();
        verseFive();
        verseSix();
        verseSeven();
    }
    // Define seven verses that using methods that generating repeated contents
    public static void verseOne(){
        // This method create verse one with a blank line.
        System.out.println("This is the house that Jack built.");
        System.out.println();
    }
    public static void verseTwo(){
        // This method create verse two with a blank line.
        System.out.println("This is the malt");
        jackHouse();
    }
    public static void verseThree(){
        // This method create verse three with a blank line.
        System.out.println("This is the rat,");
        ateMalt();
    }
    public static void verseFour(){
        // This method create verse four with a blank line.
        System.out.println("This is the cat,");
        killRat();
    }
    public static void verseFive(){
        // This method create verse five with a blank line.
        System.out.println("This is the dog,");
        worriedCat();
    }
    public static void verseSix(){
        // This method create verse six with a blank line.
        System.out.println("This is the cow with the crumpled horn,");
        tossedDog();
    }
    public static void verseSeven(){
        // This method create verse seven with a blank line.
        System.out.println("This is the maiden all forlorn,");
        milkedCow();
    }
    // define repeated content displayed in seven verses 
    public static void jackHouse(){
        System.out.println("That lay in the house that Jack built.");
        System.out.println();
    }
    public static void ateMalt(){
        System.out.println("That ate the malt");
        jackHouse();
    }
    public static void killRat(){
        System.out.println("That killed the rat,");
        ateMalt();
    }
    public static void worriedCat(){
        System.out.println("That worried the cat,");
        killRat();
    }
    public static void tossedDog(){
        System.out.println("That tossed the dog,");
        worriedCat();
    }
    public static void milkedCow(){
        System.out.println("That milked the cow with the crumpled horn,");
        tossedDog();
    }
}