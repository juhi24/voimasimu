/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jussi24
 */
public class VerletFysiikkaTest {
    ArrayList<Pallo> aurinkokunta;
    Pallo aurinko;
    Pallo planeetta;
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
        aurinkokunta = new ArrayList<Pallo>();
        aurinko = new Pallo(1000,0,0,0,0);
        planeetta = new Pallo(10,100,0,0,20);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of acceleration method, of class VerletFysiikka.
     */
//    @Test
//    public void testAcceleration() {
//        System.out.println("acceleration");
//        Pallo p = null;
//        int dim = 0;
//        VerletFysiikka instance = null;
//        double expResult = 0.0;
//        double result = instance.acceleration(p, dim);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of distance method, of class VerletFysiikka.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);
        fysiikka = new VerletFysiikka(1,aurinkokunta);
        double expResult = 100;
        double result = fysiikka.distance(aurinko, planeetta);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of step method, of class VerletFysiikka.
     */
//    @Test
//    public void testStep() {
//        System.out.println("step");
//        VerletFysiikka instance = null;
//        instance.step();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    @Test
    public void NewtonI() {
        aurinkokunta.add(aurinko);
        fysiikka = new VerletFysiikka(10,aurinkokunta);
        fysiikka.step();
        assertEquals(0,aurinko.getX(0),0.001);
        assertEquals(0,aurinko.getX(1),0.001);
    }
}
