
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
public class Fysiikkalomake implements Runnable {
   private JFrame ikkuna;
   private Simulaattori simu;
   private VerletFysiikka fysiikka;

    public Fysiikkalomake() {
    }

    @Override
    public void run() {
        ikkuna = new JFrame("Aseta fysiikka");
        //ikkuna.setPreferredSize(new Dimension(200,200));
        
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ikkuna.getContentPane());
        
        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    public JFrame getIkkuna() {
        return ikkuna;
    }

    private void luoKomponentit(Container ruutu) {
        GridBagLayout asettelu = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        ruutu.setLayout(asettelu);
        
        c.fill = GridBagConstraints.BOTH;
        
        JLabel massaTxt = new JLabel("Massa: ");
        JTextField massaField = new JTextField();
        JLabel sijaintiTxt = new JLabel("Sijainti: ");
        JTextField xField = new JTextField();
        JLabel nopeusTxt = new JLabel("Alkunopeus: ");
        JTextField v_xField = new JTextField();
        JButton startNappi = new JButton("Käynnistä simulaatio");
        
        c.gridx=0;
        c.gridy=0;
        ruutu.add(massaTxt,c);
        
        c.gridx=1;
        ruutu.add(massaField,c);
        
        c.gridx=0;
        c.gridy=1;
        ruutu.add(sijaintiTxt,c);
        
        c.gridx=1;
        ruutu.add(xField,c);
        
        c.gridx=0;
        c.gridy=2;
        ruutu.add(nopeusTxt,c);
        
        c.gridx=1;
        ruutu.add(v_xField,c);
        
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=2;
        ruutu.add(startNappi,c);
        
        Pallo aurinko = new Pallo(1000, 0, 0, 0, 0);
        Pallo planeetta = new Pallo(80, 35, 0, 0, 400);
        Pallo murikka = new Pallo(40, -10, 0, 0, -800);

        ArrayList<Pallo> aurinkokunta = new ArrayList<>();
        aurinkokunta.add(aurinko);
        aurinkokunta.add(planeetta);
        aurinkokunta.add(murikka);

        fysiikka = new VerletFysiikka(0.001, aurinkokunta);
        
        simu = new Simulaattori(fysiikka);
        
        startNappi.addActionListener(new startKuuntelija(simu));
    }
}
