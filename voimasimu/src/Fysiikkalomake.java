
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

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
        
        DecimalFormat positFormaatti = new DecimalFormat("#0.0#;(#)");
        NumberFormatter positFormaattori = new NumberFormatter(positFormaatti);
        positFormaattori.setAllowsInvalid(false);
        DecimalFormat lukuFormaatti = new DecimalFormat("#0.0#");
        NumberFormatter lukuFormaattori = new NumberFormatter(lukuFormaatti);
        lukuFormaattori.setAllowsInvalid(false);
        
        double alkuarvo=0.0;
        int kentanLeveys=5;
        
        JLabel massaTxt = new JLabel("Massa: ");
        JFormattedTextField massaField = new JFormattedTextField(positFormaatti);
        massaField.setValue(new Double(alkuarvo));
        JLabel sijaintiTxt = new JLabel("Sijainti: ");
        JLabel xTxt = new JLabel(" x");
        JLabel yTxt = new JLabel(" y");
        JFormattedTextField xField = new JFormattedTextField(lukuFormaatti);
        xField.setValue(new Double(alkuarvo));
        xField.setColumns(kentanLeveys);
        JFormattedTextField yField = new JFormattedTextField(lukuFormaatti);
        yField.setValue(new Double(alkuarvo));
        yField.setColumns(kentanLeveys);
        JLabel nopeusTxt = new JLabel("Alkunopeus: ");
        JFormattedTextField v_xField = new JFormattedTextField(lukuFormaatti);
        v_xField.setValue(new Double(alkuarvo));
        JFormattedTextField v_yField = new JFormattedTextField(lukuFormaatti);
        v_yField.setValue(new Double(alkuarvo));
        JButton lisaaNappi = new JButton("Lisää pallo");
        JButton startNappi = new JButton("Käynnistä simulaatio!");
        
        c.gridx=0;
        c.gridy=0;
        ruutu.add(massaTxt,c);
        
        c.gridx=1;
        c.gridwidth=2;
        ruutu.add(massaField,c);
        
        c.gridx=1;
        c.gridy++;
        c.gridwidth=1;
        ruutu.add(xTxt,c);
        
        c.gridx=2;
        ruutu.add(yTxt,c);
        
        c.gridx=0;
        c.gridy++;
        ruutu.add(sijaintiTxt,c);
        
        c.gridx=1;
        ruutu.add(xField,c);
        
        c.gridx=2;
        ruutu.add(yField,c);
        
        c.gridx=0;
        c.gridy++;
        ruutu.add(nopeusTxt,c);
        
        c.gridx=1;
        ruutu.add(v_xField,c);
        
        c.gridx=2;
        ruutu.add(v_yField,c);
        
        c.gridx=1;
        c.gridy++;
        c.gridwidth=2;
        ruutu.add(lisaaNappi,c);
        
        c.gridx=0;
        c.gridy++;
        c.gridwidth=3;
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
        
        lisaaNappi.addActionListener(new LisaysKuuntelija(aurinkokunta,massaField,xField,yField,v_xField,v_yField));
        startNappi.addActionListener(new StartKuuntelija(simu));
    }
}
