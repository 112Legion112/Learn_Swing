package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class WindowGame extends JFrame {
    static private int width = 600;
    static private int height = 600;
    public WindowGame(){
        super("Window game");

        PanelGame panelGame = new PanelGame(width,height);
        setContentPane(panelGame);

        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panelGame.runGame();
    }


    class PanelGame extends JPanel implements Runnable{
        BufferedImage bufferedImage = new BufferedImage(WindowGame.width,WindowGame.height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        Player player = new Player(0,0,25);
        Thread gameThread = new Thread(this);

        public PanelGame(int width, int height){

            setSize(new Dimension(width,height));

            addKeyListener(new KeyBoard());
            setFocusable(true);
        }

        public void runGame(){
            gameThread.run();
        }

        public void draw() {
            // Clear
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillRect(0,0,width,height);

            player.draw(graphics2D);

            Graphics graphics = getGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
        }

        @Override
        public void run() {
            while (true) {
                player.move();
                draw();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}