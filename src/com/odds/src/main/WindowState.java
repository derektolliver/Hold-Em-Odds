package com.odds.src.main;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
        if (state == STATE.MENU) {
            System.out.println("buttons are being added");
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
            add(titleImg);
            add(calculator);
            add(options);
        } else if (state == STATE.OPTIONS) {
            JButton colorChange = new JButton("Change Color");
            JButton changeCard = new JButton("Change Cards");
            JButton mainMenu = new JButton("Return to Main Menu");
            add(colorChange);
            add(changeCard);
            add(mainMenu);
        } else {
            //TODO
        }
    }

    private static void addButton(String text, Container container) {
        // TODO maybe??? probably not actually
    }

    private void painter() {

    }

}
