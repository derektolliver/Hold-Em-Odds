package com.odds.src.main;

import java.awt.*;

public class Menu {

    private boolean on;

    public void render(Graphics g) {
        Font f1 = new Font("arial", Font.BOLD, 50);
        g.setFont(f1);
        g.setColor(Color.WHITE);
        g.drawString("POKER ODDS", UserInterface.WIDTH /4, 100);
    }

}
