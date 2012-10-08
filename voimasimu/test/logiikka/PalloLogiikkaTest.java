
package logiikka;

import UI.Fysiikkalomake;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class PalloLogiikkaTest {
    PalloLogiikka logiikka;
    Fysiikkalomake lomake;
    VerletFysiikka fyssa;
    
    public PalloLogiikkaTest() {
    }
    
    @Before
    public void setUp() {
        lomake = new Fysiikkalomake();
        fyssa = new VerletFysiikka(1, new ArrayList<Pallo>());
        logiikka = new PalloLogiikka(lomake);
        lomake.setFysiikka(fyssa);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of onLiikaLiki method, of class PalloLogiikka.
     */
    @Test
    public void testOnLiikaLiki() {
        System.out.println("onLiikaLiki");
        Pallo pallo = new Pallo(100, 0, 0, 0, 0);
        Pallo toinen = new Pallo(200, 0, 0, 10, 10);
        boolean expResult = true;
        boolean result = logiikka.onLiikaLiki(pallo, toinen);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of onLiikaLiki method, of class PalloLogiikka.
     */
    @Test
    public void testEiOleLiikaLiki() {
        System.out.println("onLiikaLiki");
        Pallo pallo = new Pallo(100, 50, 0, 0, 0);
        Pallo toinen = new Pallo(200, 0, 0, 10, 10);
        boolean expResult = false;
        boolean result = logiikka.onLiikaLiki(pallo, toinen);
        assertEquals(expResult, result);
    }

    /**
     * Test of lisaaPallo method, of class PalloLogiikka.
     */
    @Test
    public void testLisaaPallo() {
        System.out.println("lisaaPallo");
        double massa = 100.0;
        double x = 0.0;
        double y = 0.0;
        double v_x = 0.0;
        double v_y = 0.0;
        ArrayList<Pallo> pallot = new ArrayList<>();
        int expResult = 0;
        int result = logiikka.lisaaPallo(massa, x, y, v_x, v_y, pallot);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of lisaaPallo method, of class PalloLogiikka.
     */
    @Test
    public void lisaaNegatMassa() {
        System.out.println("lisaaPallo");
        double massa = -100.0;
        double x = 0.0;
        double y = 0.0;
        double v_x = 0.0;
        double v_y = 0.0;
        ArrayList<Pallo> pallot = new ArrayList<>();
        int expResult = 1;
        int result = logiikka.lisaaPallo(massa, x, y, v_x, v_y, pallot);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of lisaaPallo method, of class PalloLogiikka.
     */
    @Test
    public void lisaaSamaanPisteeseen() {
        System.out.println("lisaaPallo");
        double massa = 100.0;
        double x = 0.0;
        double y = 0.0;
        double v_x = 0.0;
        double v_y = 0.0;
        ArrayList<Pallo> pallot = new ArrayList<>();
        int expResult = 2;
        logiikka.lisaaPallo(massa, x, y, v_x, v_y, pallot);
        int result = logiikka.lisaaPallo(200, 0, 0, 5, 5, pallot);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of pallotTiedostosta method, of class PalloLogiikka.
     */
    @Test
    public void testPallotTiedostosta() {
        System.out.println("pallotTiedostosta");
        String tiedostonimi = "testikappaleet.csv";
        ArrayList<Pallo> aurinkokunta = new ArrayList<>();
        logiikka.pallotTiedostosta(tiedostonimi, aurinkokunta);
    }
}
