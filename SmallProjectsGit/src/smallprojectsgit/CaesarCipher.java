/**
 * CaesarCiper.java
 * mhowse april 2016
 */
package smallprojectsgit;

import java.util.*; 

public class CaesarCipher{
   private static int shift; 
  // private static  List<String> phrase = new ArrayList<>();
   //private static  List<String> result = new ArrayList<>();
    public static void main (String [] args){
        input();
    }//end main method
    
    
    private  static void input(){
      Scanner scan = new Scanner (System.in);
      System.out.println("Welcome to caesar cipher. please enter the offset number"); 
      shift = scan.nextInt();
      
      
        
    }
}//end class