package jp.co.navitime.Shooting1;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.LogManager;

public class Game {
    private int scoreOfThisGame = 0;

    public Game() {
    }

    /**
     * 1ゲームの開始
     */
    public void run() {

        Board board = new Board();
        PlayScreen playScreen = new PlayScreen();

        // Airplane配置
        Airplane airplane = new Airplane(15, 25);        // XXX:(1,1):意味無し, TODO:Pointクラスの修正
        board.writeBoard(airplane, new Point(15,25));

        // コントローラー配置
        Move move = new Move(board, airplane);

        LogManager.getLogManager().reset();
        // 標準入力をフックしてなかったらフック
        if (!GlobalScreen.isNativeHookRegistered()) {
            try {
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        GlobalScreen.addNativeKeyListener(move);

        // 描画
     //   playScreen.display(board.createDisplayStrings());
        board.printBoard();



        // 一時停止
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // コントローラー削除
        GlobalScreen.removeNativeKeyListener(move);
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        // 獲得した点数(=獲得した Cookie の数)を入れる
        scoreOfThisGame = airplane.getScore();
    }

    public int getScoreOfThisGame(){
        return scoreOfThisGame;
    }
}
