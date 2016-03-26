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
    private static final int [] monthSize = {31,28,31,30,31,30,31,31,30,31,30,31};
 /**
     * @param args the command line arguments
     */
public static void main (String[] args){
    
        try (Scanner scans = new Scanner (System.in)) {
                System.out.println("Welcome to this date to day-of-week calculator");
                System.out.println("Do you want to enter in your date  in dd-mm-yyyy format?");
                System.out.println("If so, press y. Otherwise press n");
                if (scans.next().equals("y")){
                    Input(); 
                    calculate();
                }
                else {
                    simpleInput();
                    calculate();
                }
        } catch (Exception err){
            System.out.println("Error found");
        System.out.println(err.getMessage());
        // e.printStackTrace(); for testing and finding problems
        System.out.println("error message end");
        }
}//end main method

private static void calculate(){
    int r = year -1900;
    int res = (r/4)+ (r*365);
    if (isLeapYear(year)){
        if (month<3){
            res--;
        }
       
    } 
    res+=daysAdd(month)+day;
    res %= 7;
    dayWorkOut(res);
}

/**
 * prints out the day of the week.
 * @param i 
 */
private static void dayWorkOut(int i){
    String[] DaysofWeek = { "Sunday", "Monday" , "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    System.out.println("The date inputted is a "+DaysofWeek[i]);
}
/**
 * adds the numbers of days in the months up to but not including the inputted month. 
 * gets the values from monthSize array. 
 * @param m for the month current to the date inputted
 * @return  the number of days. 
 */

public static int daysAdd(int m){
    int days = 0;
    for (int i =1; i<m; i++){
        days +=monthSize[i-1];
    }
    return days;
}

/**
 * Checks to see if the year inputted is a leap year. 
 * @param y the year to be checked.
 * @return 
 */

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
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter in the year. As a number, so 1993 instead of nineteen ninety three. ");
            year=scan.nextInt();
            System.out.println("Enter in the month as a number, so january = 1; ect");
            month =scan.nextInt();
            System.out.println("Enter in the day of the month as a number i.e. 10, 12, 13");
            day = scan.nextInt();
        }
}//end method


/**
 * Input takes the user input, directs the user quite throughly, to make it easier to process the date. 
 */
private static void Input(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Please enter date, using format dd-mm-yyyy");
           String derp = scan.next();
           process(derp);
        }
}//end method

/**
 * processes the input taken from the user in Input(), makes it so that the data is in the right places for calculate();
 * @param input 
 */
  public static void process(String input) {
        String[] tokens = input.split("-");
        day = Integer.parseInt(tokens[0]);
         month = Integer.parseInt(tokens[1]);
         year = Integer.parseInt(tokens[2]);
    }
  
  
  
  
}//end class