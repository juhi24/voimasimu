
import static java.lang.Math.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jussi24
 */
public class VerletFysiikka {
    private double G;
    private double dt;
    private ArrayList<Pallo> pallot;

    public ArrayList<Pallo> getPallot() {
        return pallot;
    }

    public VerletFysiikka(double dt, ArrayList<Pallo> pallot) {
        this.G = 6;
        this.dt = dt;
        this.pallot = pallot;
    }
    
    public double acceleration(Pallo p, int dim) {
        double a = 0;
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
    
    public double force(Pallo p, int dim) {
        return p.getMass()*this.acceleration(p, dim); //F=ma
    }
    
    public double distance(Pallo p1, Pallo p2) {
        return sqrt(pow(p1.getX(0)-p2.getX(0),2) + pow(p1.getX(1)-p2.getX(1),2));
    }

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
