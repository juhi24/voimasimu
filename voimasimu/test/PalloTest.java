/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jussi24
 */
public class PalloTest {
    
    public PalloTest() {
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
     * Test of getMass method, of class Pallo.
     */
    @Test
    public void testGetMass() {
        System.out.println("getMass");
        Pallo instance = null;
        double expResult = 0.0;
        double result = instance.getMass();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Pallo.
     */
    @Test
    public void testGetX_0args() {
        System.out.println("getX");
        Pallo instance = null;
        double[] expResult = null;
        double[] result = instance.getX();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Pallo.
     */
    @Test
    public void testGetX_int() {
        System.out.println("getX");
        int dimension = 0;
        Pallo instance = null;
        double expResult = 0.0;
        double result = instance.getX(dimension);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getV method, of class Pallo.
     */
    @Test
    public void testGetV() {
        System.out.println("getV");
        int dimension = 0;
        Pallo instance = null;
        double expResult = 0.0;
        double result = instance.getV(dimension);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Pallo.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double value = 0.0;
        int dimension = 0;
        Pallo instance = null;
        instance.setX(value, dimension);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setV method, of class Pallo.
     */
    @Test
    public void testSetV() {
        System.out.println("setV");
        double value = 0.0;
        int dimension = 0;
        Pallo instance = null;
        instance.setV(value, dimension);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
