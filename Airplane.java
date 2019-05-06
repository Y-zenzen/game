package jp.co.navitime.Shooting1;

public class Airplane extends Point implements GameObjects, MovingObjects {

    private static final boolean flag = true;
    private int score = 0;

    public Airplane(int row, int col) {
        super(row, col);
    }

    public boolean isGo() {
        return flag;
    }

    @Override
    public void setRow(int row) {

    }

    @Override
    public void setCol(int col) {

    }

    public void addScore(){
        score++;
    }

    public int getScore(){
        return score;
    }
}

