package ru.fearofcode;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WindowGame extends JFrame {

    final static public int WIDTH = 600;
    final static public int HEIGHT = 600;
    public WindowGame(){
        super("Window game");

        PanelGame panelGame = new PanelGame(WIDTH,HEIGHT);
        setContentPane(panelGame);

        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        panelGame.runGame();
    }
}