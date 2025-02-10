package engine;

import objects.Ball;
import objects.Board;

public class Engine {
    Engine() {
        Ball ball = new Ball(1, 1);
        Board board = new Board(2, 1);
        Map map = new Map(5,6);

        map.insert_ball(ball);
        map.insert_board(board);





    }
}
