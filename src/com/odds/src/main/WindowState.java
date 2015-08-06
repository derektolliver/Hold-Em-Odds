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
     * Adds the specific parts of a panel
     */
    public void addComponents() {
        // TODO figure out if there is a problem with this being called twice?
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

            }
        }));
        options.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // TODO Change in CardLayout
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
