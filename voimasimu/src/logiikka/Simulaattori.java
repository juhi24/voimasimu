package logiikka;

import UI.Piirturi;
import java.awt.*;
import javax.swing.*;

/**
 * Keskusluokka, joka toimii fysiikkaluokan ja piirturin välissä.
 *
 * Luo piirtoikkunan ja kutsuu siihen piirturin. Hallitsee ajastinta ja lähettää
 * piirturille piirtokomennot.
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
    private boolean pysaytyskasky;

    /**
     * Alusta simulaattori fysiikkamoottorilla.
     *
     * @param fysiikka simuloitava fysiikka
     */
    public Simulaattori(VerletFysiikka fysiikka) {
        this.fysiikka = fysiikka;
    }

    /**
     * Simulaatiofysiikan getteri.
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
     * Simulaation ajastimen getteri.
     *
     * @return simulaation ajastin
     */
    public Timer getAjastin() {
        return ajastin;
    }

    /**
     * Pysäytyskäskyn ollessa voimassa (true), simulaatio keskeytetään ennen seuraavaa aika-askelta.
     *
     * @return pysäytyskäskyn arvo
     */
    public boolean isPysaytyskasky() {
        return pysaytyskasky;
    }

    /**
     * Pysäytyskäskyn setteri.
     * 
     * @see isPysaytyskasky()
     *
     * @param pysaytysKasky käskyn arvo
     */
    public void setPysaytyskasky(boolean pysaytysKasky) {
        this.pysaytyskasky = pysaytysKasky;
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
        if (pysaytyskasky) {
            return;
        }
        fysiikka.step();
        ajastin = new Timer(10, new AjastimenKuuntelija(this));
        ajastin.start();
        piirturi.repaint();
    }

    /**
     * Pysäyttää ajastimen ja suorittaa metodin ja antaa käskyn seuraavan
     * aika-askeleen ottamiseen.
     */
    public void seuraavaAskel() {
        if (ajastin!=null && ajastin.isRunning()) {
            ajastin.stop();
        } 
        otaAskel();
    }
}
