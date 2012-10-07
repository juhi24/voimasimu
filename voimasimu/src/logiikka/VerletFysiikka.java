package logiikka;


import static java.lang.Math.*;
import java.util.ArrayList;

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class VerletFysiikka {
    private double G;
    private double dt;
    private ArrayList<Pallo> pallot;

    /**
     * Palauttaa simuloitavat kappaleet.
     *
     * @return simuloitavat kappaleet
     */
    public ArrayList<Pallo> getPallot() {
        return pallot;
    }

    /**
     * Alusta fysiikkamoottori.
     *
     * @param dt aika-askeleen pituus
     * @param pallot simuloitavat kappaleet
     */
    public VerletFysiikka(double dt, ArrayList<Pallo> pallot) {
        this.G = 6;
        this.dt = dt;
        this.pallot = pallot;
    }
    
    private double kiihtyvyys(Pallo p, int dim) {
        double a;
        double a_dim = 0;
        double r;
        for (Pallo toinen : pallot) {
            if (p==toinen) {
                continue;
            }
            r = p.getX(dim)-toinen.getX(dim);
            a = -G*toinen.getMass()/pow(etaisyys(p,toinen),2); //gravitaatiolaki
            a_dim += a/etaisyys(p,toinen)*r;
        }
        return a_dim;
    }
    
    /**
     * Kahden kappaleen massakeskipisteiden välinen etäisyys.
     * 
     * r=sqrt((x1-x2)^2+(y1-y2)^2)
     *
     * @param p1 kappale 1
     * @param p2 kappale 2
     * @return kappaleiden 1 ja 2 välinen etäisyys
     */
    public double etaisyys(Pallo p1, Pallo p2) {
        return sqrt(pow(p1.getX(0)-p2.getX(0),2) + pow(p1.getX(1)-p2.getX(1),2));
    }

    /**
     * Simuloi yksi aika-askel eteenpäin.
     */
    public void step() {
        double a_now,a_next;
        for (Pallo p : pallot) {
            for (int dim=0; dim<2; dim++) {
                //velocity verlet -algoritmi:
                a_now=kiihtyvyys(p, dim);
                p.setX(p.getX(dim) + p.getV(dim)*dt + 0.5*a_now*dt*dt, dim);
                a_next=kiihtyvyys(p, dim);
                p.setV(p.getV(dim)+0.5*(a_now+a_next), dim);
            }
        }
    }
}
