/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filler;

import java.util.Random;
import java.lang.String;
import java.lang.Exception;

/**
 * @author Stakhov
 */


/**
 * Class is created for sequences;
 * 
 */
public class Filler {
    /**
     * Private constructor because it is
     */
    private Filler(){ 
    }
    
    
    /**
     * Returns an array of <code>int</code> elements, 
     * which are sorted by the natural order.
     * @param length specifies <code>int</code> length of an array.
     * @return generated <code>int</code> array.
     */
    public static int[] generateSorted(int length){
        
        int[]arr=new int[length];
        try{
            for(int i=0;i<arr.length;i++){  
                arr[i]=i+1;
            }
        return arr; 
        }
        catch(NullPointerException npe){
            System.out.println("NullPointerException generateSorted");
        }
        catch(Exception e){
            System.out.println("Exception generateSorted");
        }
        return arr;
    }
    
    /**
     * Returns an array of <code>int</code> elements, 
     * which are sorted by the reverse order.
     * @param length specifies <code>int</code> length of an array.
     * @return generated <code>int</code> array.
     */
    public static int[] generateSortedReverse(int length){
        int[]arr=new int[length];
        try{
            for(int i=0;i<arr.length;i++){  
                arr[i]=length;
                length--;
            }
        }
        catch(NullPointerException npe){
            System.out.println("NullPointerException generateSortedReverse");
        }
        catch(Exception e){
            System.out.println("Exception generateSortedReverse");
        }
        return arr;   
    }
    
    
    /**
     * Returns an array of <code>int</code> elements, 
     * which are sorted by the natural order.
     * The last element is entered by the <code>nextInt()</code>.
     * @param length specifies <code>int</code> length of an array.
     * @param  min specifies the low border of the generation range.
     * @param max specifies the top border of the generations range.
     * @return generated <code>int</code> array.
     * @see java.util.Random#nextInt() 
     */
    public static int[] generateSortedRandomEnd(int length){
        int min=0;
        int max=50000;
        int[]arr=new int[length];
        try{
        for(int i=0;i<arr.length-1;i++){  
            arr[i]=i+1;
        }
        Random rand=new Random();
        arr[length-1]=rand.nextInt((max-min)+1)+min;
        }
        catch(NullPointerException npe){
            System.out.println("NullPointerException generateSortedRandomEnd");
        }
        catch(Exception e){
            System.out.println("Exception generateSortedRandomEnd");
        }
        return arr;   
    }
    
    /**
     * Returns an array of <code>int</code> elements, 
     * which are generated by the <code>nextInt()</code> method.
     * @param length specifies <code>int</code> length of an array.
     * @param  min specifies the low border of the generation range.
     * @param max specifies the top border of the generations range.
     * @return generated <code>int</code> array.
     * @see java.util.Random#nextInt() 
     */
    public static int[] generateRandom(int length){
        int min=0;
        int max=50000;
        Random rand=new Random();
        int[]arr=new int[length];
        try{
        for(int i=0;i<arr.length;i++){  
            arr[i]=rand.nextInt((max-min)+1)+min;
        }
        }
        catch(NullPointerException npe){
            System.out.println("NullPointerException generateRandom");
        }
        catch(Exception e){
            System.out.println("Exception generateRandom");
        }
        return arr;
    }
    
}
