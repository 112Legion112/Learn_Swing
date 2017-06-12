package ru.fearofcode;


import java.awt.*;
import java.util.LinkedList;

/**
 * Created by maks on 6/11/2017.
 */
public class Player {
    private double x;
    private double y;
    private int d;
    private double speed = 5;

    private LinkedList<Bullet> bulletList  = new LinkedList<>();

    private Color color = Color.red;

    public Player(double x, double y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void updata(){
        move();
        shot();

        for(Bullet bullet : bulletList){
            bullet.updata();
            System.out.println("Draw SHOT");
        }
    }

    private void move(){
        if (KeyBoard.prassA || KeyBoard.prassW || KeyBoard.prassD || KeyBoard.prassS) {
            int angle = 0;

            if (KeyBoard.prassD) {
                angle = 0;
            }
            if (KeyBoard.prassW) {
                angle = 90;
            }
            if (KeyBoard.prassA) {
                angle = 180;
            }
            if (KeyBoard.prassS) {
                angle = 270;
            }
            if (KeyBoard.prassD && KeyBoard.prassW) {
                angle = 45;
            }
            if (KeyBoard.prassW && KeyBoard.prassA) {
                angle = 135;
            }
            if (KeyBoard.prassA && KeyBoard.prassS) {
                angle = 225;
            }
            if (KeyBoard.prassS && KeyBoard.prassD) {
                angle = 315;
            }

            // Rounding of coordinate with error.
            double rad = Math.toRadians(angle);
            x += Math.cos(rad) * speed;
            y -= Math.sin(rad) * speed;
        }
    }

    private void shot(){
        if (Mouse.pressLeft) {
            Bullet bullet = new Bullet(x,y,Mouse.xMouse,Mouse.yMouse);
            bulletList.add(bullet);
        }
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y,d,d);

        for(Bullet bullet : bulletList){
            bullet.draw(g);
            System.out.println("Draw SHOT");
        }
    }

}
