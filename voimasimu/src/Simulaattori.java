
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class Simulaattori implements Runnable {

    private JFrame ikkuna;
    private Piirturi piirturi;
    private VerletFysiikka fysiikka;
    private Timer ajastin;
    private int leveys;
    private int korkeus;

    /**
     * Alusta simulaattori fysiikkamoottorilla.
     *
     * @param fysiikka
     */
    public Simulaattori(VerletFysiikka fysiikka) {
        this.fysiikka=fysiikka;
    }

    /**
     *
     * @return fysiikka-olio
     */
    public VerletFysiikka getFysiikka() {
        return fysiikka;
    }

    /**
     *
     * @return piirtoikkunan korkeus
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     *
     * @return piirtoikkunan leveys
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Käynnistä simulaatio.
     */
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

    /**
     * Pysäyttää ajastimen ja suorittaa metodin otaAskel().
     * 
     * @see otaAskel()
     */
    public void seuraavaAskel() {
        ajastin.stop();
        otaAskel();
    }
}
