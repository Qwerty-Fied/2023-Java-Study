package Ballgame.TeachGame;

import java.util.ArrayList;

/**
 * 게임의 결과를 출력하는 클래스
 */
public class PrintResult {

    public void print(BaseballGame totalResult) {
        System.out.println("\n결과 : " + (totalResult.clearORfail ? "성공" : "실패"));

        System.out.println("입력한 모든 값 ------------------------------ ");


        for (CaseInfo obj : totalResult.caseList) {
            Integer[] user_input = obj.getUser_input();
            System.out.println("" + obj.getCaseNo() + "회차 입력 값 : " + user_input[0] + " , " + user_input[1] + " , " + user_input[2]);
        }
        System.out.println("\n전체 결과 보기 ------------------------------ ");

        for (CaseInfo obj : totalResult.caseList) {
            System.out.println(obj.getResultText());
        }
        System.out.println("------------------------------------------- ");
    }
}
