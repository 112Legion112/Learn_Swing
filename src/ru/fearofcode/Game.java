package ru.fearofcode;

import javax.swing.JFrame;


/**
 * Created by maks on 6/11/2017.
 */
public class Game{


    final static public int WIDTH = 600;
    final static public int HEIGHT = 600;

    final private static WindowGame windowGame = new WindowGame();
    final private static PanelGame panelGame = new PanelGame(WIDTH,HEIGHT);

    final private static Engine ENGINE = new Engine(panelGame);
    final private static Thread gameThread = new Thread(ENGINE);

    public static void main(String[] args){
        windowGame.setContentPane(panelGame);

        windowGame.setSize(WIDTH, HEIGHT);
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.setVisible(true);

        runGame();
    }

    private static void runGame(){
        gameThread.run();
    }

}
