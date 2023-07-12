package Ballgame.MyArray;

public class PrintResults {
    /* 어레이 리스트에서 가져올 값 있으면 출력만 해주는거 */
    public void totalResults (int count, SavaData sv) {
        for(int i=0; i<count; i++) {
            System.out.println("==========================");
            System.out.println(i+1 + "회차 입력값: " + sv.myResult[i][0] + sv.myResult[i][1] + sv.myResult[i][2]);
            System.out.println(i+1 + "회차 판정: " + sv.strikeBall[i][0] + " 스트라이크 " + sv.strikeBall[i][1]);
        }
    }

}
