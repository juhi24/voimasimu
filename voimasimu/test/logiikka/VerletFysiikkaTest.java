package logiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
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
    
    @Before
    public void setUp() {
        aurinkokunta = new ArrayList<>();
        aurinko = new Pallo(1000,0,0,0,0);
        planeetta = new Pallo(10,100,0,0,20);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Testataan että etäisyys lasketaan oikein.
     */
    @Test
    public void testEtaisyys() {
        System.out.println("distance");
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);
        fysiikka = new VerletFysiikka(1,aurinkokunta);
        double expResult = 100.0;
        double result = fysiikka.etaisyys(aurinko, planeetta);
        System.out.println(result);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Tarkistetaan ettei tyhjä simulaatio riko mitään.
     */
    @Test
    public void testEmptyStep() {
        System.out.println("step");
        fysiikka = new VerletFysiikka(1, aurinkokunta);
        fysiikka.step();
        assertNotNull(fysiikka);
    }
    
    /**
     * Testaa Newtonin I lain toteutumista staattisessa tilanteessa.
     */
    @Test
    public void testNewtonI_static() {
        System.out.println("Newton I staattinen");
        aurinkokunta.add(aurinko);
        fysiikka = new VerletFysiikka(10,aurinkokunta);
        fysiikka.step();
        assertEquals(0,aurinko.getX(0),0.001);
        assertEquals(0,aurinko.getX(1),0.001);
    }
    
    /**
     * Testaa Newtonin I lain toteutumista tasaisen liikkeen tapauksessa.
     */
    @Test
    public void testNewtonI_steady() {
        System.out.println("Newton I tasainen nopeus");
        aurinkokunta.add(planeetta);
        fysiikka = new VerletFysiikka(1,aurinkokunta);
        fysiikka.step();
        fysiikka.step();
        assertEquals(0,planeetta.getV(0),0.01);
        assertEquals(20,planeetta.getV(1),0.01);
    }
    
    /**
     * Testaa Newtonin III lain toteutumista.
     */
    @Test
    public void testNewtonIII() {
        System.out.println("Newton III");
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);
        fysiikka = new VerletFysiikka(1,aurinkokunta);
        double voima1 = aurinko.getMass()*fysiikka.kiihtyvyys(aurinko, 0);
        double voima2 = planeetta.getMass()*fysiikka.kiihtyvyys(planeetta, 0);
        assertEquals(voima1, -voima2,0.01);
    }
}
