package smallprojectsgit.projectEuler;

/**
 * EulerProblems.java
 * mhowse may 2016
 */

public class EulerProblems {
    
    public static void main (String [] args){
        problem1();
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
    
}//end class