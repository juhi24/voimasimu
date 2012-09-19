
import java.util.ArrayList;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jussitii
 */
public class voimasimu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Simulaattori simu = new Simulaattori();
        SwingUtilities.invokeLater(simu);
        
        Pallo aurinko = new Pallo(1000, 0, 0, 0, 0);
        Pallo planeetta = new Pallo(10, 10, 0, 0, 500);

        ArrayList<Pallo> aurinkokunta = new ArrayList<Pallo>();
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);

        VerletFysiikka fysiikka = new VerletFysiikka(0.001, aurinkokunta);

        for (int i = 0; i < 50; i++) {
            System.out.println("P: x=" + planeetta.getX(0) + " y=" + planeetta.getX(1));
            fysiikka.step();
        }
        System.out.println("");
        System.out.println(aurinko.getX(0));
        System.out.println(aurinko.getX(1));
    }
}
