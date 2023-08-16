package Ballgame.TeachGame;

import java.util.Arrays;

/**
 * 임의의 수를 만드는 클래스
 */
public class MakeNumber {

    public Integer[] makeNumber() {
        int value = 0;
        Integer[] rand_num = new Integer[3];
        // 랜덤 수 만들기
        for (int i = 0; i < 3; i++) {
            value = (int) Math.floor(Math.random() * 10); // 0~9

            // 중복 처리
            if (Arrays.asList(rand_num).indexOf(value) == -1 && value > 0) {
                rand_num[i] = value;
                System.out.println(rand_num[i]);
            } else {
                i--;
            }
        }

        return rand_num;
    }
}
