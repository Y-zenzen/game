package jp.co.navitime.Shooting1;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.util.logging.LogManager;

//nativeHookを使用したコード

    public class Move implements NativeKeyListener {

        private Board board;
        private Airplane airplane;

        public Move(Board board, Airplane airplane){
            this.board = board;
            this.airplane = airplane;
        }

        //キー入力処理
        public void nativeKeyPressed(NativeKeyEvent e) {

            String input = NativeKeyEvent.getKeyText(e.getKeyCode());
            // System.out.println(input); //後で消す

            if(input == "左") {
                System.out.println("ひだりに進む");
                System.out.println(e.paramString());
            }

            //左矢印キーを押した時
            if (e.getKeyCode() == 123) {
                System.out.println("左に動く");
                if (board.get(airplane.getRow(), airplane.getCol() - 1).isGo()) {
                    board.writeBoard(airplane, new Point(airplane.getRow(), airplane.getCol() - 1));
                    return;
                }
            }

            //右矢印キーを押した時
            if(e.getKeyCode() == 124) {
                System.out.println("右へ動く");
                if (board.get(airplane.getRow(), airplane.getCol() + 1).isGo()) {
                    board.writeBoard(airplane, new Point(airplane.getRow(), airplane.getCol() + 1));
                    return;
                }
            }

            //下矢印キーを押した時
            if(e.getKeyCode() == 125) {
                System.out.println("下へ動く");
                if (board.get(airplane.getRow() + 1, airplane.getCol()).isGo()) {
                    board.writeBoard(airplane, new Point(airplane.getRow() + 1, airplane.getCol()));
                    return;
                }
            }

            //上矢印キーを押した時
            if(e.getKeyCode() == 126) {
                System.out.println("上へ動く");
                if (board.get(airplane.getRow() - 1, airplane.getCol()).isGo()) {
                    board.writeBoard(airplane, new Point(airplane.getRow() - 1, airplane.getCol()));
                    return;
                }
            }
        }

        public void nativeKeyReleased(NativeKeyEvent e) {   //キー入力時に押していたキーを離すタイミングで押していたキーが出力される
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
        }
    }
