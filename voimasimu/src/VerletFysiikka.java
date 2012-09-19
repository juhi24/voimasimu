
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
    double G;
    int dt;
    ArrayList<Pallo> pallot;

    public VerletFysiikka(int dt, ArrayList<Pallo> pallot) {
        this.G = 6;
        this.dt = dt;
        this.pallot = pallot;
    }
    
    public double acceleration(Pallo p, int dim) {
        double a = 0;
        double r;
        for (Pallo toinen : pallot) {
            if (p==toinen) {
                continue;
            }
            r = p.getX(dim)-toinen.getX(dim);
            a += -G*toinen.getMass()/pow(r,2)*r/abs(r);
        }
        return a;
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
                a_now=acceleration(p, dim);
                p.setX(p.getX(dim) + p.getV(dim)*dt + 0.5*a_now*dt*dt, dim);
                a_next=acceleration(p, dim);
                p.setV(p.getV(dim)+0.5*(a_now+a_next), dim);
            }
        }
    }
}
