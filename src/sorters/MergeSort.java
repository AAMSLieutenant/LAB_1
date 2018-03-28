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
public class MergeSort extends Sortable {
    
    
    public MergeSort(){
        System.out.println("MergeSort object created");
    }
    
    
    @Override
    public int[] sort(int[] arr){
         if(arr.length<=0){
            System.out.println("Length<=0");
            return null;
        }
        mergeSort(arr);
        return arr;
    }
    /**
     * method, which sorts an <code>int</code> array using
     * merge sorting algorithm
     * @param inputArray array, which should be sorted
     */ 
    private void mergeSort(int[] inputArray){
        int size=inputArray.length;
        if(size<2)
            return;
        int mid=size/2;
        int leftSize=mid;
        int rightSize=size-mid;
        int[] left=new int[leftSize];
        int[] right=new int[rightSize];
        for(int i=0;i<mid;i++){
            left[i]=inputArray[i];
        }
        for(int i=mid;i<size;i++){
            right[i-mid]=inputArray[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,inputArray);
        
        
       
    }

    /**
     * method, which merges an array for the merge sorting algorithm
     * @param left the left subarray
     * @param right the roght subarray
     * @param arr the array, which was divided
     */
    private void merge(int[] left, int[] right, int[] arr){
        
        if((left.length<=0)||(right.length<=0)||(arr.length<=0))
        {
            System.out.println("Null OR Negative length MERGE");
            
        }
        else{
        int leftSize=left.length;
        int rightSize=right.length;
        int i=0;
        int j=0;
        int k=0;
        while((i<leftSize)&&(j<rightSize)){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            } 
            else{
                arr[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<leftSize){
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j<leftSize){
            arr[k] = right[j];
            k++;
            j++;
        }
        }
    }
}
