package ru.fearofcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ListIterator;


/**
 * This class is base for graphics object.
 * Derived from the class have to override method update and draw.
 * Created by maks on 6/12/2017.
 */

abstract public class Point {
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    protected double x;
    protected double y;
    protected double d;
    private Color color;

    /**
     * It is important add link this object in class {@link Engine}
     * @param x coordinate where be create object.
     * @param y coordinate where be create object.
     */
    public Point(double x, double y, double d){
        this.x = x;
        this.y = y;
        this.d = d;
        Engine.createPoint(this);
    }

    public void destroy(){
        Engine.destroyPoints(this);
    }

    public void eat(){
        d+=0.1;
    }
    /**
     * This method updating data such as x and y coordinate and other data.
     * It is callback method, it method have to called the class {@link Engine}.
     * The Link have to gave for the class at time create in constructor.
     */
    abstract public void update();

    /**
     * This method drawing view object.
     * It is callback method, it method have to called the class {@link Engine}
     * @param g where have to drawing object.
     */
    abstract public void draw(Graphics2D g);
}
