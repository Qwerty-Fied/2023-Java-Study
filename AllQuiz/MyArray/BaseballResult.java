package Ballgame.MyArray;

public class BaseballResult {//회차별 입력 수 , 회차, 판정결과
    public int count;
    public int[][] strikeBall = new int[count][2];
    public int[][] myResult = new int[count][3];

    public BaseballResult(int count, int[][] myResult, int[][] strikeBall) {
        this.count = count;
        this.myResult = myResult;
        this.strikeBall = strikeBall;
    }

    public void getStrikeball(int count) {
        System.out.println(count+1 + "회차 입력값: " + myResult[count][0] + myResult[count][1] + myResult[count][2]);
    }

   /* 스트링 타입으로 받아온거 한번에 넣는거 하나
            부분적으로 가져오는거 하나씩 만들어 줌 */
}
