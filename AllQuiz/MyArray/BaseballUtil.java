package Ballgame.MyArray;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import static java.lang.System.exit;
import static java.lang.System.in;

public class BaseballUtil {
    Scanner sc = new Scanner(System.in);
    private int strike;
    private int ball;

    public void ranNum(SavaData sv) {//랜덤 넘버 형성문
        sv.ranNum= new int[10];
        for (int i = 1; i <= 3; i++) {
            int ran = (int) (Math.random() * 10);
            if (ran != 0 && sv.ranNum[ran] == 0) {   // 인덱스 0을 막아둠, 중복 검사
                sv.ranNum[ran] = i;
            } else {
                i--;
            }
        }
    }

    public void inputNum(int count, SavaData sv) {
        sv.inputNum = new int[10];
        System.out.println(">> 0~9 숫자를 하나씩 입력해 주세요.");
        for (int i=0; i < 3; i++) {    // 123 나옴
            int inPut = sc.nextInt();
            if (sv.inputNum[inPut] == 0) { //중복 검사
                sv.inputNum[inPut] = i+1;
                sv.myResult[count][i] = inPut;
            } else if (sv.inputNum[inPut] != 0) {
                System.out.println("중복된 값이 있거나 잘못된 값입니다. 다시 입력해 주세요");
                i--;
            }
        }
    }

    public int checkNum(int count, SavaData sv) { //한번 실행
        strike = 0;   //스트라이크 값 초기화
        ball = 0;     //볼 값 초기화
        for (int i = 1; i < 10; i++) {
            if (sv.ranNum[i] != 0 && sv.inputNum[i] != 0) {
                if (sv.ranNum[i] == sv.inputNum[i]) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        System.out.println(strike + " 스트라이크 " + ball + " 볼");
        sv.strikeBall[count][0] = strike;
        sv.strikeBall[count][1] = ball;
        return strike;
    }


    public void save(int count, SavaData sv) {
        List<BaseballResult> list = new ArrayList<>();
        list.add(new BaseballResult(count, sv.strikeBall, sv.myResult));

      /*  다 가져와서 어레이 리스트에 넣는 문장*/

    }
}
