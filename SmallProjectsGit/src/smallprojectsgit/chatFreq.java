/**
 * To analyze txt chat logs to work out which words are used most
 * From this data I can then theoretically make a list of the words most useful for me 
 * for learning another language. 
 */

package smallprojectsgit;

/**
 *  to do 
 * word sort method errors somewhere, make it work.
 * 
 */

import java.io.*; 
import java.util.*;

public class chatFreq{
  
 static ArrayList<String> words;
   static String username1 ="placeholderb" ;
 static String username2 ="placeholdera" ;
  public static void  main (String [] args){
    words = new ArrayList<>();
    String s = new String();
    
    //Scanner scan = new Scanner(System.in);  //when running from command line could just directly send file there. 
    try {
        
    InputStream input= chatFreq.class.getResourceAsStream("chat.txt");
    Scanner scan = new Scanner(input);
      System.out.println("File loaded");
      while(scan.hasNext()){
        s= scan.next(); 
        inputHandle(s);
       // System.out.println("input done");
        
      }
      System.out.println("Input done");
      wordSort();
      System.out.println("Sorting done");
      //wordCount();
      //System.out.println("Allcounted\n\n"); 
      //countedStrings.toString();
    } catch (Exception e){
      System.out.println("Error");
    }
    System.out.println("words");
    System.out.println(words);
  } //end method
  
  
  public static void wordCount(){
    System.out.println("Word Counting");
    int i =0; 
    int count = 0;
    String curr= new String (); 
    while( i < words.size()-1){ //while still stuff in there 
      curr = words.get(i); 
      int t = i; 
      System.out.println("FirstWhile loop");
      while((words.get(t).charAt(0) ==(curr.charAt(0))) &&(words.get(t).charAt(1) ==(curr.charAt(1)))){
//while we are in the same two  letters
        if (words.get(t).equals(curr)){ //if same word 
          count++; 
          words.remove(t);
        }
        t++;
      }
    }
    }
  /* possibly better as a switch case, change later*/
  public static  void inputHandle(String s){
    if(s.matches("\\d\\d.\\d\\d") || s.matches(username1)||s.matches(username2)){ //discard time stamps. and names
    } else { if(s.matches("\\d*\\d/\\d\\d/\\d\\d,") || (s.matches ("\\d*:\\d*"))){
    }
    else{
        s= s.toLowerCase();
        if(!words.contains(s)){
      words.add(s);
        }
    }
       }
    }
  
  public static void wordSort(){
         String temp;
         System.out.println("size = "+words.size());
         int max = words.size();
         int i =0;
         while( i < max ) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).compareToIgnoreCase(words.get(j)) > 0) {
                    temp = words.get(i);
                    words.set(i,words.get(j));
                    words.set(j,temp); 

                }
        }
              if(i %100 == 0){
                  System.out.println("i = "+i);
            }
              i ++;
        } 
         System.out.println("size = "+words.size());
    }
}//end class

