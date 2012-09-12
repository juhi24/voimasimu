
import java.util.ArrayList;

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
        Pallo aurinko = new Pallo(1000, 0, 0, 0, 0);
        Pallo planeetta = new Pallo(10, 10, 0, 0, 10);
        
        ArrayList<Pallo> aurinkokunta = new ArrayList<Pallo>();
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);
        
        VerletFysiikka fysiikka = new VerletFysiikka(1,aurinkokunta);
        
        fysiikka.step();
        System.out.println(planeetta.getX(0));
        System.out.println(planeetta.getX(1));
        System.out.println(planeetta.getV(0));
        System.out.println(planeetta.getV(1));
        System.out.println("");
        System.out.println(aurinko.getX(0));
        System.out.println(aurinko.getX(1));
    }
}
