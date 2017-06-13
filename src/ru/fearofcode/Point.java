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
    protected double x;
    protected double y;
    private Color color;

    /**
     * It is important add link this object in class {@link PanelGame}
     * @param x coordinate where be create object.
     * @param y coordinate where be create object.
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        PanelGame.createPoint(this);
    }

    /**
     * This method updating data such as x and y coordinate and other data.
     * It is callback method, it method have to called the class {@link PanelGame}.
     * The Link have to gave for the class at time create in constructor.
     */
    abstract public void update();

    /**
     * This method drawing view object.
     * It is callback method, it method have to called the class {@link PanelGame}
     * @param g where have to drawing object.
     */
    abstract public void draw(Graphics2D g);
}