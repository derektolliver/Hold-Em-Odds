package com.odds.src.main;

import javax.swing.*;
import java.awt.*;

public class UserInterface {

    // instance variables
    public static final int WIDTH = 750;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private static Color backgroundColor = Color.darkGray;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static JFrame frame = new JFrame();

    public static void window() {
        frame.setSize(WIDTH, HEIGHT);
        frame.getContentPane().setSize(WIDTH, HEIGHT);
        frame.setLocation(screenSize.width/2 - WIDTH /2, screenSize.height/2 - HEIGHT /2);
        frame.getContentPane().setBackground(backgroundColor);
        frame.setVisible(true);
        hand(frame.getContentPane().getGraphics());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void hand(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawRect(25, 25, WIDTH - 25, 100);
        g.setColor(Color.BLACK);
        g.fillRect(25, 25, WIDTH - 25, 100);
        frame.update(g);
    }

}
