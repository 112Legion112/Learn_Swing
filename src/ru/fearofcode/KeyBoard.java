package ru.fearofcode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by maks on 6/12/2017.
 */
public class KeyBoard implements KeyListener{
    static boolean prassA = false;
    static boolean prassW = false;
    static boolean prassD = false;
    static boolean prassS = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                prassA = true;
                break;
            case KeyEvent.VK_W:
                prassW = true;
                break;
            case KeyEvent.VK_D:
                prassD = true;
                break;
            case KeyEvent.VK_S:
                prassS = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                prassA = false;
                break;
            case KeyEvent.VK_W:
                prassW = false;
                break;
            case KeyEvent.VK_D:
                prassD = false;
                break;
            case KeyEvent.VK_S:
                prassS = false;
                break;
        }
    }
}
