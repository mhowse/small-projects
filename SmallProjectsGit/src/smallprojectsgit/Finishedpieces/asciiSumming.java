/**
 * asciiSumming.java 
 * @author mhowse
 * February 2016
 */

package smallprojectsgit.Finishedpieces;

import java.util.*;
public class asciiSumming{
    
    
    public static void main (String[] args){
        System.out.println("Enter a string, this program will summ the ascii values of all characters therein.");
        Scanner scan =new Scanner (System.in);
        while(true){
            int sum =0;
            
           String  s=scan.nextLine();
           char[] x= s.toCharArray();
                    for(char c: x){
                        sum +=c;
                    }//end for loop
        
        System.out.println("Total is " + sum);
        
        if (s.equals("exit")){
            scan.close();
            System.exit(0);      
        }// 
        }//end while loop
      
    }//end main method
}//end class