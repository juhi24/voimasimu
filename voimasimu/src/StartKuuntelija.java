
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jussi24
 */
public class StartKuuntelija implements ActionListener {

    private Simulaattori simu;

    public StartKuuntelija(Simulaattori simu) {
        this.simu = simu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(simu);
    }
}
