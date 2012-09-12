/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
public class Pallo {
    double mass;
    //int radius;
    double[] x = new double[2];
    double[] v = new double[2];

    public Pallo(double mass, double x, double y, double v_x, double v_y) {
        this.x[0]=x;
        this.x[1]=y;
        this.v[0]=v_x;
        this.v[1]=v_y;
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }
    
    public double[] getX() {
        return x;
    }

    public double getX(int dimension) {
        return x[dimension];
    }

    public double getV(int dimension) {
        return v[dimension];
    }

    public void setX(double value, int dimension) {
        this.x[dimension] = value;
    }
    
    public void setV(double value, int dimension) {
        this.v[dimension] = value;
    }
    
}
