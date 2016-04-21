package smallprojectsgit;

/**
 * magicSquare.java
 * mhowse april 2016
 */

public class magicSquare {
    
    private static final int [] [] sample = new int [3][3];
    private static final int goal = 15; 
    private  static boolean colA = false,colB = false,colC = false;
    private static boolean rowA = false, rowB = false, rowC = false;
    private static boolean diagMain =false, diagSecond=false;
        
    public static void main (String [] args){
        boolean right =false;
        fillSample();
        check3(sample);
    }//end main method
    
    /**
     * check3 will check that a  3 by 3 magic square is 
     * such that it is accurate (ie add required lines add to 15).
     */
    private static void check3(int [][] arr){
        int total;
        for(int i =0; i <3; i++){
            rowCheck(i,arr);
            colCheck(i,arr);
        }
        int mainTotal = arr[0][0]+arr[1][1]+arr[2][2];
        System.out.println("Main total = "+mainTotal);
        diagMain = (mainTotal ==goal);
        int secondTotal =  arr[0][2]+arr[1][1]+arr[2][0];
        System.out.println("Second total = "+secondTotal);
        diagSecond = (secondTotal ==goal);
       if ( checkBoolean()){
           System.out.println("The square is magic");
       } else{ 
           System.out.println("The square is false");
       }
    }//end method
    
    /**
     * checkBoolean checks whether  all the relevant class variables are set to true, 
     * if so returns true. if swau 
     * @return 
     */
    private static boolean  checkBoolean(){
         //3 columns, 3 rows, 2 diagonals. 
        if (( colA == true)&& (colB == true) &&(colC ==true)){
            System.out.println("passed first three trues");
            if((rowA ==true) &&(rowB == true)&& (rowC ==true)){
                System.out.println("passed second three trues");
                if((diagMain == true)&& (diagSecond ==true)){
                    System.out.println("passed last two trues");
                    return true;
                }
            }
        }
      return false;  
    }
    /**
     * rowCheck will check the given row, to see if it sums to 15. 
     * @param i the y (height in grid) coordinate of the row to be checked. 
     * @param ar  The magic square
     */
    private static void rowCheck(int i, int[][]ar){
        int total;
            total = ar[0][i] +ar[1][i]+ar [2][i];
            if (total == goal){
                switch (i){
                    case 0:
                        rowA = true;
                        break;
                    case 1:
                        rowB =true;
                        break;
                    case 2:
                        rowC = true;
                        break;
                    default:
                        System.out.println("Error in the switch case section of rows for check 3");
                        System.out.println("i = "+i);            
                } //end switch;
            }
         } //end method
    
    /**
     * colCheck.
     * Basically a clone of the rowCheck method, the difference being  which cell param i refers to
     * @param i which column to check.
     * @param ar 
     */
    private static void colCheck(int i, int [][] ar){
          int total;
            total = ar[i][0] +ar[i][1]+ar [i][2];
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
                        System.out.println("Error in the switch case section of rows for check 3");
                        System.out.println("i = "+i);            
                } //end switch;
            }
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