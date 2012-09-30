
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
class LisaysKuuntelija implements ActionListener {
    private Fysiikkalomake lomake;

    public LisaysKuuntelija(Fysiikkalomake lomake) {
        this.lomake = lomake;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pallo kappale = new Pallo(lomake.getMassa(), lomake.getX(), lomake.getY(), lomake.getV_x(), lomake.getV_y());
        switch (lisaaPallo(kappale, lomake.getAurinkokunta())) {
            case 0: break;
            case 1: 
                JOptionPane.showMessageDialog(lomake.getIkkuna(),"Kappaleella täytyy olla massa.", "Virheellinen syöte!", JOptionPane.ERROR_MESSAGE);
                break;
            case 2: 
                JOptionPane.showMessageDialog(lomake.getIkkuna(),"Kappaleen massakeskipiste on liian lähellä toista kappaletta.", "Virheellinen syöte!", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    private int lisaaPallo(Pallo pallo, ArrayList<Pallo> pallot) {
        if (Math.abs(pallo.getMass())<0.0001) {
            return 1; //Liian pieni massa
        }
        for (Pallo p : pallot) {
            if (onLiikaLiki(p,pallo)) {
                return 2; //Liian lähellä toista kappaletta
            }
        }
        pallot.add(pallo);
        return 0;
    }
    
    private boolean onLiikaLiki(Pallo pallo, Pallo toinen) {
        double epsilon = 0.01;
        if (Math.abs(lomake.getFysiikka().distance(pallo, toinen))<epsilon) {
            return true;
        }
        return false;
    }
    
}
