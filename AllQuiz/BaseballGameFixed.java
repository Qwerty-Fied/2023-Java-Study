package Ballgame;

import java.util.Scanner;
public class BaseballGameFixed {
    private int count;
    int tryNum;      // 시도 횟수
    int[][] ary, strikeBall;    //1차 배열은 회차, 2차 배열은 입력값으로 사용
    int[] ranNum = new int[10];    //랜덤 숫자는 한번만 사용되므로 1번만 정의함
    int[] inPutNum; // 랜덤넘버 형성 배열

    public BaseballGameFixed(int count) {
        this.count = count;
        strikeBall = new int[count][2];
        ary = new int[count][3];   //1,2,3 입력값
        tryNum = 0;
    }

    public void genNumber() {   //랜덤 넘버 형성문
        for (int i = 1; i <= 3; i++) {
            int ran = (int) (Math.random() * 10);
            if (ran != 0 && ranNum[ran] == 0) {   // 인덱스 0을 막아둠, 중복 검사
                ranNum[ran] = i;
            } else {
                i--;
            }
        }
    }

    public void inputUserNumber() {
        System.out.println(">> 1~9 숫자를 하나씩 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        inPutNum = new int[10];        // 실행할 때 마다 배열 초기화 = 다시 입력받기 위함
        for (int i = 1; i <= 3; i++) {    // 123 나옴
            int inPut = sc.nextInt();
            if (inPut != 0 && inPutNum[inPut] == 0) { //0을 막아둠, 중복 검사
                inPutNum[inPut] = i;
                ary[tryNum][i - 1] = inPut;   //올바르게 입력시 입력값 저장
            } else {
                System.out.println("중복된 값이 있거나 잘못된 값입니다. 다시 입력해 주세요");
                i--;
            }
        }
    }

    public void checkNumber() {
            int strike = 0;   //스트라이크 값 초기화
            int ball = 0;     //볼 값 초기화
            for (int i = 1; i < 10; i++) {
                if (ranNum[i] != 0 && inPutNum[i] != 0) {
                    if (ranNum[i] == inPutNum[i]) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
            strikeBall[tryNum][0] = strike;    //스트라이크 판정 결과 저장
            strikeBall[tryNum][1] = ball;      //볼 판정 결과 저장
            tryNum++;
            if (strike == 3) {
                System.out.println(tryNum + "회차 판정 " + strike + " 스트라이크, " + ball + " 볼");
                System.out.println("게임 클리어");
            } else if (tryNum != count) {
                System.out.println(tryNum + "회차 판정 " + strike + " 스트라이크, " + ball + " 볼");
                inputUserNumber();
                checkNumber();
            } else {    //마지막 회차 판정 출력문
                System.out.println(tryNum + "회차 판정 " + strike + " 스트라이크, " + ball + " 볼");
            }
    }

    public void printResult() {
        System.out.println("입력한 모든 값 --------------------------");
        for(int i=0; i<(tryNum); i++) {
            System.out.println(i+1 + "회차 입력 값 : " + ary[i][0] + " , " + ary[i][1] + " , " + ary[i][2]);
        }
        System.out.println("전체 결과 보기 --------------------------");
        for(int i=0; i<(tryNum); i++) {
            System.out.println(i+1 + "회차 판정 -- " + strikeBall[i][0] + " 스트라이크, " + strikeBall[i][1] + " 볼");
        }
    }
}
