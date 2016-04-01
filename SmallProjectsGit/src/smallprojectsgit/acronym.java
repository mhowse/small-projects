package smallprojectsgit;

/**
 * acronym.java
 * mhowse april 2016
 */

import java.util.*;

public class acronym{
   
    
    public static void main (String [] args){
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter in the words that the acronym will be made of");
            String data = scan.nextLine(); 
        String [] input = data.split("\\s+");
        String acron ="";
        for (String c:input){
            acron+=c.charAt(0);   
        }
        acron=acron.toUpperCase();
        System.out.println("Acronym is "+acron);
        
    }//end main method
}