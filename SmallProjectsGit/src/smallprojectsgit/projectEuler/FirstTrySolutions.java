package smallprojectsgit.projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;

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
    
     private static void problem5(){
         
         int n=20; ///the number to be checked. 
         boolean found =false; 
         while(!found){
           if(conditionsmeet(n)){
               found =true;
               System.out.println("The number is "+n);
           }
             n+=20;//start at 20 and increment in 20s means never have to check 20, 
             //already know it is divisiable nicely. if it can be divided by 20, it is even, 
             //so dont need to check 2, or 10, or 4 or 5.
         }
     }
    
     private static boolean conditionsmeet(int x){
         if(  x %19 != 0 || x %18 != 0 || x%17 != 0 || x%16 != 0 ){
             return false;
         }
         if(x %15!=0|| x%14!=0 || x%13!=0|| x%12!=0|| x%11!=0){
              return false;
         }
         if( x%9!=0 || x%8!=0 || x%7!=0 || x%6!=0 ||x%3!=0){
              return false;
           
         }
         return true; 
     }
     /**
     * problem7
     * what is the 10 001st prime number?
     */
    private static void problem7(){
        int n=1; 
        int primeCount=1;
        boolean found = false;
        while(!found){
            if(n%2 !=0){
                if(isPrime(n)){
                primeCount++;    
                if(primeCount==10001){
                    System.out.println("the 10001 prime is "+n);
                    return;
                }
            }
            }
            n++;
            
        }
    }
    
        
    private static boolean isPrime(int num){
          if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
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
    //1000-12= 988. 
    int runCount=0;
    for(int i =12; i<thou; i++){ //iterating through the number. 
        //shift what is in the 13 digit array, removing the first one, 
        if(i==12){//at the begining fill  the array. 
          for(int ind =0; ind<13; ind++){
              arr[ind]=Character.getNumericValue(SourceArray[ind]);
          } 
        } else{ //otherwise set arr to where it should be for this iteration
        arr= shiftDown(arr); //shift the values,
        arr[12]=Character.getNumericValue(SourceArray[i]);//add the new digit.
                }
        
        //check the product. 
       //collect the product from the array arr. 
        for(int o=0; o<arr.length; o++){
            if(o==0){
            product=BigInteger.valueOf(arr[o]);
            }else 
                product =product.multiply(BigInteger.valueOf(arr[o]));
        }
        System.out.println("Product = "+product);
       if(product.equals(greatestProduct)){
           System.out.println("Greatest product found.");
           System.out.println("Product is " +product);
           System.out.println("Greatest product is "+greatestProduct);
           System.out.println("Sequence is ");
           for(int ind=0; ind<13; ind++){
               System.out.print(arr[ind]);
           }
       } //end if greatest product found. 
       if( product.compareTo(currentProduct) == 1){
           System.out.println("bigger product found");
           currentProduct=product;
            //copy arr into currSequence.
            System.arraycopy(arr, 0, currSequence, 0, 13);
       }
       runCount++;
       System.out.println("arr =");
       printArray(arr);
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
         * For shifting the values down the array. 
         * returns the new array. 
         * @param array 
         */
    private static int [] shiftDown(int [] array){
        
        System.out.println("Shifting down");
     int[] newArr = new int[13];
     for(int i=0; i<12; i++){
         newArr[i]= array[i+1];
     }
     newArr[12]=0;
     printArray(newArr);
     return newArr;
    }
    
    private static void printArray(int [] array){
       for (int n : array) {
           System.out.print(n + "\t");
       }
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
     * longest Collatz sequence.
     */
    private static void problem14(){
        long start =13; //int max value = 2 147 483 647
        long high = 1000000; //looking for a number under 1 million.
        long curr=13;
        long chainLength =0;// the largest chain length yet.
        long  currChain=10;//13 = starting chain 10 long.
        long startingN=0;// number that causes the chain length;
        for(long i=start; i<high; i++){
            System.out.println(i);
            curr = i;
            currChain=1;
            while(curr != 1){
                if (curr%2 ==0){
                    curr = curr/2;
                } else
                    curr = (3*curr)+1;
                currChain++;
            }
            if(currChain>chainLength){
                chainLength =currChain;
                startingN =i;
            }
        }
        System.out.println("Answer is "+startingN+"With a chain length of "+chainLength);
        
    }
}