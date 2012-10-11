
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
     * Testataan että liian lähekkäiset pallot huomataan.
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
     * Testataan, ettei onLiikaLiki ylireagoi.
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
     * Testataan onnistunut lisäys.
     */
    @Test
    public void testLisaaPallo() {
        System.out.println("lisaaPallo - onnistunut lisäys");
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
     * Testataan että negatiivinen massa huomataan.
     */
    @Test
    public void lisaaNegatMassa() {
        System.out.println("lisaaPallo - negatiivinen massa");
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
     * Testataan että liian lähekkäiset koordinaatit huomataan.
     */
    @Test
    public void lisaaSamaanPisteeseen() {
        System.out.println("lisaaPallo - samat koordinaatit");
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
     * Testataan, että palloja tulee tiedostosta.
     */
    @Test
    public void testPallotTiedostosta() {
        System.out.println("pallotTiedostosta");
        String tiedostonimi = "testikappaleet.csv";
        ArrayList<Pallo> aurinkokunta = new ArrayList<>();
        logiikka.pallotTiedostosta(tiedostonimi, aurinkokunta);
        assertFalse(aurinkokunta.isEmpty());
    }
}
