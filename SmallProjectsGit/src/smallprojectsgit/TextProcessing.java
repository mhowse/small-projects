package smallprojectsgit;

import java.util.Scanner;

/**
 * TextProcessing.java
 * mhowse 2016
 */

public class TextProcessing{
    
    
    public static void main(String [] args){
        dateFormat();
    }
     
    /**
     * dateFormat()
     * takes text input of date/timestamps and strips them to just the date. 
     * Used for doing a chunk of conversions at once, copy paste timestamps, 
     * enter and copy paste the result into the spreadsheet. 
     */
    public static void dateFormat(){
        Scanner scan = new Scanner(System.in);
        String input= "";
        String output="";
        while (scan.hasNext()){
        input = scan.nextLine();
        String [] t =input.split("-",4);
        String [] a =t[2].split(" ");
        output =a[0]+"/"+t[1]+"/"+t[0];
        System.out.println(output);     
    }
        scan.close();
        
        
    }
}