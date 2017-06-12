package ru.fearofcode;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by maks on 6/11/2017.
 */
public class Player {

    private double x;
    private double y;
    private double d;
    private double speed = 5;

    private Color color = Color.red;

    public Player(double x, double y, double d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
    public void move(int angle){
        // Work if press keyboard (A,W,D,S)
        // Rounding of coordinate with error.
        double rad = Math.toRadians(angle);
        x += Math.cos(rad) * speed;
        y -= Math.sin(rad) * speed;
    }


    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillOval((int)x,(int)y,(int)d,(int)d);
    }

}
