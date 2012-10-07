package UI;


import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import logiikka.*;

/**
 * Lomakkeella voi lisätä kappaleita simulaatioon ja käynnistää sen.
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class Fysiikkalomake implements Runnable {
   private JFrame ikkuna;
   private Simulaattori simu;
   private VerletFysiikka fysiikka;
   private ArrayList<Pallo> aurinkokunta ;
   private JFormattedTextField massaField;
   private JFormattedTextField xField;
   private JFormattedTextField yField;
   private JFormattedTextField v_xField;
   private JFormattedTextField v_yField;
   private String[] args;

    /**
     * Tyhjä konstruktori
     */
    public Fysiikkalomake() {
    }

    public Fysiikkalomake(String[] args) {
        this.args = args;
    }

    public VerletFysiikka getFysiikka() {
        return fysiikka;
    }
   
   public JFrame getIkkuna() {
       return ikkuna;
   }

    /**
     *
     * @return
     */
    public ArrayList<Pallo> getAurinkokunta() {
        return aurinkokunta;
    }

    /**
     *
     * @return massan arvo lomakkeelta
     */
    public double getMassa() {
        return fieldGetDouble(massaField);
    }
    
    /**
     *
     * @return x-koordinaatti lomakkeelta
     */
    public double getX() {
        return fieldGetDouble(xField);
    }
    
    /**
     *
     * @return y-koordinaatti lomakkeelta
     */
    public double getY() {
        return fieldGetDouble(yField);
    }
    
    /**
     *
     * @return alkunopeuden x-komponentti lomakkeelta
     */
    public double getV_x() {
        return fieldGetDouble(v_xField);
    }
    
    /**
     *
     * @return alkunopeuden y-komponentti lomakkeelta
     */
    public double getV_y() {
        return fieldGetDouble(v_yField);
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
        
        double alkumassa=100.0;
        double alkuarvo=0.0;
        int kentanLeveys=5;
        
        JLabel massaTxt = new JLabel("Massa: ");
        massaField = new JFormattedTextField(positFormaatti);
        massaField.setValue(new Double(alkumassa));
        JLabel sijaintiTxt = new JLabel("Sijainti: ");
        JLabel xTxt = new JLabel(" x");
        JLabel yTxt = new JLabel(" y");
        xField = new JFormattedTextField(lukuFormaatti);
        xField.setValue(new Double(alkuarvo));
        xField.setColumns(kentanLeveys);
        yField = new JFormattedTextField(lukuFormaatti);
        yField.setValue(new Double(alkuarvo));
        yField.setColumns(kentanLeveys);
        JLabel nopeusTxt = new JLabel("Alkunopeus: ");
        v_xField = new JFormattedTextField(lukuFormaatti);
        v_xField.setValue(new Double(alkuarvo));
        v_yField = new JFormattedTextField(lukuFormaatti);
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
        
        aurinkokunta = new ArrayList<>();

        fysiikka = new VerletFysiikka(0.001, aurinkokunta);
        
        PalloLogiikka logiikka = new PalloLogiikka(this);
        logiikka.pallotTiedostosta(args, aurinkokunta);
        
        simu = new Simulaattori(fysiikka);
        
        lisaaNappi.addActionListener(new LisaysKuuntelija(this));
        startNappi.addActionListener(new StartKuuntelija(simu));
    }
    
    private double fieldGetDouble(JFormattedTextField field) {
        return ((Number)field.getValue()).doubleValue();
    }
}
