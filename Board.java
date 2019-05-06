package jp.co.navitime.Shooting1;

import java.util.HashMap;
import java.util.Map;

public class Board {

    // 各オブジェクトの数
    private Map<String, Integer> num = new HashMap<String, Integer>();
    private GameObjects[][] Board = new GameObjects[51][91];

    public void printBoard() {

        String[][] Board = new String[31][51];
        int x = 15;
        int y = 25;

        for(int i = 1; i < 10; i++) {
            for(int j = 1; j <= 50; j++) {
                Board[i][j] = "+ ";
                System.out.printf(Board[i][j]);
            }
                System.out.printf("\n");
        }

        for(int i = 10; i <= 30; i++) {
            for(int j = 1; j <= 50; j++) {
                Board[i][j] = "+ ";

                if(i == x && j == y) {
                    Board[x][y] = "✈️";  //初期位置
                }
                System.out.printf(Board[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public GameObjects get(int row, int col) {
        return Board[row][col];
    }

    public void writeBoard(MovingObjects now, Point after) {

        System.out.println(Board[after.getRow()][after.getCol()]);
        // Nothing オブジェクトなら
        if (Board[after.getRow()][after.getCol()] instanceof Nothing) {

            // 移動元 書き換え
            Board[now.getRow()][now.getCol()] = new Nothing();
            // 移動先 書き換え
            Board[after.getRow()][after.getCol()] = (GameObjects) now;

            // MovingObject の座標更新
            now.setRow(after.getRow());
            now.setCol(after.getCol());

            return;
        } else
            System.out.println("aaa");


        System.out.println(Board[after.getRow()][after.getCol()]);
        // + なら
        if (Board[after.getRow()][after.getCol()] instanceof Target) {

            // 移動元 書き換え
            Board[now.getRow()][now.getCol()] = new Nothing();
            // 移動先 書き換え
            Board[after.getRow()][after.getCol()] = new Airplane(after.getRow(), after.getCol());

            // MovingObject の座標更新
            now.setRow(after.getRow());
            now.setCol(after.getCol());

            // ターゲットの数を減らす
            num.put("+ ", num.get("+ ") - 1);

            // 得点付与
            now.addScore();

            return;
        } else
        System.out.println("bbb");
    }
}
