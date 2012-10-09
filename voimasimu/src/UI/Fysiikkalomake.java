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
   private PalloLogiikka logiikka;
   private JButton lisaaNappi;
   private JButton startNappi;
   private JLabel laskuri;
   private JLabel nopeusTxt;
   private JLabel sijaintiTxt;
   private JLabel xTxt;
   private JLabel yTxt;
   private JLabel massaTxt;
   private DecimalFormat positFormaatti;
   private NumberFormatter positFormaattori;
   private DecimalFormat lukuFormaatti;
   private NumberFormatter lukuFormaattori;
   private double alkumassa;
   private double alkuarvo;
   private int kentanLeveys;

    /**
     * Tyhjä konstruktori
     */
    public Fysiikkalomake() {
    }

    /**
     *
     * @param args komentoriviargumentit
     */
    public Fysiikkalomake(String[] args) {
        this.args = args;
    }

    /**
     *
     * @return Fysiikka-olio
     */
    public VerletFysiikka getFysiikka() {
        return fysiikka;
    }
   
    /**
     *
     * @return lomakeikkuna
     */
    public JFrame getIkkuna() {
       return ikkuna;
   }

    /**
     *
     * @return lista mallinnettavista kappaleista
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

    public void paivitaLaskuri() {
        laskuri.setText("Palloja: " + fysiikka.getPallot().size());
    }

    /**
     * Setteri testejä varten.
     *
     * @param fysiikka
     */
    public void setFysiikka(VerletFysiikka fysiikka) {
        this.fysiikka = fysiikka;
    }

    /**
     * Aseta käynnistys/keskeytysnappulan teksti.
     *
     * @param teksti asetettava teksti
     */
    public void setStartTeksti(String teksti) {
        startNappi.setLabel(teksti);
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
        
        // Aseta formaattitarkistukset
        asetaFormaattitarkistukset();
        
        // Aseta oletusarvot ja parametrit
        asetaParametrit();
        
        // Luo elementit
        luoElementit();
        
        // Asettele elementit
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
        
        c.gridy++;
        c.gridx=0;
        ruutu.add(laskuri,c);
        
        c.gridx=1;
        c.gridwidth=2;
        ruutu.add(lisaaNappi,c);
        
        c.gridx=0;
        c.gridy++;
        c.gridwidth=3;
        ruutu.add(startNappi,c);
        
        luoInstanssit();     
        
        if (args.length>0) {
            logiikka.pallotTiedostosta(args[0], aurinkokunta);
        }
        
        paivitaLaskuri();
        
        // Nappeihin kuuntelijat
        lisaaNappi.addActionListener(new LisaysKuuntelija(this));
        startNappi.addActionListener(new StartKuuntelija(this,simu));
    }
    
    private double fieldGetDouble(JFormattedTextField field) {
        return ((Number)field.getValue()).doubleValue();
    }

    private void luoInstanssit() {
        aurinkokunta = new ArrayList<>();
        fysiikka = new VerletFysiikka(0.001, aurinkokunta);
        logiikka = new PalloLogiikka(this);
        simu = new Simulaattori(fysiikka);
    }

    private void luoElementit() {
        massaTxt = new JLabel("Massa: ");
        massaField = new JFormattedTextField(positFormaatti);
        massaField.setValue(new Double(alkumassa));
        sijaintiTxt = new JLabel("Sijainti: ");
        xTxt = new JLabel(" x");
        yTxt = new JLabel(" y");
        laskuri = new JLabel();
        xField = new JFormattedTextField(lukuFormaatti);
        xField.setValue(new Double(alkuarvo));
        xField.setColumns(kentanLeveys);
        yField = new JFormattedTextField(lukuFormaatti);
        yField.setValue(new Double(alkuarvo));
        yField.setColumns(kentanLeveys);
        nopeusTxt = new JLabel("Alkunopeus: ");
        v_xField = new JFormattedTextField(lukuFormaatti);
        v_xField.setValue(new Double(alkuarvo));
        v_yField = new JFormattedTextField(lukuFormaatti);
        v_yField.setValue(new Double(alkuarvo));
        lisaaNappi = new JButton("Lisää pallo");
        startNappi = new JButton("Käynnistä simulaatio!");
    }

    private void asetaFormaattitarkistukset() {
        positFormaatti = new DecimalFormat("#0.0#;(#)");
        positFormaattori = new NumberFormatter(positFormaatti);
        positFormaattori.setAllowsInvalid(false);
        lukuFormaatti = new DecimalFormat("#0.0#");
        lukuFormaattori = new NumberFormatter(lukuFormaatti);
        lukuFormaattori.setAllowsInvalid(false);
    }

    private void asetaParametrit() {
        alkumassa = 100.0;
        alkuarvo = 0.0;
        kentanLeveys = 5;
    }
}
