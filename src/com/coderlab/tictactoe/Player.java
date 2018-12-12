package com.coderlab.tictactoe;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import java.awt.*;

public class Player {

    private String name;
    private String symbol;

    public static final Font font = new Font("Time New Roman", Font.BOLD, 50);

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void draw(int caseX, int caseY, Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.setFont(new TrueTypeFont(font, true));
        graphics.drawString(symbol, caseX * 200, caseY * 200);
    }
}
