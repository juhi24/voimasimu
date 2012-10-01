/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jussi Tiira <jussi.tiira@helsinki.fi>
 */
public class Pallo {
    private double mass;
    private double[] x = new double[2];
    private double[] v = new double[2];

    /**
     * Alusta Pallo.
     * 
     * @param mass  kappaleen massa
     * @param x     keskipisteen x-koordinaatti
     * @param y     keskipisteen y-koordinaatti
     * @param v_x   nopeuden x-komponentti
     * @param v_y   nopeuden y-komponentti
     */
    public Pallo(double mass, double x, double y, double v_x, double v_y) {
        this.x[0]=x;
        this.x[1]=y;
        this.v[0]=v_x;
        this.v[1]=v_y;
        this.mass = mass;
    }

    /**
     *
     * @return kappaleen massa
     */
    public double getMass() {
        return mass;
    }

    /**
     * Palauttaa pallon sijainnin x- tai y-komponentin.
     *
     * @param dimension komponentti x arvolla 0 tai y arvolla 1
     * @return pyydetty paikkakomponentti
     */
    public double getX(int dimension) {
        return x[dimension];
    }

    /**
     * Palauttaa pallon nopeuden x- tai y-komponentin.
     *
     * @param dimension komponentti x arvolla 0 tai y arvolla 1
     * @return pyydetty nopeuskomponentti
     */
    public double getV(int dimension) {
        return v[dimension];
    }

    /**
     * Aseta pallon paikkakomponentti.
     *
     * @param value asetettava arvo
     * @param dimension komponentti x arvolla 0 tai y arvolla 1
     */
    public void setX(double value, int dimension) {
        this.x[dimension] = value;
    }
    
    /**
     * Aseta pallon nopeuskomponentti.
     *
     * @param value asetettava arvo
     * @param dimension komponentti x arvolla 0 tai y arvolla 1
     */
    public void setV(double value, int dimension) {
        this.v[dimension] = value;
    }
    
}
