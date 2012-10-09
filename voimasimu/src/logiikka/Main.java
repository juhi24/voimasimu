package logiikka;


import UI.Fysiikkalomake;
import javax.swing.SwingUtilities;


/**
 * Kutsuu ja käynnistää lomakkeen.
 * 
 * @see Fysiikkalomake
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class Main {

    /**
     * Luo ja käynnistä lomake.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fysiikkalomake lomake = new Fysiikkalomake(args);
        SwingUtilities.invokeLater(lomake);
    }
}
