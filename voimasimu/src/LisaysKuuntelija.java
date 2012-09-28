
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
class LisaysKuuntelija implements ActionListener {
    private ArrayList<Pallo> aurinkokunta;
    private JFormattedTextField massaField;
    private JFormattedTextField xField;
    private JFormattedTextField yField;
    private JFormattedTextField v_xField;
    private JFormattedTextField v_yField;

    public LisaysKuuntelija(ArrayList<Pallo> aurinkokunta, JFormattedTextField massaField, JFormattedTextField xField, JFormattedTextField yField, JFormattedTextField v_xField, JFormattedTextField v_yField) {
        this.aurinkokunta = aurinkokunta;
        this.massaField = massaField;
        this.xField = xField;
        this.yField = yField;
        this.v_xField = v_xField;
        this.v_yField = v_yField;
    }
    
    private double fieldGetDouble(JFormattedTextField field) {
        return ((Number)field.getValue()).doubleValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Pallo kappale = new Pallo(fieldGetDouble(massaField), fieldGetDouble(xField), fieldGetDouble(yField), fieldGetDouble(v_xField), fieldGetDouble(v_yField));
        aurinkokunta.add(kappale);
    }
    
}
