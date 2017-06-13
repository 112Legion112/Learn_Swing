package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by maks on 6/12/2017.
 */
class PanelGame extends JPanel implements Runnable{
    private BufferedImage bufferedImage = new BufferedImage(WindowGame.WIDTH,WindowGame.HEIGHT,BufferedImage.TYPE_INT_RGB);
    private Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

    Thread gameThread = new Thread(this);

    static private Queue<Point> createPoints = new LinkedList<>();
    static private LinkedList<Point> points = new LinkedList<>();

    Player player = new Player(0,0,25);


    public PanelGame(int width, int height){

        setSize(new Dimension(width,height));

        addKeyListener(new KeyBoard());
        addMouseListener(new Mouse());

        setFocusable(true);
    }

    static public void createPoint(Point point){
        createPoints.add(point);
    }

    public void runGame(){
        gameThread.run();
    }


    private void update(){
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
        graphics2D.fillRect(0,0 ,WindowGame.WIDTH,WindowGame.HEIGHT);

        for(Point point : points){
            point.draw(graphics2D);
        }

        Graphics graphics = getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
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
}
