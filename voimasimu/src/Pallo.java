/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jussi24
 */
public class Pallo {
    int mass;
    //int radius;
    int xLoc;
    int yLoc;
    int xVel;
    int yVel;

    public Pallo(int mass, int xLoc, int yLoc, int xVel, int yVel) {
        this.mass = mass;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public int getMass() {
        return mass;
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getxVel() {
        return xVel;
    }

    public int getyLoc() {
        return yLoc;
    }

    public int getyVel() {
        return yVel;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
    
    
}
