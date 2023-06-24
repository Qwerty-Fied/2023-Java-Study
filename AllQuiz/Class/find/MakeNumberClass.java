package Ballgame.find;

public class MakeNumberClass {

    public int[] genNumber() {   //랜덤 넘버 형성문
        int[] ranNum = new int[10];
        for (int i = 1; i <= 3; i++) {
            int ran = (int) (Math.random() * 10);
            if (ran != 0 && ranNum[ran] == 0) {   // 인덱스 0을 막아둠, 중복 검사
                ranNum[ran] = i;
            } else {
                i--;
            }
        }
        return ranNum;
    }
}
