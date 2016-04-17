/**
 * magicSquare.java
 * mhowse april 2016
 */

public class magicSquare {
    
    private static final int [] [] sample = new int [3][3];
    
    public static void main (String [] args){
        fillSample();
        
    }//end main method
    
    /**
     * Fills the sample magic square to test. 
     * For now uses the Lo Shu magic square
     */
    private static void  fillSample(){
       sample [0][0] = 4;
       sample [1][0] =9;
       sample [2][0] = 2;
       sample [0][1] = 3;
       sample [1][1] = 5;
       sample [2][1] = 7;
       sample [0][2] = 8;
       sample [1][2] = 1;
       sample [2][2] = 6;
        
    }
}//end class