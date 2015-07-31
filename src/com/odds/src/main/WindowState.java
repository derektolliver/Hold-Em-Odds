package com.odds.src.main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WindowState extends JPanel {

    private STATE state;
    private JPanel currPane;

    public WindowState() {
        state = STATE.MENU;
        paintComponent(getGraphics());
    }

    public WindowState(STATE state) {
        this.state = state;
        paintComponent(getGraphics());
    }

    /**
     * Changes the state of the JPanel to alter display
     * @param state is the new state being sent to the panel
     */
    public void changeState(STATE state) {
        this.state = state;
//        removeAll();
//        repaint();
//        paintComponent(getGraphics());
    }

    /**
     * Creates new window based on changed state
     * @param g is the Graphics component used to create display
     * May or may not keep the switch statement instead of if
     */
    public void paintComponent(Graphics g) {
        // TODO figure out if there is a problem with this being called twice?
        //repaint();
//        if (state == STATE.MENU) {
//            System.out.println("buttons are being added");
//            mainState();
//        } else if (state == STATE.OPTIONS) {
//            System.out.println("OH YEAH BABY");
//            optionState();
//        } else {
//            //TODO
//        }
        //super.paintComponent(g); //TODO FIX THIS NOW
        switch (state) {
            case MENU:
                state = STATE.MENU;
                mainState();
                System.out.println("Menu state reached");
                break;
            case OPTIONS:
                state = STATE.OPTIONS;
                optionState();
                System.out.println("Options state reached");
                break;
            case CALC:
                state = STATE.CALC;
                calcState();
                System.out.println("Calc state reached");
                break;
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
        // Create each button for the option state
        JButton colorChange = new JButton("Change Color");
        JButton changeCard = new JButton("Change Cards");
        JButton mainMenu = new JButton("Return to Main Menu");

        // Set the alignment
        colorChange.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add labels/buttons to panel
        add(colorChange);
        add(changeCard);
        add(mainMenu);
    }

    private void calcState() {
        // TODO not sure what's going here yet
    }

    /**
     * Adds a list of buttons to the panel and aligns them. (May or may not be used)
     * @param buttonList list of buttons being added to panel
     */
    private void addButton(ArrayList<JButton> buttonList) {
        // Set alignment and add to panel
        for (JButton button : buttonList) {
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(button);
        }
    }

}
