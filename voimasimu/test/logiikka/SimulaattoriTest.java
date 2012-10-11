/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
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
     * Testataan ettei tyhjä simulaatio räjähdä.
     */
    @Test
    public void testRunTyhja() {
        System.out.println("Tyhjä simulaatio");
        simu.run();
        assertNotNull(simu);
    }

    /**
     * Testataan ettei räjähdä vaikka ajastinta ei alustaisi.
     */
    //@Test
    public void testSeuraavaAskelAlustamattaAjastinta() {
        System.out.println("seuraavaAskel");
        simu.seuraavaAskel();
        assertNull(simu.getAjastin());
    }
}