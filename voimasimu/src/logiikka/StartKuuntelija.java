package logiikka;

import UI.Fysiikkalomake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class StartKuuntelija implements ActionListener {
    private Fysiikkalomake lomake;
    private Simulaattori simu;

    /**
     * Alusta käynnistysnapin kuuntelija.
     *
     * @param lomake isäntälomake
     * @param simu käytettävä simulaattoriolio
     */
    public StartKuuntelija(Fysiikkalomake lomake, Simulaattori simu) {
        this.lomake = lomake;
        this.simu = simu;
    }

    /**
     * Käynnistä tai keskeytä simulaatio.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Thread thread = new Thread(simu);
        if (simu.getAjastin()==null) {
            System.out.println("ei käynnissä, käynnistetään.");
            simu.setPysaytyskasky(false);
            thread.start();
            lomake.setStartTeksti("Keskeytä simulaatio!");
        } else if (simu.getAjastin().isRunning()) {
            simu.setPysaytyskasky(true);
            lomake.setStartTeksti("Jatka simulaatiota!");
            //System.out.println("seis!");
        } else {
            simu.setPysaytyskasky(false);
            simu.seuraavaAskel();
            lomake.setStartTeksti("Keskeytä simulaatio!");
            //System.out.println("jatkuu");
        }
    }
}
