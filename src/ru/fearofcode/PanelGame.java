package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by maks on 6/12/2017.
 */
class PanelGame extends JPanel implements Runnable{
    private BufferedImage bufferedImage = new BufferedImage(WindowGame.WIDTH,WindowGame.HEIGHT,BufferedImage.TYPE_INT_RGB);
    private Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

    static public LinkedList<Point> points = new LinkedList<>();

    Player player = new Player(0,0,25);
    Thread gameThread = new Thread(this);

    public PanelGame(int width, int height){

        setSize(new Dimension(width,height));

        addKeyListener(new KeyBoard());
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        setFocusable(true);
    }

    public void runGame(){
        gameThread.run();
    }

    private void draw() {
        // Clear
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0 ,WindowGame.WIDTH,WindowGame.HEIGHT);

        for(Point point : points){
            point.draw(graphics2D);
        }

        Graphics graphics = getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
    }

    private void update(){
        ListIterator<Point> iterator = points.listIterator();
        while(iterator.hasNext()){
            Point point = iterator.next();
            point.update();
        }
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
