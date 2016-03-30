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
    private static final String[] test= {"eleven","one hundred and seventy six", "ninety nine", "two thousand seven Hundred and Forty Three", "minus seventy two"};
    private static final int []  testResults ={11,176,99,2743,-72};
    private static LinkedList<Integer> list = new LinkedList<>();
    private static boolean positive=true;
    private static int FinalResult=0;

    public static void main (String [] args){
          testingCode(test, testResults );
          /*
          System.out.println("String = "+test[1]);
          runConversion(test[1]);
     for (String t :test){
          System.out.println("String = "+t);
          runConversion(t);
      }          */
    }//end main method

    /**
     * testingCode. will run the rest of the program and compare the result with the desired result. 
     * @param t the string array of supposed input
     * @param res  the int array of the required results. 
     */
    private static void testingCode(String [] str, int [] res){
        System.out.println("running testing code");
        int success =0; 
        int fail =0;
       for (int i =0; i< str.length; i++){
          System.out.println("String = "+str[i]);
          System.out.println("result should be "+ res[i]);
          runConversion(str[i]);
          System.out.println("Final result is "+FinalResult);
          if (FinalResult == res[i]){
              success++;
          }  else fail++;
      }
       System.out.println("No. of Successes ="+success);
       System.out.println("No. of Failures"+fail);
    }

    /**
     * 
     * @param c 
     */
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
        FinalResult =0; 
       // System.out.println("List equals "+list.toString());
        int [] results = new int [list.size()];
        //System.out.println("Size is "+list.size());
        int result =0; 
        int t =0;

        if (list.size()==1){ //if there is only one item in the  list then the number is less then twenty one.Or is something like 100, 1000, etc.  
           // System.out.println("list one item long");
            result = list.get(0);
             if(positive){
             //  System.out.println("result is "+ result);
               
             FinalResult = result;
            }else {
              //  System.out.println("result is -"+result);
             
             FinalResult = -result; 
             }
             return;
        }   //first 20 numbers sorted. 

       //System.out.println("At the while loop");
       //System.out.println("Result ="+result); 
        while(!list.isEmpty()){ //while there is still stuff in the list. 
           int temp = list.pop();           //take the lowest part. i.e 
          //  System.out.println("just popped, temp ="+temp);
            //System.out.println("result ="+result);      
            if (temp== 100){
               t *=100;
              // System.out.println("temp=100, t ="+t);
            } else{
            if(temp == 1000){
                t *= temp;
                 result += t;
                 t = 0;
                // System.out.println("if t ==1000, Result ="+result);
            } else{
                //System.out.println("t+=temp, t ="+t+"temp ="+temp);
                t+=temp;
            }
            }
           // System.out.println("last part of while loop, back to top");
                  //  System.out.println("t="+t);
        }

       // System.out.println("After while loop");
       // System.out.println("Result ="+result);
      //  System.out.println("t ="+t);
        result+=t;
      //  System.out.println("Result ="+result);
            if(positive){
                FinalResult =result;
                //System.out.println("result is "+ FinalResult);
            }else 
                FinalResult = -result;
              //  System.out.println("result is -"+result);

        }//end collapseList*/





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
                if(token.equals("minus")|| token.equals("negative")){
                    positive = false;
                } else{
                findNumber(token);
                size++;
                }
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