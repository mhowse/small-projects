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
        System.out.println("Translate to pig? or from pig?");
        System.out.println("Enter 1 to translate english to pig latin, enter 2 for the reverse");
        System.out.println("You can change the direction of the translator at any point by inputting the relevant number.");
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
      * @param  sentance, which is the string to be processed/translated.
     */
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

