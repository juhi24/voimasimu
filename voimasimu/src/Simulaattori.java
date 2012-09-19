
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
    private Timer ajastin;
    private int leveys;
    private int korkeus;

    public VerletFysiikka getFysiikka() {
        return fysiikka;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    @Override
    public void run() {
        leveys = 600;
        korkeus = 500;
        ikkuna = new JFrame("Gravitaatiosimulaattori");
        ikkuna.setPreferredSize(new Dimension(leveys, korkeus));

        luokomponentit();

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();

        ikkuna.setVisible(true);
        uusiSimulaatio();
    }

    private void luokomponentit() {
        Pallo aurinko = new Pallo(500, 0, 0, 0, 0);
        Pallo planeetta = new Pallo(100, 10, 0, 0, 500);

        ArrayList<Pallo> aurinkokunta = new ArrayList<Pallo>();
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);

        fysiikka = new VerletFysiikka(0.001, aurinkokunta);

        piirturi = new Piirturi(this);
        Container pohja = ikkuna.getContentPane();
        pohja.add(piirturi);
    }
    
    private void uusiSimulaatio() {
        otaAskel();
    }

    private void otaAskel() {
        fysiikka.step();
        ajastin = new Timer(100, new AjastimenKuuntelija(this));
        ajastin.start();
        piirturi.repaint();
    }

    public void seuraavaAskel() {
        ajastin.stop();
        otaAskel();
    }
}
