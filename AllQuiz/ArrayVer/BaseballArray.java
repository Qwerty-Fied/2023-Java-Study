package Ballgame.ArrayVer;

import java.util.ArrayList;
import java.util.List;

public class BaseballArray {
    public static final int COUNT = 3;
    public static int[][] strikeBall = new int[COUNT][2];
    public static int[][] myResult = new int[COUNT][3];
    public int[] inputNum; //메서드 실행시 초기화 됨.
    public int[] ranNum;
    public static boolean game = true;

    public static void main(String[] args) { //입력한 수, 회차, 판정결과
        while (game) {
            List<BaseballResult> list = new ArrayList<>();
            BaseballArray bResult = new BaseballArray(); //본인 필드 사용할 객체 생성
            BaseballUtil util = new BaseballUtil();

            util.ranNum(bResult); //랜덤넘버 넘어옴
            int tryNum = 0;
            for (int i = 0; i < COUNT; i++) {
                tryNum++;
                util.inputNum(i, bResult); //인풋넘버 넘어옴
                util.checkNum(i, bResult); //체크 결과값 넘어옴
                if (strikeBall[i][0] == 3) {
                    list.add(new BaseballResult(COUNT, myResult, strikeBall)); //리스트에 회차, 입력값, 결과 추가
                    break;
                }
                list.add(new BaseballResult(COUNT, myResult, strikeBall)); //리스트에 회차, 입력값, 결과 추가
            }
            for (int i = 0; i < tryNum; i++) {
                System.out.println(i + 1 + "회차 ");
                System.out.println("입력 : " + myResult[i][0] + myResult[i][1] + myResult[i][2]);
                System.out.println("판정결과 : " + strikeBall[i][0] + " 스트라이크 " + strikeBall[i][1] + " 볼 ");
            }
            System.out.println();
            System.out.println("====한번 더 하시겠습니까??====");
            System.out.println("1. 한번 더 한다 | 2. 그만둔다 ");
            System.out.println("===========================");
            util.reGame(bResult);
        }
    }
}