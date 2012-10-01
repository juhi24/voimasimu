
import javax.swing.SwingUtilities;


/**
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
        Fysiikkalomake lomake = new Fysiikkalomake();
        SwingUtilities.invokeLater(lomake);
    }
}
