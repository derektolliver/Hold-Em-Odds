package com.odds.src.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {

    private static final String TITLE = "Hold 'Em Odds";
    public static final int WIDTH = 750;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private static Menu menu;
    private static CardLayout cards;
    private static ArrayList<JPanel> panels;

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

    /**
     * Creates the panels and adds them to the CardLayout
     */
    private static void init() {
        // Create list for panels
        panels = new ArrayList<JPanel>();

        // Create panels for CardLayout and add them to list
        JPanel menu = new JPanel();
        JPanel options = new JPanel();
        JPanel run = new JPanel();
        panels.add(menu);
        panels.add(options);
        panels.add(run);

        // Add the necessary objects to panels
        for (JPanel panel : panels) {
            addComponents(panel);
        }

        // Create CardLayout and add panels to it
        cards = new CardLayout();
        cards.addLayoutComponent(menu, "menu");
        cards.addLayoutComponent(options, "options");
        cards.addLayoutComponent(run , "run");
    }

    /**
     * Shows the specified panel on the frame
     * @param panel - the panel requested to be shown
     * @param name - name given to the specific panel
     */
    private static void show(Container panel, String name) {
        cards.show(panel, name);
    }

    private static void addComponents(JPanel panel) {
//        switch (panel) {
//          TODO finish this
//        }
    }

}
