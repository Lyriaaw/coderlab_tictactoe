package com.coderlab.tictactoe;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String[] args) {

        try {
            AppGameContainer apg = new AppGameContainer(new Game());
            apg.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
            apg.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
