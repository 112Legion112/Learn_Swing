package ru.fearofcode;

import java.awt.*;

/**
 * Created by maks on 6/12/2017.
 */
public class Bullet {
    private double x;
    private double y;
    private double speed = 2;
    private int d = 20;
    private int angle;

    public Bullet(double x, double y, double goalX, double goalY){
        this.x = x;
        this.y = y;
        angle = Angle.pointDerection(x,y,goalX,goalY);
    }
    public void updata(){
        move();
    }

    private void move(){
        double rad = Math.toRadians(angle);
        x +=Math.cos(rad) * speed;
        y -=Math.sin(rad) * speed;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,d,d);
    }
}
