/**
 * datedaycalculate.java
 * mhowse march 2016
 */
package smallprojectsgit;
import java.util.*;



/** Will take a date from the user, and calculate the day of the week that day is. */
public class datedaycalculate{    
    private static int year;
    private static int month;
    private static int day;
    private int jan, feb, march,april,may, june,july, aug,sept, oct,nov,dec;
 /**
     * @param args the command line arguments
     */
public static void main (String[] args){
simpleInput();
calculate();
}//end main method

private static void calculate(){
    int r = year -1900;
    int res = (r/4)+ (r*365);
    if (isLeapYear(year)){
        if (month<3){
            res--;
        }
    }
    
   
}

public static boolean isLeapYear(int y) {
        if (y % 4 != 0){
           return false;
        }
        else if (y % 100 != 0){
            return true;
        }
        else if (y % 400 != 0) {
            return false;
        }
         return true;
    }


/**
 * simpleInput takes the user input, directs the user quite throughly, to make it easier to process the date. 
 */
private static void simpleInput(){
   Scanner scan = new Scanner(System.in);
System.out.println("Enter in the year. As a number, so 1993 instead of nineteen ninety three. ");
    year=scan.nextInt();
    System.out.println("Enter in the month as a number, so january = 1; ect"); 
    month =scan.next();
    System.out.println("Enter in the day of the month as a number i.e. 10, 12, 13");
    day = scan.nextInt();
}//end method

}//end class