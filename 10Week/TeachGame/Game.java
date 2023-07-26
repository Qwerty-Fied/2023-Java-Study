package Ballgame.TeachGame;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {
    ArrayList<String> totalResult = new ArrayList<>();
    public static void main(String[] args) {
        Game gm = new Game();
        int gameCount = 3;
        Scanner sc = new Scanner(System.in);
        int game = 1;
        int value = 1;

        //성적보기함수 들어갈 자리
        int i = 1; //회차 정리를 위한 변수 선언
        while (game == 1) {
            System.out.println("======숫자야구 게임을 시작합니다======");
            System.out.println("1.게임시작 || 2.게임성적보기 || 3.종료");
            System.out.println("==================================");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    game = 1;
                    break;
                case 2:
                    PrintResult pr = new PrintResult();
                    pr.totalPrint(gm);
                    break;
                case 3:
                    System.out.println("게임을 종료합니다.");
                    exit(0);
                    break;
            }
            while (value == 1) {
                System.out.println("\n\n>> " + i + "회차 게임을 시작합니다.");
                startGame(i, gameCount, gm);
                System.out.println(i + "회차 게임을 종료합니다. ");
                System.out.println(">> 게임을 계속하시겠습니까? 계속하려면 1을 입력하세요.");
                value = sc.nextInt();
                i++;
            }
        }
    }


    public static void startGame(int count, int gameCount, Game gm){

        BaseballGame myGame = new BaseballGame(gameCount);

        // 랜덤 수 만들기
        MakeNumber maker = new MakeNumber();
        Integer[] comNumber = maker.makeNumber();
        myGame.rand_num = comNumber;

        // 사용자 숫자 입력
        for(int cnt = 0; cnt < gameCount ; cnt++) {

            CaseInfo caseinfo = new CaseInfo(cnt+1);
            myGame.inputUserNumber(caseinfo);
            int strike_num = myGame.checkNumber();

            if (strike_num == 3) {
                System.out.println("\n === 게임 클리어");
                break;
            } else if (cnt == gameCount - 1) {
                System.out.println("\n === 게임 클리어 실패");

            }
        }
        PrintResult printer = new PrintResult();
        printer.print(count, myGame.caseList, gm);
    }
}
