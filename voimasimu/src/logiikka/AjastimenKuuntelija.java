package logiikka;


import java.awt.event.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Kuuntelee simulaattorin ajastinta ja tahdistaa simulaation aika-askeleet
 * sen mukaisesti.
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class AjastimenKuuntelija implements ActionListener {
    private Simulaattori simu;

    /**
     * Konstruoi kuuntelijan isäntäsimulaattoriin.
     *
     * @param simu isäntäsimulaattori
     */
    public AjastimenKuuntelija(Simulaattori simu) {
        this.simu = simu;
    }

    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
        simu.seuraavaAskel();
    }
    
}
