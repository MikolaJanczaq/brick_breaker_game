package game;

import engine.Engine;
import objects.Ball;
import objects.Board;
import objects.Brick;
import objects.Unit;
import java.util.Scanner;

public class Game {
    private Engine engine;

    public Game() {
        engine = new Engine();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (!engine.getGameOver()) {
            System.out.print("Input board direction (a = left, d = right, enter = don't move): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("a")) {
                engine.moveBoard(0);
            } else if (input.equalsIgnoreCase("d")) {
                engine.moveBoard(1);
            }
            engine.Analysis();

            drawMap();

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game Over!");
        scanner.close();
    }

    private void drawMap() {
        int width = engine.getMap().getWidth();
        int height = engine.getMap().getHeight();
        char[][] display = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                display[i][j] = ' ';
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Unit unit = engine.getMap().getUnitAt(x, y);
                if (unit != null) {
                    if (unit instanceof Brick) {
                        display[y][x] = '#';
                    } else if (unit instanceof Ball) {
                        display[y][x] = 'O';
                    }
                }
            }
        }

        Board board = engine.getBoard();
        int boardX = board.getPositionX();
        int boardY = board.getPositionY();
        for (int x = boardX; x < boardX + board.getWidth(); x++) {
            if (x >= 0 && x < width && boardY >= 0 && boardY < height) {
                display[boardY][x] = '=';
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(display[y][x]);
            }
            System.out.println();
        }
    }
}
