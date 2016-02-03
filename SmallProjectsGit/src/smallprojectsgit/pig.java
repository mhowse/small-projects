    package smallprojectsgit;

    /** pig.java
     * A pig latin translator.
     * November 2015 
     * Mhowse
    */

    import java.util.*;


    public class pig {

      private static int setting; 
      private static String word;
      private static String input;

      public  static  void main (String [] args){
          int i =0;
        setting =0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Translate to piglatin? or from piglatin to plaintext?");
        System.out.println("Enter 1 to translate english to pig latin, enter 2 for the reverse");
        System.out.println("You can change the direction of the translator at any point by inputting the relevant number.");
        System.out.println("To translate backwards and forwards please enter text one word at a time.");
        while (scan.hasNextLine()){
            word = scan.nextLine();
            textHandling(word);
        }

      } //end of main method
      
      
     /**
      * settingChoice method. Sets the translation direction. 
      * Does this by taking user input and placing it in the setting variable.
      * @param i which is the input variable to change the setting for which direction the translation will go. 
      */ 
      public static void settingChoice(int i){
        setting =i;  
        if(i ==1){
            System.out.println("Changing text to pig latin");
        }
        else 
            System.out.println("Changing pig latin to plain text");
      }

      /**
       * Takes the text and sends it to the correct translator method. 
       * Currently this is where the bugs start. 
       * @param word 
       */
     public static void textHandling(String word){
        Scanner scans = new Scanner(word);
        while (scans.hasNext()){
            input = scans.next();
            if ( input.equals("1") || input.equals("2")){
                System.out.println("Changing translation direction");
               settingChoice(Integer.parseInt(input));
                return;
            }
            if (setting ==1){
                translateToPig(input);
            }
            else 
                translateFromPig(input);
        }
     }

     /**
      * Does the work of translating the individual words to pig latin. 
      * @param  word, which is the string to be processed/translated.
     */
         public  static void translateToPig(String word){
           word.replaceAll("[^\\p{Alnum}]+", "");  // This removes every non-alpha-numeric character.
             if(word.equals("1")|| word.equals("2")){
                 System.out.println("Initialising"); // way of checking that the input isnt one of the translating settings.
                 return;
             } else {
                 char c = word.charAt(0); 
                 String suffix = ""+c+"ay"; 
             StringBuilder strbld = new StringBuilder();
             strbld.append("");
             int size = word.length(); 
             //processing it so the first character in the original word doesnt appear at the beggining 
             //of the new word, working from index one, instead of zero.
             for(int i =1; i<size; i++){
                 strbld.append( word.charAt(i)); 
             }

             strbld.append(suffix);  // add the "ay " to the end of the world
           String result = strbld.toString();
          System.out.println(result ); 
          return;
         }
         }//end of method 

 /**
      * Does the work of translating the individual words from  pig latin to plaintext 
      * @param  word, which is the string to be processed/translated.
      * Currently needs more work, can sometimes through a string index out of bounds exception. 
      * The problem occurs when one runs words that do not have the -ay suffix, 
      * and are thus too short. 
      * need to add in a handling of the exception.
      * 
     */
        
              public static void translateFromPig(String word){
                  word.replaceAll("[^\\p{Alnum}]+", "");  // This removes every non-alpha-numeric character.
             if(word.equals("1")|| word.equals("2")){
                 System.out.println("Initialising");
                 return;  //same as translating to pig
             } else{
             StringBuilder str = new StringBuilder();
             str.append(""); 
             int size = word.length()-3;
             try {
             str.append(word.charAt(size)); //put the start of the word back in first position
             for(int i =0; i<size; i++){
                 str.append( word.charAt(i)); 
             }

           String result = str.toString();
          System.out.println(result ); 
             } catch (StringIndexOutOfBoundsException e){
                     System.out.println("The word " + word + "does not appear to be in correct pig-latin form.");
                     System.out.println("Hence it cannot be translated from pig latin");
                     }
             }//end of else loop
          return;
            
         }//end of method
              


    }// end of class

