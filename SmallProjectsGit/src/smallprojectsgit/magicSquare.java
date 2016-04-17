/**
 * magicSquare.java
 * mhowse april 2016
 */

public class magicSquare {
    
    private static final int [] [] sample = new int [3][3];
    private static final int goal = 15; 
    public static void main (String [] args){
        fillSample();
        
    }//end main method
    
    /**
     * check3 will check that a  3 by 3 magic square is 
     * such that it is accurate (ie add required lines add to 15).
     */
    private static void check3(int [][] arr){
        boolean colA = false,colB = false,colC = false;
        boolean rowA,rowB,rowC;
        boolean diagMain, diagSecond;
        int total;
        for(int i =0; i <3; i ++){  // for each column .
            total = arr[i][0] +arr[i][1]+arr [i][2];
            if (total == goal){
                switch (i){
                    case 0:
                        colA = true;
                        break;
                    case 1:
                        colB =true;
                        break;
                    case 2:
                        colC = true;
                        break;
                    default:
                        System.out.println("Error in the switch case section of columns for check 3");
                        System.out.println("i = "+i);
                        System.out.println("colA ="+colA+" colB="+colB+" colC="+colC);        
                }
            }
            total =0;
        } //end column check. 
       
        
        
        
        
        
        
    }
    
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