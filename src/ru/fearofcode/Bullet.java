package ru.fearofcode;

import java.awt.*;

/**
 * Created by maks on 6/12/2017.
 */
public class Bullet extends Point{
    private double speed = 10;
    private int angle;

    public Bullet(double x, double y, double goalX, double goalY){
        super(x,y,20);
        angle = Angle.pointDerection(x,y,goalX,goalY);
    }

    @Override
    public void update(){
        move();
    }

    private void move(){
        double rad = Math.toRadians(angle);
        x +=Math.cos(rad) * speed;
        y -=Math.sin(rad) * speed;
    }

    @Override
    public void draw(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillOval((int)(x-d/2),(int)(y-d/2),(int)d,(int)d);
    }
}
