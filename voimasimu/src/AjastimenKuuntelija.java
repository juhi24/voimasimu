
import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
public class AjastimenKuuntelija implements ActionListener {
    private Simulaattori simu;

    public AjastimenKuuntelija(Simulaattori simu) {
        this.simu = simu;
    }

    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
        simu.seuraavaAskel();
    }
    
}
