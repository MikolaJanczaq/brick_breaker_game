package game;

import engine.Engine;

public class Game {
    private Engine engine;

    Game() {
        engine = new Engine();
    }

    public void start(){
        while(!engine.getGameOver()) {
            engine.Analysis();
            drawMap();
        }
    }

    private void drawMap() {
        //function to draw state of the game in the console
    }
}
