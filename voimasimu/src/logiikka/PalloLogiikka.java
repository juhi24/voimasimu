/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import UI.Fysiikkalomake;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author jussi24
 */
public class PalloLogiikka {

    private Fysiikkalomake lomake;

    public PalloLogiikka(Fysiikkalomake lomake) {
        this.lomake = lomake;
    }

    public boolean onLiikaLiki(Pallo pallo, Pallo toinen) {
        double epsilon = 0.01;
        if (Math.abs(lomake.getFysiikka().etaisyys(pallo, toinen)) < epsilon) {
            return true;
        }
        return false;
    }

    public int lisaaPallo(double massa, double x, double y, double v_x, double v_y, ArrayList<Pallo> pallot) {
        Pallo pallo = new Pallo(massa, x, y, v_x, v_y);
        if (Math.abs(pallo.getMass()) < 1.0E-4) {
            return 1; //Liian pieni massa
        }
        for (Pallo p : pallot) {
            if (onLiikaLiki(p, pallo)) {
                return 2; //Liian lähellä toista kappaletta
            }
        }
        pallot.add(pallo);
        return 0;
    }

    public void pallotTiedostosta(String[] args, ArrayList<Pallo> aurinkokunta) {
        if (args[0].isEmpty()) {
            return;
        }
        try {
            String tiedostonimi = args[0];
            FileInputStream fstream = new FileInputStream(tiedostonimi);
            try (DataInputStream in = new DataInputStream(fstream)) {
                BufferedReader lukija = new BufferedReader(new InputStreamReader(in));
                String rivi;
                String[] paloiteltu;
                int rivinro = 0;
                double m, x, y, v_x, v_y;
                while ((rivi = lukija.readLine()) != null) {
                    rivinro++;
                    paloiteltu = rivi.split(",");
                    m = Double.parseDouble(paloiteltu[0]);
                    x = Double.parseDouble(paloiteltu[1]);
                    y = Double.parseDouble(paloiteltu[2]);
                    v_x = Double.parseDouble(paloiteltu[3]);
                    v_y = Double.parseDouble(paloiteltu[4]);
                    switch (lisaaPallo(m, x, y, v_x, v_y, aurinkokunta)) {
                        case 0:
                            System.out.println("Rivi " + rivinro + ": Kappale lisätty onnistuneesti!");
                            break;
                        case 1:
                            System.err.println("Rivi " + rivinro + ": VIRHE! Kappaleella on oltava positiivinen massa.");
                            break;
                        case 2:
                            System.err.println("Rivi " + rivinro + ": VIRHE! Kappale on liian lähellä aiemmin lisättyä kappaletta.");
                            break;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Virhe: " + e.getMessage());
        }
    }
}