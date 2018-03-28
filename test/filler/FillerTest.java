/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filler;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stakhov
 */
public class FillerTest {
    
    public FillerTest() {
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
     * Test of generateSorted method, of class Filler.
     */
    @Test
    public void testGenerateSorted() {
        System.out.println("generateSorted");
        int length = 10;
        int[] expResult = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] result = Filler.generateSorted(length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateSortedReverse method, of class Filler.
     */
    @Test
    public void testGenerateSortedReverse() {
        System.out.println("generateSortedReverse");
        int length = 10;
        int[] expResult = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] result = Filler.generateSortedReverse(length);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateSortedRandomEnd method, of class Filler.
     */
    @Test
    public void testGenerateSortedRandomEnd() {
        System.out.println("generateSortedRandomEnd");
        int length = 10;
        
        int[] expResult = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = Filler.generateSortedRandomEnd(length);
        assertEquals(result.length, expResult.length);
        //Assert.assertNotEquals(expResult, result);
        Assert.assertNotSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandom method, of class Filler.
     */
    @Test
    public void testGenerateRandom() {
        System.out.println("generateRandom");
        int length = 10;
        int min = 0;
        int max = 20;
        int[] expResult = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] result = Filler.generateRandom(length);
        assertEquals(result.length, expResult.length);
        //Assert.assertNotEquals(expResult, result);
        Assert.assertNotSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
