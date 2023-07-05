package Ballgame.ArrayVer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;

public class BaseballUtil {
    Scanner sc = new Scanner(System.in);
    private int strike;
    private int ball;

    public void ranNum(BaseballArray xranNum) {//랜덤 넘버 형성문
        xranNum.ranNum = new int[10];
        for (int i = 1; i <= 3; i++) {
            int ran = (int) (Math.random() * 10);
            if (ran != 0 && xranNum.ranNum[ran] == 0) {   // 인덱스 0을 막아둠, 중복 검사
                xranNum.ranNum[ran] = i;
            } else {
                i--;
            }
        }
    }

    public void inputNum(int count, BaseballArray xinputNum) {
        xinputNum.inputNum = new int[10];
        System.out.println(">> 0~9 숫자를 하나씩 입력해 주세요.");
        for (int i=0; i < 3; i++) {    // 123 나옴
            int inPut = sc.nextInt();
            if (xinputNum.inputNum[inPut] == 0) { //중복 검사
                xinputNum.inputNum[inPut] = i+1;
                xinputNum.myResult[count][i] = inPut;
            } else if (xinputNum.inputNum[inPut] != 0) {
                System.out.println("중복된 값이 있거나 잘못된 값입니다. 다시 입력해 주세요");
                i--;
            }
        }
    }

    public void checkNum(int count, BaseballArray xcheck) { //한번 실행
        strike = 0;   //스트라이크 값 초기화
        ball = 0;     //볼 값 초기화
        for (int i = 1; i < 10; i++) {
            if (xcheck.ranNum[i] != 0 && xcheck.inputNum[i] != 0) {
                if (xcheck.ranNum[i] == xcheck.inputNum[i]) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        System.out.println(strike + " 스트라이크 " + ball + " 볼");
        xcheck.strikeBall[count][0] = strike;
        xcheck.strikeBall[count][1] = ball;
    }

    public void reGame(BaseballArray game) {
        int yORn = sc.nextInt();
        if(yORn == 1 || yORn == 2) {
            if(yORn == 2) {
                System.out.println("게임을 종료합니다.");
                game.game = false;
            } else {
                System.out.println("게임을 한번 더 진행합니다.");
                for(int i = 0; i<3; i++) { //myResult 배열 초기화
                    for(int j=0; j<3; j++) {
                        game.myResult[i][j] = 0;
                    }
                }
                for(int i = 0; i<3; i++) { //strikeball 배열 초기화
                    for(int j=0; j<2; j++) {
                        game.strikeBall[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("올바른 숫자를 입력해주세요. ");
            reGame(game);
        }
    }
}
