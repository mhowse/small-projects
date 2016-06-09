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
    /**
     * unfinished problems :
     * problem11();
     * @param args 
     */
    
    public static void main (String [] args){
        //problem1(); //problem2a();// problem3();
        //problem4();//problem5();
         // problem6(); 
        //problem7(); problem8();
       // problem9();
       // problem10();
       // problem11();
        problem12();
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
        //  BigInteger  source;
        String source = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        int [] arr = new int [13];
        /* the largest posible product of 13 numbers would be if all 13 numbers were 9, 
        the product would be 2.5418658e+12.
        however since the 4 greatest adjacent didgets are 9 9 8 9
        the greatest 13 digit selection would be 
        9*9*8*9*9  *8*9*9*8*9 *9*8*9 as that allows for no sets of four nines. 
        This has a product of 1.5868743e+12
        *///String SourceStr = source.toString(); May as well have source as string from start.
        char[] SourceArray = source.toCharArray();
        int thou =1000;//for the length of the Biginteger;
        BigInteger greatestProduct= new BigInteger("1586874300000");
        BigInteger currentProduct=new BigInteger("0");//for the largest product found so far. 
        BigInteger product =new BigInteger("0"); //for the product of each iteration.
        int [] currSequence=new int [13]; //for the current largest sequence. . 
        int runCount=0; //1000-12= 988. 
        for(int i =12; i<thou; i++){ 
            //iterating through the number. 
            //shift what is in the 13 digit array, removing the first one, 
             if(i==12){//at the begining fill  the array. 
                 for(int ind =0; ind<13; ind++){
                     arr[ind]=Character.getNumericValue(SourceArray[ind]);
                 }
             } else{ //otherwise set arr to where it should be for this iteration
                  int[] newArr = new int[13];
                  for(int ix=0; ix<12; ix++){
                      newArr[ix]= arr[ix+1];
                  }
                  newArr[12]=0;
                  arr= newArr;
                // arr= shiftDown(arr); //shift the values,
                  arr[12]=Character.getNumericValue(SourceArray[i]);//add the new digit.
                } 
       //collect the product from the array arr. 
        for(int o=0; o<arr.length; o++){
            if(o==0){
            product=BigInteger.valueOf(arr[o]);
            }else 
                product =product.multiply(BigInteger.valueOf(arr[o]));
        }// System.out.println("Product = "+product);
       if(product.equals(greatestProduct)){ //check the product. 
           System.out.println("Greatest product found.");
           System.out.println("Product is " +product);
           System.out.println("Greatest product is "+greatestProduct);
           System.out.println("Sequence is ");
           for(int ind=0; ind<13; ind++){
               System.out.print(arr[ind]);
           }
       } //end if greatest product found. 
       if( product.compareTo(currentProduct) == 1){
           //System.out.println("bigger product found");
           currentProduct=product;
            //copy arr into currSequence.
            System.arraycopy(arr, 0, currSequence, 0, 13);
       }
       runCount++;
    }
    //if the whole thing is iterated through without finding the greatest product sequence,
    //then the greatest sequence in the section is what is stored as greatestProduct and currSequence. 
        System.out.println("Greatest product in number is "+currentProduct);
        System.out.println("Sequence is ");
        for(int ind=0; ind<13; ind++){
            System.out.print(currSequence[ind]);
        }
        System.out.println("Runcount = "+runCount );
        return;
    
    }
   
    /**
     * problem9()
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     * a2 + b2 = c2
     * For example, 32 + 42 = 9 + 16 = 25 = 52.
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     */
    private static void problem9(){
        int a,b,c;
        int c2;
        int total =0;
        int high =1000;
        int iterate =0;
        double cDouble =0;
        //a2+b2=c2..  so c should be probably more then 500 (1/2 of 1000)
        //100^2 =10 000; so a, and b should be less then 100;
        for( a=1; a<300; a++){//a should be the smallest. 
            for( b =2; b<500; b++){ //b between a and c
                iterate++;
                c2=(a*a)+(b*b);
             cDouble=Math.sqrt(c2); 
             if ((cDouble == Math.floor(cDouble)) && !Double.isInfinite(cDouble)) {
                  c=(int) cDouble;
             total =a+b+c;
                 System.out.println("a= "+a+" b= "+b+" c= "+c);
                 System.out.println("Total is "+ total);
                 if(a+b+c==1000){
            if(((a*a)+(b*b))==(c*c)){
                System.out.print("a = "+a);
                System.out.print("b = "+b);
                System.out.print("c = "+c);
                System.out.println("Found");
                System.out.println((a*a)+" + "+(b*b)+" = "+(c*c));
                System.out.println("Iterate count= "+iterate);
                return;
            }  
        }
        }
        }
        }
        System.out.println("Iterate count="+iterate);
        }
    
    /**
     * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     * Find the sum of all the primes below two million.
     */
    private static void problem10(){
        int high =2000001;
        ArrayList<Integer> primes =new ArrayList<>();
        Boolean [] arr = new Boolean [high];
        Long sum= new Long(0);  
       
        for(int i=0; i<high; i++){ //set all indexes to true.
            arr[i] = true;
            }
        System.out.println("arraysize = "+arr.length);
        
        for(int ind=0; ind<high; ind++ ){
            if(arr[ind]==true){
            if(ind <3){
                if(ind ==0){
                    
                }else if (ind ==1){
                    
                }else if(ind ==2){
                    primes.add(ind);
                    int evencount=1;
                    for(int index=ind; index<high; index+=2){
                        if(index%2==0){ //double check its an even number
                            arr[index]=false;
                            evencount++;
                           
                        }
                    }
                    System.out.println("Evencount = "+evencount);
                }
                
            } else{
                primes.add(ind);
                  for(int index=ind; index<high; index+=ind){ //iterate up in sets of itself. 
                        if(index%ind==0){ //if it divides by ind, then not false, 
                            arr[index]=false;  
                        }
                    }   
               
            }
            
                 
            }          
        }
        System.out.println("other side of all the for loops. ");
        System.out.println("Sum ="+sum);
        System.out.println("Primes are ");
        int sumCount=0;
        for(int t=0; t<primes.size();t++){
           System.out.println(primes.get(t));
            sum+= Long.valueOf(primes.get(t));
            System.out.println("Sum = "+sum);
            sumCount++;
        }
        
        System.out.println("Sum ="+sum);
        System.out.println("sUMCOUNT = "+sumCount);
    }
    
    /**
     * In the 20×20 grid four numbers along a diagonal line have been marked in red.
     * The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
     * What is the greatest product of four adjacent numbers in the same direction
     * (up, down, left, right, or diagonally) in the 20×20 grid?
     */
    private static void problem11(){
        int [] row1= {8, 2, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8};
        int [] row2 ={49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00};
        int [] row3= {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65};
        int [] row4 = {52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91};
       int [] row5= {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80};
        int [] row6={24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50};
         int [] row7={32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70};
        int [] row8={67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21};
        int [] row9={24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72};
       int [] row10= {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95};
        int [] row11={78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92};
        int [] row12={16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57};
        int [] row13= {86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58};
        int [] row14={19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40};
        int [] row15={04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66};
        int [] row16={88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69};
        int [] row17={04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36};
        int [] row18={20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16};
        int [] row19={20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54};
        int [] row20={01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48};
    
        ArrayList<Integer> products=new ArrayList<>();//to hold products
        ArrayList<int[]> sequences= new ArrayList<>();//to hold the sequences that cause the products,
        //using indexes for synching, will have 5 numbers, first two willrefer to the row/column as 
        int index=0;
        for(int i =0; i<16;i++){  //for 16 horizontal sequences
            for(int ind =0; ind<20; ind++){ //for 20 rows
                
            }
        }

                
    }
    
    /**
     * Problem 12, find the triangle number with over 500 divisors. 
     */
    private static void problem12(){
        int natural=1; //current natural number. 
        int tri = 1; //triangle number. 
        int noofdivisors=0;
        boolean run=true;
        while(run){
             //  ArrayList <Integer> divList = new ArrayList<>();
               tri += natural; //to generate the current triange number. 
               System.out.println(tri);
               //instead of a list of divisors, a 
               // working out of how many, if teh answer reached at the end i
              int n=tri;
                 for (int i=1; i<n; i++){
                     if(n %i==0){
                         n=tri/i;
                         if(n != i){
                             noofdivisors++;
                         }
                         noofdivisors++;
                     }
                 }
               
               //noofdivisors=divList.size()-1;
               //check and break out of loop. 
           if(noofdivisors>500){
               System.out.println("Triangle number "+tri+"has over 500 divisors");
               System.out.println("It has "+noofdivisors);
               run=false;
           }
            natural++; //iterate 
            noofdivisors=0;//clear for next iteration
        }
        
    }
}//end class