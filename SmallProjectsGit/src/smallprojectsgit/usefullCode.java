/**
 * usefullCode.java
 * mhowse
 *april 2016
 */

package smallprojectsgit;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A collection of useful methods and bits of code, which will probably be reused many times. 
 *
 */

public class usefullCode{
    

private static void doubleCheck (){
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
  private static void printArray(String [] array){
       for (String array1 : array) {
           System.out.print(array1 + "\t");
       }
  }

}//end class