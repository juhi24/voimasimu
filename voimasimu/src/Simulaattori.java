
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
public class Simulaattori implements Runnable {
    private JFrame ikkuna;
    private Piirturi piirturi;
    private VerletFysiikka fysiikka;

    public VerletFysiikka getFysiikka() {
        return fysiikka;
    }
    
    @Override
    public void run() {
        ikkuna = new JFrame("Gravitaatiosimulaattori");
        ikkuna.setPreferredSize(new Dimension(500,500));
        
        luokomponentit();
        
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        
        ikkuna.setVisible(true);
    }

    private void luokomponentit() {
        Pallo aurinko = new Pallo(1000, 0, 0, 0, 0);
        Pallo planeetta = new Pallo(1000, 10, 0, 0, 500);

        ArrayList<Pallo> aurinkokunta = new ArrayList<Pallo>();
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);

        fysiikka = new VerletFysiikka(0.001, aurinkokunta);
        
        piirturi = new Piirturi(fysiikka.getPallot());
        Container pohja = ikkuna.getContentPane();
        pohja.add(piirturi);
        
        
    }
}
