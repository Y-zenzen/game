package jp.co.navitime.Shooting1;

public class Main {

    public static void main(String[] args) {

        // 1ゲーム目
        Game game = new Game();
        game.run();
       // int score = game.getScoreOfThisGame();

        Board board = new Board();
        board.printBoard();

        Airplane airplane = new Airplane(15, 25);

        Move move = new Move(board.printBoard());

    }
}
