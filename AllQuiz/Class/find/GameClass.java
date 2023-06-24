package Ballgame.find;

import java.util.Scanner;

public class GameClass {
    public static final int GAMECOUNT = 3;
    public static void main(String[] args) {
        MakeNumberClass makeNumberClass = new MakeNumberClass();
        int[] mkNum = makeNumberClass.genNumber(); //넘어온 랜덤 넘버
        int count = 0;
        int[][] inputArray = new int[GAMECOUNT][10];//입력값 받을거
        int[][] rs = new int[GAMECOUNT][2];
        while (count < GAMECOUNT) {
            int[] input = new int[10]; //intputUserNumber로 값이 들어옴
            GameClass gameClass = new GameClass();
            gameClass.inputUserNumber(input);
            for(int i=0; i<10; i++) {
                inputArray[count][i] = input[i]; //입력값
            }
            int[] result = gameClass.checkNumber(mkNum, input); //결과값 저장 배열
            rs[count][0] = result[0]; //스트라이크
            rs[count][1] = result[1]; //볼
            if(result[0]==3) { //스트라이크 3개면
                break;
            }
            count++;
        }
        PrintResultClass printResultClass = new PrintResultClass();
        printResultClass.printResult(count, inputArray, rs);
    }

    //메인 프로세스
    //입력
    public void inputUserNumber(int[] inPutNum) {
        System.out.println(">> 1~9 숫자를 하나씩 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {    // 123 나옴
            int inPut = sc.nextInt();
            if (inPut != 0 && inPutNum[inPut] == 0) { //0을 막아둠, 중복 검사
                inPutNum[inPut] = i;
            } else {
                System.out.println("중복된 값이 있거나 잘못된 값입니다. 다시 입력해 주세요");
                i--;
            }
        }
    }

    //문제, 답 비교
    public int[] checkNumber(int[] ranNum, int[] inPutNum) {
        int[] sb = new int[2];
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
        sb[0] = strike;
        sb[1] = ball;
        System.out.println(strike + " 스트라이크 " + ball + " 볼");
        return sb;
    }
}
