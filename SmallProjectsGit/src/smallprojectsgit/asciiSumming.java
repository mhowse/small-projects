/**
 * asciiSumming.java 
 * @author mhowse
 * February 2016
 */

import java.util.*;
public class asciiSumming{
    
    
    public static void main (String[] args){
        System.out.println("Enter a string, this program will summ the ascii values of all characters therein.");
        Scanner scan =new Scanner (System.in);
        String s ="";
        while (true){
            int sum =0;
            s=scan.nextLine();
           char[] x= s.toCharArray();
                    for(char c: x){
                        sum +=c;
                    }//end for loop
        }//end while loop
        
        
        
    }//end main method
}//end class