/**
 * datedaycalculate.java
 * mhowse march 2016
 */
package smallprojectsgit;
import java.util.*;



/** Will take a date from the user, and calculate the day of the week that day is. */
public class datedaycalculate{    
    private static int year;
    private static String month;
    private static int day;
 /**
     * @param args the command line arguments
     */
public static void main (String[] args){
simpleInput();
}




private static void simpleInput(){
   Scanner scan = new Scanner(System.in);
System.out.println("Enter in the year. ");
    year=scan.nextInt();
    System.out.println("Enter in the month"); 
    month =scan.next();
    System.out.println("Enter in the day of the month as a number i.e. 10, 12, 13");
    day = scan.nextInt();
}

}