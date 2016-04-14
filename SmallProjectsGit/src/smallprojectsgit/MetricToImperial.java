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
    
    
    public static  void main(String [] args){
        File f = new File("."); // current directory
        File[] files = f.listFiles();
          for (File file : files) {
             try {
                 if (file.isDirectory()) {
                     System.out.print("directory:");
                 } else {
                     System.out.print("     file:");
                 }
                 System.out.println(file.getCanonicalPath());
             } catch (IOException ex) {
                 Logger.getLogger(MetricToImperial.class.getName()).log(Level.SEVERE, null, ex);
             }
          }
          
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
     * converts(int s) allows for calling convert from other classes 
     * despite concert being private. 
     * @param s
     * @return 
     */
    public static String converts (int s){
        return convert(s);
    }
     /**
      * converts metric measurements (in cm) to feet and inches. 
      * 1cm = .39 inches. 
      * one inch = 2.54 cm. 
      * one foot = 30 cm. 
      * @param s
      * @return 
      */
    private static String convert(int s){
        double inch =s/2.54; 
        double feet=0;
        double yards =0;
        if(inch<12){
            return ""+inch+"\"";
        }
        while(inch>12){
            inch = inch-12; 
            feet++; 
        }
        if (feet >= 3){
            while(feet>3){
                yards++; 
            feet = feet -3; 
            }
        }
        
        String total =""+yards+"  yards\t"+ feet+"\'"+" "+inch+"\"";
       return total; 
    }
    
    private static void doubleCheck(){
       File f = new File("."); // current directory
        File[] files = f.listFiles();
          for (File file : files) {
             try {
                 if (file.isDirectory()) {
                     System.out.print("directory:");
                 } else {
                     System.out.print("     file:");
                 }
                 System.out.println(file.getCanonicalPath());
             } catch (IOException ex) {
                 Logger.getLogger(MetricToImperial.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    }
}//end class