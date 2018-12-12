package com.coderlab.tictactoe;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame {

    static int WIDTH = 600;
    static int HEIGHT = 600;

    static int WINDOW_WIDTH = 600;
    static int WINDOW_HEIGHT = 800;

    List<Player> players;
    Player currentPlayer;
    int currentPlayerId;

    private int grid[][];


    public Game() {
        super("TicTacToe");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        players = new ArrayList<>();
        players.add(new Player("Lyriaaw", "X"));
        players.add(new Player("Diane", "O"));

        currentPlayer = players.get(0);
        currentPlayerId = 0;

        grid = new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            onMouseClick(input.getMouseX(), input.getMouseY());
    }

    private void onMouseClick(int x, int y) {
        System.out.println("Clicked on " + x + " " + y);

        int caseX = x / 200;
        int caseY = y / 200;
        if (caseX > 2 || caseY > 2 || grid[caseX][caseY] != -1)
            return;
        System.out.println("Clicked on case " + caseX + " " + caseY + " for player " + currentPlayerId);

        grid[caseX][caseY] = currentPlayerId;

        int winnerId = checkWinner();
        if (winnerId != -1) {
            System.out.println("Player " + players.get(winnerId).getName() + " won !!!!");
        }

        rotatePlayers();


    }

    public void rotatePlayers() {
        currentPlayerId++;
        if (currentPlayerId == players.size()) {
            currentPlayerId = 0;
        }

        System.out.println("It's " + players.get(currentPlayerId).getName() + "'s turn");
    }

    public int checkWinner() {


        for (int it = 0; it < 3; it++) {
            if (grid[it][0] == grid[it][1] && grid[it][1] == grid[it][2])
                return grid[it][0];

            if (grid[0][it] == grid[1][it] && grid[1][it] == grid[2][it])
                return grid[0][it];
        }

        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return grid[0][0];
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2])
            return grid[0][0];

        return  -1;
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        drawLines(graphics);
        drawPlayers(graphics);
    }

    private void drawLines(Graphics graphics) {
        graphics.drawLine(0, HEIGHT / 3.0f, WIDTH, HEIGHT / 3.0f);
        graphics.drawLine(0, 2 * HEIGHT / 3.0f, WIDTH, 2 * HEIGHT / 3.0f);
        graphics.drawLine(0, HEIGHT, WIDTH, HEIGHT);

        graphics.drawLine(WIDTH / 3.0f, 0, WIDTH / 3.0f, HEIGHT);
        graphics.drawLine(2 * WIDTH / 3.0f, 0, 2 * WIDTH / 3.0f, HEIGHT);
    }

    private void drawPlayers(Graphics graphics) {
        for (int it = 0; it < 3; it++) {
            for (int jt = 0; jt < 3; jt++) {

                if (grid[it][jt] == -1)
                    continue;

                players.get(grid[it][jt]).draw(it, jt, graphics);


            }
        }
    }
}
