package com.odds.src.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class WindowState extends JPanel {

    private STATE state;

    public WindowState() {
        state = STATE.MENU;
        paintComponent(getGraphics());
    }

    public WindowState(STATE state) {
        this.state = state;
    }

    /**
     * Changes the state of the JPanel to alter display
     * @param state is the new state being sent to the panel
     */
    public void changeState(STATE state) {
        this.state = state;
        paintComponent(getGraphics());
    }

    /**
     * Creates new window based on changed state
     * @param g is the Graphics component used to create display
     */
    public void paintComponent(Graphics g) {
        // TODO figure out if there is a problem with this being called twice?
        if (state == STATE.MENU) {
            System.out.println("buttons are being added");
            mainState();
        } else if (state == STATE.OPTIONS) {
            System.out.println("OH YEAH BABY");
            optionState();
        } else {
            //TODO
        }
    }

    /**
     * Paints the main state
     */
    private void mainState() {
        Image image = null;
        try {
            image = ImageIO.read(new File("/Users/Skifoobie/IdeaProjects/HoldEmOdds/res/oddCalculatorLogo.png"));
        } catch (IOException e) {
            System.out.println("help please");
            e.printStackTrace();
        }
        ImageIcon img = new ImageIcon(image);
        JLabel titleImg = new JLabel(img);
        JButton calculator = new JButton("Calculator");
        JButton options = new JButton("Options");

        // Add mouse listeners to buttons
        calculator.addMouseListener((new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                changeState(STATE.CALC);
            }
        }));
        options.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                changeState(STATE.OPTIONS);
            }
        });

        // Set the alignment to the center of the screen
        titleImg.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculator.setAlignmentX(Component.CENTER_ALIGNMENT);
        options.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add labels/buttons to panel
        add(titleImg);
        add(calculator);
        add(options);
    }

    /**
     * Paints the options state
     */
    private void optionState() {
        // TODO Buttons may or may not be changed
        JButton colorChange = new JButton("Change Color");
        JButton changeCard = new JButton("Change Cards");
        JButton mainMenu = new JButton("Return to Main Menu");
        add(colorChange);
        add(changeCard);
        add(mainMenu);
    }

    private static void addButton(String text, Container container) {
        // TODO maybe??? probably not actually
    }

}
