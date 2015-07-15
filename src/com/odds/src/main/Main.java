package com.odds.src.main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    private static final String TITLE = "Hold 'Em Odds";
    public static final int WIDTH = 750;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private static Menu menu;

    private static STATE state = STATE.MENU;

    public static void main(String[] args) {

        // Create labels/mouse listeners for start screen menu options
        JLabel calc = new JLabel("Calculator");
        calc.setSize(100, 75);
        calc.setLocation(WIDTH / 2, HEIGHT / 2 - 100);
        calc.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                state = STATE.CALC;
            }
        });
        JLabel options = new JLabel("Options");
        options.setSize(100, 75);
        options.setLocation(WIDTH / 2, 100);
        options.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                state = STATE.OPTIONS;
            }
        });

        // Create panel
        WindowState main = new WindowState(); // starts at menu after paintComponent is called
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        // Create frame
        JFrame frame = new JFrame(TITLE);
        frame.setContentPane(main);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.getContentPane().add(calc);
        //frame.getContentPane().add(options);
        frame.setVisible(true);
        main.setVisible(true);
    }

//    private static void init() { wtf was this code supposed to even do
//        menu = new Menu();
//    }

}
