package ru.fearofcode;

import java.awt.*;

/**
 * Created by maks on 6/14/2017.
 */
public class Enemy extends Point{
    private int angle;
    private int speed = 4;
    private Point goal;

    public Enemy(double x, double y, Point goal) {
        super(x, y, 10);
        this.goal = goal;
        angle = (int)(359 * Math.random());
    }

    private void move(){
        angle = Angle.pointDerection(x,y,goal.getX(),goal.getY());
        double rad = Math.toRadians(angle);
        x +=Math.cos(rad) * speed;
        y -=Math.sin(rad) * speed;
    }

    private void collision(){
        double dx = Math.abs(x - goal.getX());
        double dy = Math.abs(y - goal.getY());
        if (dx < d && dy < d){
            destroy();
            goal.eat();
        }
    }

    @Override
    public void update() {
        move();
        collision();
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillOval((int)(x-d/2),(int)(y-d/2),(int)d,(int)d);
    }
}
