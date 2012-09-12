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
public class VerletFysiikkaTest {
    
    VerletFysiikka fysiikka;
    
    public VerletFysiikkaTest() {
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
     * Test of acceleration method, of class VerletFysiikka.
     */
    @Test
    public void testAcceleration() {
        System.out.println("acceleration");
        Pallo p = null;
        int dim = 0;
        VerletFysiikka instance = null;
        double expResult = 0.0;
        double result = instance.acceleration(p, dim);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distance method, of class VerletFysiikka.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        Pallo p1 = null;
        Pallo p2 = null;
        VerletFysiikka instance = null;
        double expResult = 0.0;
        double result = instance.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of step method, of class VerletFysiikka.
     */
    @Test
    public void testStep() {
        System.out.println("step");
        VerletFysiikka instance = null;
        instance.step();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
