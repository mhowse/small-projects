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
import java.math.BigInteger;
public class EulerProblems {
    
    
    public static void main (String [] args){
        //problem1();
        //problem2a();
       // problem3();
        //problem4();
        //problem5();
         // problem6(); 
        //problem7();
        problem8();
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
        String line;
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
         String derp = String.valueOf(half1); 
        char [] arr = derp.toCharArray();
        String Half ="";
        for(int i=arr.length-1; i>=0; i--){
            Half+=arr[i];
        }
        derp=derp+Half;
        test = Integer.parseInt(derp);
      
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
    
    /**
     * 2520 is the smallest number that can be divided by each of the numbers 
     * from 1 to 10 without any remainder.
     *What is the smallest positive number that is evenly divisible 
     * by all of the numbers from 1 to 20?
     */
    private static void problem5(){
        int x=20; ///the number to be checked. 
        boolean found =false; 
        while(!found){
            if(  x %19 == 0 && x %18 == 0 && x%17 == 0 && x%16 == 0 ){
                if(x %15==0&& x%13==0&& x%11==0){
                    if( x%9==0 &&x%7==0 && x%6==0 &&x%3==0){
                        System.out.println("The number is "+x);
                        found =true;
                    }
                }
            }
               
            x+=20;//start at 20 and increment in 20s means never have to check 20, 
            //already know it is divisiable nicely. if it can be divided by 20, it is even, 
            //so dont need to check 2, or 10, or 4 or 5. 
            //Because 8 is just 2*4 we dont need to check it, or 12, or 14 
            //16,and 18 are dividable by 2, so we can theoretically could remove them.
            //but experiance doesn't agree.  
        }
    }
    
    /**
     * problem6
     * Find the difference between the sum of the squares 
     * of the first one hundred natural numbers and the square of the sum.
     */
    private static void problem6(){
        int n =100; 
        int sum =0; 
        int [] squares =new int [100];
        int sumOfSquares=0;
        int differnce;
        for(int i =1; i<101; i++){
            sum=sum+i;
            squares[i-1]=(i*i); 
            sumOfSquares= sumOfSquares +squares[i-1];
        }
        int squaredSum =sum*sum;
        System.out.println("Squared sum ="+squaredSum);
        System.out.println("Sum of Squares = "+sumOfSquares);
        System.out.println("Difference is "+(squaredSum-sumOfSquares));
    }
   
    /**
     * problem7
     * what is the 10 001st prime number?
     */
    private static void problem7(){
        int n=1; 
        int primeCount=0;
        boolean found = false;
        while(!found){
            if(n%2 !=0){
                int isPrime=0;
                 for (int i = 3; i * i <= n; i += 2){
                     if (n % i == 0) {
                         isPrime++;
                     } 
                 }
                     if(isPrime==0){
                         primeCount++;
                     }
                  
                if(primeCount==10001){
                    System.out.println("the 10001 prime is "+n);
                    return;
                }
            }
            
            n++;
        }
        }
    
    /**
     * problem8()
     * The four adjacent digits in the 1000-digit number 
     * that have the greatest product are 9 × 9 × 8 × 9 = 5832.
     * Find the thirteen adjacent digits in the 1000-digit 
     * number that have the greatest product. What is the value of this product?
     */
    private static void problem8(){
        BigInteger  source;
        source = new BigInteger("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
    int [] arr = new int [13];
    /* the largest posible product of 13 numbers would be if all 13 numbers were 9, 
    the product would be 2.5418658e+12.
    however since the 4 greatest adjacent didgets are 9 9 8 9
    the greatest 13 digit selection would be 
    9*9*8*9*9  *8*9*9*8*9 *9*8*9 as that allows for no sets of four nines. 
    This has a product of 1.5868743e+12
    */
    
    // So one can iterate through the digits. 
    String SourceStr = source.toString();
    char[] SourceArray = SourceStr.toCharArray();
    int thou =1000;//for the length of the Biginteger;
    BigInteger greatestProduct= new BigInteger("1586874300000");
    BigInteger currentProduct=new BigInteger("0");//for the largest product found so far. 
    BigInteger product =new BigInteger("0"); //for the product of each iteration.
    int [] currSequence=new int [13]; //for the current largest sequence. 
    for(int i =12; i<thou; i++){ //iterating through the number. 
        //shift what is in the 13 digit array, removing the first one, 
        if(i==12){//at the begining fill  the array. 
          for(int ind =0; ind<13; ind++){
              arr[ind]=SourceArray[ind];
          } 
        } else{ //otherwise set arr to where it should be for this iteration
        arr= shiftDown(arr); //shift the values,
        arr[12]=SourceArray[i];//add the new digit.
                }
        //check the product. 
       if(product.equals(greatestProduct)){
           System.out.println("Greatest product found.");
           System.out.println("Product is " +product);
           System.out.println("Greatest product is "+greatestProduct);
           System.out.println("Sequence is ");
           for(int ind=0; ind<13; ind++){
               System.out.print(arr[ind]);
           }
           return; 
       } //end if greatest product found. 
       if( product.compareTo(currentProduct) == 1){
           currentProduct=product;
           //copy arr into currSequence.
           for(int index =0; index<13; index++){
               currSequence[index]=arr[index];
           }
       }
       //
    }
    //if the whole thing is iterated through without finding the greatest product sequence,
    //then the greatest sequence in the section is what is stored as greatestProduct and currSequence. 
    System.out.println("Greatest product in number is "+currentProduct);
           System.out.println("Sequence is ");
           for(int ind=0; ind<13; ind++){
               System.out.print(currSequence[ind]);
           }
           return;
    
    }
        /**
         * For shifting the values down the array. 
         * returns the new array. 
         * @param array 
         */
    private static int [] shiftDown(int [] array){
     int[] newArr = new int[13];
     for(int i=0; i<11; i++){
         newArr[i]= array[i+1];
     }
     newArr[12]=0;
     return newArr;
    }
    
}//end class