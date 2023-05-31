package Ballgame;

import java.util.Scanner;

public class BaseballGame {
    private int count;
    int[][] ary;    //1차 배열은 회차, 2차 배열은 입력값으로 사용

    int[][] strikeBall; //1,2,3 게임 값    // 1차 배열은 회차, 2차 배열은 스트라이크, 볼 판정으로 사용
    int success;

    public BaseballGame(int count) {
        this.count = count;
        strikeBall = new int[count][2];
        ary = new int[count][3];   //1,2,3 입력값
        success = 0;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int[] ranNum = new int[10];
        for (int i = 1; i <= 3; i++) {
            int ran = (int) (Math.random() * 10);
            if (ran != 0 && ranNum[ran] == 0) {
                ranNum[ran] = i;
            } else {
                i--;
            }
        }


        for (int j = 0; j < count; j++) {
            System.out.println(">> 1~9 숫자를 하나씩 입력해 주세요.");
            int[] inPutNum = new int[10];
            for (int i = 1; i <= 3; i++) {
                int inPut = sc.nextInt();
                if (inPut != 0 && inPutNum[inPut] == 0) {
                    inPutNum[inPut] = i;
                    ary[j][i-1] = inPut;
                } else {
                    System.out.println("중복된 값이 있거나 잘못된 값입니다. 다시 입력해 주세요");
                    i--;
                }
            }
            int strike = 0;
            int ball = 0;
            for (int i = 1; i < 10; i++) {
                if (ranNum[i] != 0 && inPutNum[i] != 0) {
                    if (ranNum[i] == inPutNum[i]) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
            this.strikeBall[j][0] = strike;
            this.strikeBall[j][1] = ball;
            success = j+1;

            if (strike == 3) {
                System.out.println( success + "회차 판정 " + strike + " 스트라이크, " + ball + " 볼");
                System.out.println("게임 클리어");
                break;
            } else {
                System.out.println( success + "회차 판정 " + strike + " 스트라이크, " + ball + " 볼");
            }
        }
    }
    public void printResult() {
        System.out.println("입력한 모든 값 --------------------------");
        for(int i=0; i<success; i++) {
            System.out.println(i+1 + "회차 입력 값 : " + ary[i][0] + " , " + ary[i][1] + " , " + ary[i][2]);
        }
        System.out.println("전체 결과 보기 --------------------------");
        for(int i=0; i<success; i++) {
            System.out.println(i+1 + "회차 판정 -- " + strikeBall[i][0] + " 스트라이크, " + strikeBall[i][1] + " 볼");
        }
    }
}