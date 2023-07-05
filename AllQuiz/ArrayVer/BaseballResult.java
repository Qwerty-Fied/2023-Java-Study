package Ballgame.ArrayVer;

public class BaseballResult {//회차별 입력 수 , 회차, 판정결과
    public int count;
    public int[][] myResult;
    public int[][] result;


    public BaseballResult(int count, int[][] myResult, int[][] result) {
        this.count = count;
        this.myResult = myResult;
        this.result = result;
    }
}
