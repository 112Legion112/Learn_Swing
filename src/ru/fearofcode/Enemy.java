package ru.fearofcode;

import java.awt.*;

/**
 * Created by maks on 6/14/2017.
 */
public class Enemy extends Point{
    private int d = 10;
    private int angle;
    private int speed = 4;

    public Enemy(double x, double y) {
        super(x, y);
        angle = (int)(359 * Math.random());
    }

    private void move(){
        double rad = Math.toRadians(angle);
        x +=Math.cos(rad) * speed;
        y -=Math.sin(rad) * speed;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillOval((int)x,(int)y,d,d);
    }
}
