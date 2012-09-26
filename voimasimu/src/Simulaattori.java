
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

    public Simulaattori(VerletFysiikka fysiikka) {
        this.fysiikka=fysiikka;
    }

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
        leveys = 1000;
        korkeus = 800;
        ikkuna = new JFrame("Gravitaatiosimulaattori");
        ikkuna.setPreferredSize(new Dimension(leveys, korkeus));

        luokomponentit();

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();

        ikkuna.setVisible(true);
        uusiSimulaatio();
    }

    private void luokomponentit() {
        piirturi = new Piirturi(this);
        Container pohja = ikkuna.getContentPane();
        pohja.add(piirturi);
    }
    
    private void uusiSimulaatio() {
        otaAskel();
    }

    private void otaAskel() {
        fysiikka.step();
        ajastin = new Timer(10, new AjastimenKuuntelija(this));
        ajastin.start();
        piirturi.repaint();
    }

    public void seuraavaAskel() {
        ajastin.stop();
        otaAskel();
    }
}
