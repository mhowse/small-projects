package smallprojectsgit;

/**
 * numberNumeralConverter.java
 * mhowse march 2016
 * converts numbers (ten, twentyone) to numerals. 
 */


public class numberNumeralConverter {
private static final int [] numerals={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,};
private static final  String [] words={"one","two","three","four", "five","six","seven", "eight","nine","ten",
                          "eleven", "twelve", "thirteen","fourteen", "fifteen", "sixteen",
                           "seventeen", "eighteen", "nineteen", "twenty",
                            "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousand"}; 
private static final String[] test= {"one hundred and seventy six", "ninety nine", "two thousand seven Hundred and Forty Three"};


public static void main (String [] args){
  for (String t :test){
      convertToNumeral(t);
  }            
}//end main method

private static void convertToNumeral(String input){
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

private static void findNumber(String i){
    int num;
    for (int ind=0; ind<words.length; ind++){
        if(words[ind].equals(i)){
            num = numerals[ind];
        }
    }
}//end findNumber
}//end classs 