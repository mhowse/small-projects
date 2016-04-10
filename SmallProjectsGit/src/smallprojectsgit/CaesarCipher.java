/**
 * CaesarCiper.java
 * mhowse april 2016
 */
package smallprojectsgit;

import java.io.*;
import java.io.BufferedReader;
import java.util.*; 

public class CaesarCipher{
   private static int shift; 
   
   private static final  List<String> phrase = new ArrayList<>();
   private static final  List<String> result = new ArrayList<>();
    public static void main (String [] args) throws FileNotFoundException{
        input(); 
        phraseHandling();
        substitution();
        printPhrase();
    }//end main method
    
    /**
     * prints out the original phrase and the ciphered result. 
     */
    private static void printPhrase(){
        System.out.println("Printing phrase.");
        for(String s: phrase){
            System.out.print("  "+s);
        }
        System.out.println("");
        System.out.println("Printing result.");
                for(String s: result){
            System.out.print("  "+s);
        }
    }
    /**
     * substitution()
     * Does the work of shifting letters down the alphabet.
     * i.e. substituting one letter for another. 
     */
    private static void substitution(){
        System.out.println("Substitution running");
        System.out.println("Shift ="+shift);
        char a ='a';
        System.out.println("This means that 'a' will become "+(a+shift));
        char shft =(char) shift; 
        for(String s: phrase){ //for each string-word in the phrase list
            char[] c= s.toCharArray();
            for(char ch: c){ //for each character in the string.
                ch+=shft; //shift the value of that character an amount determined by the shift amount. 
            }
            String str =new String(c);
            result.add(str);
        }
    }
   /**
    * phraseHandling() loads the file with the message to be ciphered. 
    * @throws FileNotFoundException  if the file isn't where the program thinks it is. 
    */
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
        
       
    
    /**
     * input() takes input from user, to set shift variable,
     * i.e how many places down the alphabet letters will shift.
     */
    
    private  static void input(){
       try (Scanner scan = new Scanner (System.in)) {
           System.out.println("Welcome to caesar cipher. please enter the offset number (as an int, less then 26)");
           shift = scan.nextInt();
           if (! ((0<shift)&&(shift<26))){ //if shift is not between 0 and 26 
               System.out.println("invalid input, shift will default to 10");
              shift =10;
           }
       }
    }
              
}//end class