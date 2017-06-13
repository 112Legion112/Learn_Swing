package ru.fearofcode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by maks on 6/12/2017.
 */
public class Mouse extends MouseAdapter{
    static boolean pressLeft = false;
    static boolean pressRight = false;

    static double xMouse;
    static double yMouse;

    @Override
    public void mouseClicked(MouseEvent e){
        switch(e.getButton()){
            case MouseEvent.BUTTON3:
                new Enemy(e.getX(),e.getY());
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                pressLeft = true;
                xMouse = e.getX();
                yMouse = e.getY();
                break;
        }

    }
    @Override
    public void mouseReleased(MouseEvent e){
        switch(e.getButton()){
            case MouseEvent.BUTTON1:
                pressLeft = false;
                break;
        }
    }
}
