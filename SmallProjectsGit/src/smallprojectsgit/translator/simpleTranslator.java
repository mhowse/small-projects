/**simpleTranslator.java
  * mhowse February  2016.
  * 
  */


package smallprojectsgit.translator; 

import java.util.*;
import java.io.*;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;
/** The translations will be done word for word, from  a stored dictionary  spreadsheet. 
  * This stored dictionary will be based on the top 1000 used German words, 
  * as found at 
  * http://www.languagedaily.com/learn-german/vocabulary/common-german-words
  * The spreadsheet manipulation comes from the jOpenDocument libraries.
  */


public class simpleTranslator {
  private static String direction = ""; 
  private String wordToTranslate ="";
  private String currentCell = ""; 
  private int rowCount;
  private int colCount;
  private String path =""; 
  
  
  /**main method
    * 
    * @param args 
    * @throws java.lang.Exception 
    */
  public static void main (String [] args) throws Exception{
    System.out.println("running");
    chooseTranslation(); //set direction
    //quick fix in case user derps, only one direction atm. 
    direction = "German"; 
    simpleTranslator simple = new simpleTranslator(direction); //create translator
    //do i want a seperate translator for each direction? and just switch which one is being used?
    
  }
  
  
  /**
   * simple translate constructor 
   * the string indicates which direction the translation will run 
   */
  private simpleTranslator (String i ){
    if (direction.equals("German")){
      // Load the specific dictionary file.
        try{
          getPathDictionary();
          File file = new File(path); 
          System.out.println("loading file");
        final Sheet sheet = SpreadSheet.createFromFile(file).getSheet(0);
        System.out.println("Sheet created");
        colCount = sheet.getColumnCount();
        rowCount = sheet.getRowCount();
        System.out.println("Rows :"+rowCount);
        System.out.println("Cols :"+colCount);
        // so one can iterate through each row of the selected sheet
        //this is so one can search for the word. 
        //setup complete, start taking and translating words. 
    Scanner scan = new Scanner(System.in);
    System.out.println("Type in the german word, and an english translation will appear"); 
    wordToTranslate = scan.nextLine(); 
    System.out.println(colCount +"cols accross");
    System.out.println(rowCount+"rows down");
    translateWord(wordToTranslate, sheet);
      } catch (Exception e){
        System.out.println("error");
        System.out.println(e.getMessage());
        e.printStackTrace(); 
        System.out.println("error message end");
      }
    }//if loop 
  } //end method 
  
  /**
   * Takes the word to be translated, searches the dictionary for it. 
   * Finds the translation of said word (in next column over) and returns that translation.
   * @return string that is the translation of the word 
   */
  private String translateWord(String a, Sheet b){
    System.out.println("translateWord has been called");
      String c="";
      System.out.println("starting for loop");
     for (int i =0; i <rowCount; i++){
         c = b.getValueAt(1,i).toString();
         System.out.println("for loop "+ c);
         if (c.equals(a) ){
             System.out.println(a+ "means "+ b.getValueAt(2,i) + "in german." );
             break; //need to exit out of for loop here. 
         }
     } 
     return c; 
  }
  
  
  /**
   * getPathDictionary handles the path creation for loading the correct dictionary. 
   */
  
  private void getPathDictionary(){
    String s=""; //adds in the path suffix to load the correct dictionary. 
    if (direction.equals ("German")){
    s = "/resources/dictionary.ods";
    System.out.println("s is set");
    }
     String y =System.getProperty("user.dir");
      System.out.println(s +"\n"+ y);
     char c='/';
     y+=s;
     System.out.println(y);
     System.out.println("c set");
     y.replace("\\", "/");
     path = y;
        
  }
  
  /** chooses which way the translation will 
    * run in, English to German v.s. German to English
    */
  private static void chooseTranslation () {
    try (Scanner scan = new Scanner (System.in)) {
      System.out.println("What language do you want to translate to?");
      direction = scan.nextLine();
    }
  }
  
  
}//end class