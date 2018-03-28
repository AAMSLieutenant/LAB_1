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
public class QuickSort extends Sortable{
    
    
    public QuickSort(){
        System.out.println("QuickSort object created");
    }
    
    
    @Override
    public int[] sort(int[] arr){
        if(arr.length<=0){
            System.out.println("Length<=0");
            return null;
        }
        return quickSort(arr,0,arr.length);
    }
    
    
   
    
    /**
     * method, which sorts an <code>int</code> array 
     * by using quickSort algorithm 
     * @param arr array which should be sorted
     * @return sorted array
     */
    private int[] quickSort(int[] arr, int start, int end){
      
      if(end==arr.length){
          end-=1;
      }  
      int i=start;
      int j=end;
      int x=arr[start+(end-start)/2];
      do{
         while(arr[i]<x) ++i;
         while(arr[j]>x) --j;
         if(i<=j){
            swap(arr,i,j);
            i++;
            j--;
         }
      }while(i <= j);
      if(start<j) quickSort(arr,start,j);
      if(i<end) quickSort(arr,i,end);
      return arr;
    }
}
