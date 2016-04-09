/**
 * CaesarCiper.java
 * mhowse april 2016
 */
package smallprojectsgit;

import java.io.File;
import java.io.*;
import java.io.BufferedReader;
import java.util.*; 

public class CaesarCipher{
   private static int shift; 
   private static  List<String> phrase = new ArrayList<>();
   //private static  List<String> result = new ArrayList<>();
    public static void main (String [] args) throws FileNotFoundException{
        input(); 
        phraseHandling();
    }//end main method
    
    
   
    private static void phraseHandling() throws FileNotFoundException{
        FileReader fileR =  new FileReader("inputtext.txt");
       try (BufferedReader buff = new BufferedReader(fileR)) {
           String curr; 
           while((curr = buff.readLine()) != null) {
               String [] temp =  curr.split(" "); 
               phrase.addAll(Arrays.asList(temp));
           }
       } catch (IOException e ){
           System.out.println("Caught an exception in phraseHandling()");
       }          
        } 
        
        
    
    
    
    
    private  static void input(){
      Scanner scan = new Scanner (System.in);
      System.out.println("Welcome to caesar cipher. please enter the offset number (as an int)"); 
      shift = scan.nextInt(); 
      scan.close();
    }
              
}//end class