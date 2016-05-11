package smallprojectsgit.projectEuler;

/**
 * EulerProblems.java
 * mhowse may 2016
 */

import java.util.*;
public class EulerProblems {
    
    
    public static void main (String [] args){
        problem1();
        problem2a();
        problem3();
               
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
        for (long i = 2; i <= value; i++) {
            if(i%2==0){   
                //if even number, therefore not prime, move to next number. 
                //this halves pool of numbers, from giant to not so giant. 
            }else{
                if(value%i==0){
                   // System.out.println("i is"+i+" It cleanly divides value.");
                    //if it divides cleanly it is a factor. 
                    if(isPrime(i)){ //if it is a prime, as well as a factor. 
                        System.out.println(""+i+" Is a Prime Factor.");
                    }
                }               
            }
        //generate prime number. 
        //value/prime =result;
        //is result>prime? is result a prime? 
        //if result is a prime, and is larger then prime. 
       //prime =result. 
    }
    }
    
    private static boolean isPrime(long n){
        if(n==1||n==2){
            return true;
        } 
       // if (n % 2 == 0){  This bit is currently already checked by problem3(), 
        //return false; so here is commented out in order to make sligtly faster. 
       // }
        for (int i = 3; i * i <= n; i += 2){
            
            if (n % i == 0){
                return false;
            }
        return true;
        }
        return true;
    } //end isPrime 
   
    
}//end class