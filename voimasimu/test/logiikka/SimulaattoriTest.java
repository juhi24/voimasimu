/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class SimulaattoriTest {
    VerletFysiikka fysiikka;
    Simulaattori simu;
    
    public SimulaattoriTest() {
    }
    
    @Before
    public void setUp() {
        fysiikka = new VerletFysiikka(0.01, new ArrayList<Pallo>());
        simu = new Simulaattori(fysiikka);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Simulaattori.
     */
    @Test
    public void testRunTyhja() {
        System.out.println("Tyhjä simulaatio");
        simu.run();
    }

    /**
     * Test of seuraavaAskel method, of class Simulaattori.
     */
    //@Test
    public void testSeuraavaAskelAlustamattaAjastinta() {
        System.out.println("seuraavaAskel");
        simu.seuraavaAskel();
    }
}
