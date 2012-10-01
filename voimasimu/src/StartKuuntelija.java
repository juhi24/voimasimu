
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class StartKuuntelija implements ActionListener {

    private Simulaattori simu;

    /**
     * Alusta käynnistysnapin kuuntelija.
     *
     * @param simu käytettävä simulaattoriolio
     */
    public StartKuuntelija(Simulaattori simu) {
        this.simu = simu;
    }

    /**
     * Käynnistä simulaatio.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(simu);
    }
}
