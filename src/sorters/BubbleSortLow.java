/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

/**
 *
 * @author Stakhov
 */
public class BubbleSortLow extends Sortable{
    
    public BubbleSortLow(){
        System.out.println("BubbleSortLow object created");
    }
    
    
    @Override
    public int[] sort(int[] arr){
         if(arr.length<=0){
            System.out.println("Length<=0");
            return null;
        }
        return bubbleSortLow(arr);
    }
    
    
    /**
     * method, which sorts an <code>int</code> array in natural order 
     * by using bubble sorting algorithm.
     * @param arr array which should be sorted
     * @return sorted array
     */
    private int[] bubbleSortLow(int[] arr){
        boolean flag=true;
        while(flag){
            flag=false;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    flag=true;
                }
            }
            
        }
        return arr;
    }
}
