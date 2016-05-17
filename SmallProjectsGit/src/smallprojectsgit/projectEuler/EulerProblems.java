package smallprojectsgit.projectEuler;

/**
 * EulerProblems.java
 * mhowse may 2016
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EulerProblems {
    
    
    public static void main (String [] args){
        //problem1();
        //problem2a();
       // problem3();
        problem4();
               
    }//end main method
    
    /**
     * problem1 solves the first project Euler problem. 
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    private static void problem1(){
        int sum=0;
        int count =0;
        while(count<1000){
            if(count%3 ==0 ||count %5==0){
                sum+=count; 
            }
            count++;
        }
        System.out.println("Sum ="+sum);
    }
    
    
    /**
     * problem2a
     * A slightly more refined and tidier version of the problem.
     * Still somewhat brute forcing it. 
     */
    private static void problem2a(){
        int Fibsum=0;
        int current=2;
         int previous=1;
         int next=0;
        int high =4000000;
        boolean run =true;
        while(current <high){
           next =current+previous;
           if(next%2==0){
               Fibsum+=next;
           }
            previous = current; 
            current =next; 
        }
        System.out.println("Sum ="+Fibsum);
    } //end method
    
    /**
     * What is the largest prime factor of the number 600851475143 ?
     *  Prime factors of a number  are the prime numbers that divide a number tidily.
     */
    private static void problem3(){ 
        long value =600851475143L; //too big for int. 
        long prime=2; //prime numbers
        long result =0;
        ArrayList<Long> pFactors = new ArrayList<>();
        String line ="";
        File file = new File("primes.txt");  //look at list of primes. 
        Scanner scan; 
        try {
            scan = new Scanner(file); // scan them.
            while (scan.hasNextLine()){
            line = scan.nextLine(); 
            String [] tokens = line.split(" ");
            long [] primenos =new long [tokens.length];
            for(int i =0; i<tokens.length; i++){
                primenos[i] = Long.parseLong(tokens[i]);
            } //convert the input to a long. 
            for (long l:primenos){ //for each of these prime numbers, 
                if(value%l==0){ //is it a factor? 
                pFactors.add(l);//add it to the list of prime factors. 
            }
            }
        }
            System.out.println("From 10000 primes we found "+pFactors.size()+" prime factors.");
            System.out.println("They are as follows. ");
            for(long l:pFactors){
                System.out.println(""+l);
            }
            System.out.println("The largest prime Factor of "+value+"is "+pFactors.get(pFactors.size()-1));
          } catch (FileNotFoundException ex) {
            Logger.getLogger(EulerProblems.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//end method            
     
    /**
     * problem4 finds the largest palindrome made from the product of 2 3-digit numbers. 
     * palindrome being something that is the same when backwards. 
     */
    private static void problem4(){
        int high =998001; //999 x999 =998001
        int low = 10000; //100*100=10000
        int half1 =998;
        int factor1=0;
        int factor2=0;
        int test =0; 
        boolean run = true;       
        //3 digit = 100 -999 = 899
        //so counting backwards from  high. only check numbers that have the same last digit as first.
        //100x100 = 10000, 998001-10000 = 988001. 
        System.out.println("high = "+high);
         while (run){
           test =  palindromeMake(half1);  // make a palindrome, 
           System.out.println("Test palindrome = "+test);
          //find how two 3 digit numbers create it. 
           if(test<high &&test>low){
           for(int i=999; i>99; i--){ // at most 800 checks here of each palindrome; 
               if(((test/i)>99) && ((test/i)<1000)){ //if i and something between 99 and 999 makes test
               if(test%i ==0){
                   factor1=i;
                   break;
               }
               }
           }
           if(factor1 !=0){
           factor2 =test/factor1;
           
           System.out.println("factor1= "+factor1+" factor2 ="+factor2);
           }
           if((factor1*factor2)== test){
               System.out.println("going through conditions.");
             if(test<high){ //if the palindrome is smaller then the high
                 if(factor1+factor2<1998){ //if the two factors are not both 999
                     System.out.println("Conditions have been meet"); 
                     run =false;
                 }
             }
           }
           } 
           else{
               System.out.println("test Palindrome higher then, or lower then, limit.");
           }
           half1--;
         } //end while
        System.out.println("Palindrome "+test+"is the product of "+factor1+ "and "+factor2);
    } //end method
    
    
    private static int palindromeMake(int x){
        String derp = String.valueOf(x); 
        char [] arr = derp.toCharArray();
        String Half ="";
        for(int i=arr.length-1; i>=0; i--){
            Half+=arr[i];
        }
        derp=derp+Half;
        int ret = Integer.parseInt(derp);
        return ret;
    }
    
}//end class