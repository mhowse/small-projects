/**simpleTranslator.java
 * mhowse February  2016.
 * 
 */

import java.util.*;
/**
 * This will be a simple translation program, 
 * translating SIMPLE sentances from english to german and vice versa. 
 * it will translate literally, not meaningfully. 
 * A later translation program  will start to use grammar in its translating. 
*/

public class simpleTranslator {
    private static String direction = ""; 
    
    /**main method
     * 
     * @param args 
     */
    public static void main (String [] args){
        
    }
    
    /**
     * simple translate constructor 
     * the string indicates which direction the translation will run 
     */
    private simpleTranslator (String i ){
        
    }
    
    /** chooses which way the translation will 
     * run in, English to German v.s. German to English
     */
    private static void chooseTranslation () {
     Scanner scan = new Scanner (System.in); 
     System.out.println("What language do you want to translate to?");
       while (scan.hasNextLine()){
            direction = scan.nextLine();
        }
    
}
    
}//end class