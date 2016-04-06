package smallprojectsgit;

/**
 * MetricToImperial.java
 * mhowse  april 2016
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Will convert metric input in cm, to feet and inches. 
 */
public class MetricToImperial {
    
    
    public  void main(String [] args){
        List<Integer> metric = new ArrayList<>();
        List<String> imperial = new ArrayList<>();
        try {
            File file = new File("numbers.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()){
                metric.add(scan.nextInt()); 
            }
        } //end main method.
        catch (FileNotFoundException ex) {
            Logger.getLogger(MetricToImperial.class.getName()).log(Level.SEVERE, null, ex);
        }
        metric.stream().forEach((s) -> {
            imperial.add( convert(s));
        });
      for(int i =0; i < metric.size(); i++){
          System.out.println(""+metric.get(i)+"cm equals "+imperial.get(i));
      }


        
    }// end main method
     /**
      * one inch = 2.54 cm. 
      * @param s
      * @return 
      */
    private String convert(int s){
        double inch =s/2.54; 
       return "derp"; 
    }
    
}//end class