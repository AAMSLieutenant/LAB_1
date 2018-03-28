/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab_1;
import sorters.*;
import filler.*;
import java.util.Arrays;
import org.reflections.*;
import analyzer.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
/**
 *
 * @author Stakhov
 */
public class LAB_1{
        // TODO code application logic here
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, Exception {
        
        
        Analyzer a=new Analyzer();
        a.analyze();
   
        
    }       
       
    
}
