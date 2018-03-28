/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorters;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stakhov
 */
public class MergeSortTest {
    
    public MergeSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort() {
        System.out.println("MergeSortTest");
        //int[] arr = new int[]{9,3,6,5,1,8,4,2,10,7};
        int[] arr = new int[]{0,1,3,2,5,4,7,6,8,9};
        Sortable instance = new MergeSort();
        int[] expResult = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = instance.sort(arr);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
