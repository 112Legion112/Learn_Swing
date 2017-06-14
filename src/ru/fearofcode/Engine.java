package ru.fearofcode;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by maks on 6/14/2017.
 */
public class Engine implements Runnable {
    final static private Queue<Point> createPoints = new LinkedList<>();
    final static private LinkedList<Point> points = new LinkedList<>();

    final private BufferedImage bufferedImage = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB);
    final private Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();


    final private PanelGame panelGame;

    final private Player player = new Player(0,0,25);

    public Engine(PanelGame panelGame){
        this.panelGame = panelGame;
    }


    @Override
    public void run() {
        while (true) {
            update();
            draw();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static public void createPoint(Point point){
        createPoints.add(point);
    }
    static private void update(){
        //Add object of create in list points
        int sizeQueue = createPoints.size();
        for(int i = 0; i < sizeQueue; i++){
            Point point = createPoints.remove();
            points.add(point);
        }

        ListIterator<Point> iterator = points.listIterator();
        while(iterator.hasNext()){
            Point point = iterator.next();
            point.update();
        }
    }

    private void draw() {
        // Clear panel
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0 ,Game.WIDTH,Game.HEIGHT);

        for(Point point : points){
            point.draw(graphics2D);
        }
        Graphics graphics = panelGame.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
    }
}
