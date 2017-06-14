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
class PanelGame extends JPanel{



    public PanelGame(int width, int height){

        setSize(new Dimension(width,height));

        addKeyListener(new KeyBoard());
        addMouseListener(new Mouse());

        setFocusable(true);
    }
}
