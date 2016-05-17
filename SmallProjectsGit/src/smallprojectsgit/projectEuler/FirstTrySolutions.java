package smallprojectsgit.projectEuler;

/**
 * FirstTrySolutions.java
 * mhowse may 2016
 * Will contain the first attempts, pre-tidy ups of project euler probelms.
 */

public class FirstTrySolutions{
    
    private static int  Fibsum, current, previous, next;
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
     * problem2 
     * Sum of even Fibonacci numbers that are less then 4 million.
     * A brute force solution.
     */
    private static void problem2(){
        Fibsum=0;
        current=2;
         previous=1;
         next=0;
        int high =4000000;
        boolean run =true;
        while(run){
           if(current>high){
               run=false;
           }
           next =fib(current, previous);
           System.out.println("Next ="+next);
           if(next%2==0){
               Fibsum+=next;
           }
           Switch(); 
           System.out.println("Fibsum="+Fibsum);
        }
        System.out.println("Sum ="+Fibsum);
    }
    /**
     * fib()
     * calculates the next Fibonacci number. 
     */
    private static int fib(int curr,int prev){
        System.out.println("total="+(curr+prev));
        return curr+prev;
    }
    
    private static void Switch(){
     previous = current; 
     current =next; 
    return;
}
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
           factor2 =checkFactors(factor1, test);
           
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
    
    private static int checkFactors(int x, int pal){
        int f2 =pal/x;
        System.out.println("Factor 2 is " +f2 );
        return f2;
    }
    
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
}