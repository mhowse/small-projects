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
}