package UI;


import java.awt.*;
import static java.lang.Math.*;
import javax.swing.*;
import logiikka.Pallo;
import logiikka.Simulaattori;


/**
 * Piirtää simulaation reaaliajassa.
 * 
 * Etäisyyksien skaalaus on sisäänrakennettuna parametrisointina.
 * Pallojen koko määräytyy niiden massojen mukaan.
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class Piirturi extends JPanel {
    private Simulaattori simu;
    private double pituusSkaala;

    /**
     * Yhdistää piirturin isäntäsimulaattoriin 
     * ja asettaa etäisyyksien skaalauksen.
     *
     * @param simu isäntäsimulaattori
     */
    public Piirturi(Simulaattori simu) {
        this.simu = simu;
        this.pituusSkaala=4;
    }
    
    /**
     * Piirtää pallot piirtoalustalle niiden sijaintien
     * ja massojen perusteella.
     *
     * @param g grafiikkaolio
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int x,y,size;
        for (Pallo p : simu.getFysiikka().getPallot()) {
            size=(int)round(sqrt(p.getMass()));
            x=(int)round(p.getX(0)*pituusSkaala+simu.getLeveys()/2-size/2);
            y=(int)round(p.getX(1)*pituusSkaala+simu.getKorkeus()/2-size/2);
            g.fillOval(x, y, size, size);
        }
    }
    
}
