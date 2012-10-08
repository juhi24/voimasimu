package logiikka;


import UI.Fysiikkalomake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Kuuntelee "lisää kappale"-nappia ja luo Pallo-olioita lomakkeen
 * tietojen perusteella.
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class LisaysKuuntelija implements ActionListener {
    private Fysiikkalomake lomake;
    private PalloLogiikka logiikka;

    /**
     * Konstruoi kuuntelijan liittäen sen isäntälomakkeeseen.
     *
     * @param lomake isäntälomake
     */
    public LisaysKuuntelija(Fysiikkalomake lomake) {
        this.lomake = lomake;
        logiikka = new PalloLogiikka(lomake);
    }

    /**
     * Luo kappaleen lomakkeen tietojen perusteella tai antaa
     * käyttäjälle virhekoodin mukaisen virheilmoituksen.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (logiikka.lisaaPallo(lomake.getMassa(), lomake.getX(), lomake.getY(), lomake.getV_x(), lomake.getV_y(), lomake.getAurinkokunta())) {
            case 0: break;
            case 1: 
                JOptionPane.showMessageDialog(lomake.getIkkuna(),"Kappaleella täytyy olla massa.", "Virheellinen syöte!", JOptionPane.ERROR_MESSAGE);
                break;
            case 2: 
                JOptionPane.showMessageDialog(lomake.getIkkuna(),"Kappaleen massakeskipiste on liian lähellä toista kappaletta.", "Virheellinen syöte!", JOptionPane.ERROR_MESSAGE);
                break;
        }
        lomake.paivitaLaskuri();
    }
    
}
