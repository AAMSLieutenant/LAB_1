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
public class EmbeddedSort extends Sortable {
    
    public EmbeddedSort(){
        System.out.println("EmbeddedSort object created");
    }
    
    
    @Override
    public int[] sort(int[] arr){
         if(arr.length<=0){
            System.out.println("Length<=0");
            return null;
        }
        Arrays.sort(arr);
        return arr;
    }
    
}
