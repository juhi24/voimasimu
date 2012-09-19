
import static java.lang.Math.*;
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
public class Piirturi extends JPanel {
    private Simulaattori simu;

    public Piirturi(Simulaattori simu) {
        this.simu = simu;
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        int x,y,size;
        for (Pallo p : simu.getFysiikka().getPallot()) {
            size=(int)round(sqrt(p.getMass()));
            x=(int)round(p.getX(0)*10+200-size/2);
            y=(int)round(p.getX(1)*10+200-size/2);
            g.fillOval(x, y, size, size);
        }
    }
    
}
