package Ballgame.TeachGame;

import java.util.ArrayList;

/**
 * 게임의 결과를 출력하는 클래스
 */
public class PrintResult {

    public void print(int count, ArrayList<CaseInfo> caseList, Game gm) {
        //이쪽으로 넘어올 것. 1.이번게임이 몇번째 게임인지 2.

        System.out.println("\n\n입력한 모든 값 ------------------------------ ");


        for (CaseInfo obj : caseList) {
            Integer[] user_input = obj.getUser_input();
             System.out.println("" + obj.getCaseNo() + "회차 입력 값 : " +  user_input[0] + " , " + user_input[1] + " , " + user_input[2]);
             gm.totalResult.add(count + "번째 게임 " + obj.getCaseNo() + "회차 입력 값 : " +  user_input[0] + " , " + user_input[1] + " , " + user_input[2]); //메인 리절트에 입력
             gm.totalResult.add(count+ "번째 게임 " + obj.getResultText()); //메인 리절트에 판정 값 입력
        }
        System.out.println("\n전체 결과 보기 ------------------------------ ");

        for (CaseInfo obj : caseList) {
            System.out.println(obj.getResultText());
        }
        System.out.println("---------------------------------------- ");
    }

    public void totalPrint(Game gm) {
        for(String get : gm.totalResult) {
            System.out.println(get);
        }
    }
}
