
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
    
    private double acceleration(Pallo p, int dim) {
        double a;
        double a_dim = 0;
        double r;
        for (Pallo toinen : pallot) {
            if (p==toinen) {
                continue;
            }
            r = p.getX(dim)-toinen.getX(dim);
            a = -G*toinen.getMass()/pow(distance(p,toinen),2); //gravitaatiolaki
            a_dim += a/distance(p,toinen)*r;
        }
        return a_dim;
    }
    
    /**
     * Kahden kappaleen välinen etäisyys.
     *
     * @param p1 kappale 1
     * @param p2 kappale 2
     * @return kappaleiden 1 ja 2 välinen etäisyys
     */
    public double distance(Pallo p1, Pallo p2) {
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
                a_now=acceleration(p, dim);
                p.setX(p.getX(dim) + p.getV(dim)*dt + 0.5*a_now*dt*dt, dim);
                a_next=acceleration(p, dim);
                p.setV(p.getV(dim)+0.5*(a_now+a_next), dim);
            }
        }
    }
}
