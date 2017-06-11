package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
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

            //This code for fix black background
            graphics2D.fillRect(0,0,width,height);
        }

        public void draw() {
            player.draw(graphics2D);

            Graphics graphics = getGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
        }
    }

}
