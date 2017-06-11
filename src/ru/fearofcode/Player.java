package ru.fearofcode;

import com.sun.webkit.dom.KeyboardEventImpl;

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
        switch (angle) {
            case 0:
                x += speed;
                break;
            case 90:
                y -= speed;
                break;
            case 180:
                x -= speed;
                break;
            case 270:
                y += speed;
                break;
        }
    }


    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillOval((int)x,(int)y,(int)d,(int)d);
    }

}
