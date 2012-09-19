
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
    private ArrayList<Pallo> pallot;

    public Piirturi(ArrayList<Pallo> pallot) {
        this.pallot = pallot;
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        int x,y,size;
        for (Pallo p : pallot) {
            x=(int)round(p.getX(0)*10+200);
            y=(int)round(p.getX(1)*10+200);
            size=(int)round(p.getMass()/50.0);
            g.fillOval(x, y, size, size);
        }
    }
    
}
