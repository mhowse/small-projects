package smallprojectsgit;

/** pig.java
 * A pig latin translater.
 * November 2015 
 * Mhowse
*/

import java.util.*;


public class pig {
  
  private static int setting; 
  private static String word;
  
  public  static  void main (String [] args){
    setting =0;
    settingChoice();
    textHandling(); 
    
  } //end of main method
 /**
  * Sets the translation direction. 
  * Does this by taking user input and placing it in the setting variable.
  */ 
  public static void settingChoice(){
      try (Scanner scan = new Scanner (System.in)) {
          System.out.println("Translate to pig? or from pig?");
          System.out.println("Enter 1 to translate english to pig latin, enter 2 for the reverse");
          setting =Integer.parseInt( scan.next());
           System.out.println("Setting chosen");
           scan.close();
      }
  }
  
  /**
   * Takes the text and sends it to the correct translater method. 
   * Currently this is where the bugs start. 
   */
 public static void textHandling(){
   Scanner scans = new Scanner(System.in); 
      System.out.println("Please enter the text you want translated.");
   //after this line the file ends.. something is going wrong with the while loop. 
      while(scans.hasNext()){
     word = scans.nextLine();
       System.out.println("scanned");
     if (setting ==1){
       System.out.println("derp");
       translateToPig(word);
       System.out.println("derpcha test \n \n \n");
   } else 
     translateFromPig(word);
      }
   }  //end of text handling method. 
   
  
  
     public  static void translateToPig(String sentance){
       sentance.replaceAll("[^\\p{Alnum}]+", "");  // This removes every non-alpha-numeric character.
         if(sentance.equals("1")){
             System.out.println("Initialising");
             return;
         } else {
         }
         String[] wordArray = sentance.split("\\s+");
         int size =wordArray.length;
         
         StringBuilder strbld = new StringBuilder();
         StringBuilder str = new StringBuilder();
         for(int i =0;  i <size; i ++){
           System.out.println("test");
            str = new StringBuilder();
            System.out.println(wordArray[i]);
            System.out.println("other test");
            String currentWord = wordArray[i];
            System.out.println("currentWord is  " +currentWord);
           //String suffixWord = currentWord.charAt(1)+"ay"; 
           int wordlength =currentWord.length();
           
           for(int ind =1; ind<wordlength; ind++){
            str.append(wordArray[i].charAt(ind));
         }
          // strbld.append(" " +str+suffixWord);
         }
      
         String result = strbld.toString();
      System.out.println(result ); 
    
     }
    
  
          public static void translateFromPig(String word){
          }
  
          
}// end of class

