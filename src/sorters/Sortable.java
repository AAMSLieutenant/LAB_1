/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

import java.util.Arrays;

/**
 *
 * @author Stakhov
 */

/**
 * 
 * <code>Sortable</code> is an interface, which contains
 * sorting methods
 */
public abstract class Sortable {
    
    /**
     * method swaps two elements of an <code>int</code> array.
     * @param arr array, which emenets are swapped
     * @param a index of the first element
     * @param b index of the second element
     */
    public void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    /**
     * Method sorts an <code>int</code> array
     * @param arr array, which should be sorted
     * @return 
     */
    public abstract int[] sort(int[] arr);
    
    
}
