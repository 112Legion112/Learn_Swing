package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class WindowGame extends JFrame {
    static private int width = 400;
    static private int height = 400;
    public WindowGame(){
        super("Window game");

        PanelGame panelGame = new PanelGame(width,height);
        setContentPane(panelGame);

        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);


        while(true) {
            panelGame.draw();
        }
    }


    class PanelGame extends JPanel {
        BufferedImage bufferedImage = new BufferedImage(WindowGame.width,WindowGame.height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        Player player = new Player(0,0,25);



        public PanelGame(int width, int height){
            setSize(new Dimension(width,height));

            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    int angle = 0;

                    switch(keyCode){
                        case KeyEvent.VK_D:
                            angle = 0;
                            break;
                        case KeyEvent.VK_W:
                            angle = 90;
                            break;
                        case KeyEvent.VK_A:
                            angle = 180;
                            break;
                        case KeyEvent.VK_S:
                            angle = 270;
                            break;
                    }

                    player.move(angle);
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
            setFocusable(true);
        }

        public void draw() {
            // Clear
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillRect(0,0,width,height);

            player.draw(graphics2D);

            Graphics graphics = getGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
        }
    }

}
