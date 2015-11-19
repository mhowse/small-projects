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
   Scanner scan = new Scanner (System.in);
   //Stringbuilder strbld = new Stringbuilder();
   System.out.println("Translate to pig? or from pig?");
   System.out.println("Enter 1 to translate english to pig latin, enter 2 for the reverse"); 
   setting =Integer.parseInt( scan.next()); 
  
   while (scan.hasNext()){
     word = scan.nextLine();
     if (setting ==1){
       translateToPig(word);
       System.out.println("derp");
   } else 
     translateFromPig(word);
   }
   
 }//end of main method 
  
  
     public  static void translateToPig(String sentance){
       sentance.replaceAll("[^\\p{Alnum}]+", "");  // This removes every non-alpha-numeric character.
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

