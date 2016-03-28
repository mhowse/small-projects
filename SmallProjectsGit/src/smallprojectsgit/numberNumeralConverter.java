package smallprojectsgit;

/**
 * numberNumeralConverter.java
 * mhowse march 2016
 * converts numbers (ten, twentyone) to numerals. 
 */

import java.util.*;

public class numberNumeralConverter {
private static final int [] numerals={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,};
private static final  String [] words={"one","two","three","four", "five","six","seven", "eight","nine","ten",
                          "eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen",
                           "seventeen", "eighteen", "nineteen", "twenty",
                            "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousand"}; 
private static final String[] test= {"one hundred and seventy six", "ninety nine", "two thousand seven Hundred and Forty Three"};
private static LinkedList<Integer> list = new LinkedList<>();

public static void main (String [] args){
  for (String t :test){
      runConversion(t);
  }            
}//end main method

private static void runConversion(String c){
    convertToNumeral(c);
    collapseList();
}

/**
 * takes the list of the parts of the numbers and makes it into one whole. 
 * for example a list that went {1,100,1} become 101; 
 * {19, 90, 3} becomes 1993.
 */
private static void collapseList(){
    
}

/**
 * processes the string,
 * @param input 
 */
private static void convertToNumeral(String input){
    list.clear();
    input =input.toLowerCase();
    input = input.replaceAll(",", "");
    input = input.replaceAll("-", " ");
    String [] tokens= input.split(" ");
    int size=0;
    for (String token : tokens) {
        if (!token.equals("and")) {
            findNumber(token);
            size++;
        }
        
    }
}//end convert

/**
 * Finds the right numeral for the number. and adds it to the list
*/
private static void findNumber(String i){
    for (int ind=0; ind<words.length; ind++){
        if(words[ind].equals(i)){
           list.add( numerals[ind]);
        }
    }
}//end findNumber
}//end classs 