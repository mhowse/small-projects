

    /**
     * acronym.java
     * mhowse april 2016
     */

    import java.util.*;

    public class acronym{
       /**
        * A simple little acronym generator. It prompts user for input, takes the first letter of each word,
        * makes them into capitals and sticks them  together into the acronym. 
        * @param args 
        */
 private static String acron ="";
        public static void main (String [] args){
            Scanner scan = new Scanner (System.in);
            System.out.println("Enter in the words that the acronym will be made of");
                String data = scan.nextLine(); 
            String [] input = data.split("\\s+");
            for (String c:input){
                acron+=c.charAt(0);   
            }
            acron=acron.toUpperCase();
            System.out.println("Acronym is "+acron);
            System.out.println("Alternatively it could be ");
            for(int ind =0;ind < acron.length() ; ind++){
                System.out.print(acron.charAt(ind)+".");
               }

        }//end main method
    }