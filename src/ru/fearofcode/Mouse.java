package ru.fearofcode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by maks on 6/12/2017.
 */
public class Mouse extends MouseAdapter{
    static boolean pressLeft = false;
    static double xMouse;
    static double yMouse;

    @Override
    public void mousePressed(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1) {

            pressLeft = true;
            xMouse = e.getX();
            yMouse = e.getY();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){
        pressLeft = false;
    }
}
