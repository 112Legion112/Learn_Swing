package ru.fearofcode;

import java.awt.*;

/**
 * Created by maks on 6/11/2017.
 */
public class Player {
    private double x;
    private double y;
    private double d;

    private Color color = Color.red;


    public Player(double x, double y, double d){
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillOval((int)x,(int)y,(int)d,(int)d);
    }

}
