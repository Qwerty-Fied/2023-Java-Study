package Ballgame.find;

public class PrintResultClass {
    public void printResult(int count, int[][] inputArray, int[][] rs) {
        System.out.println("입력한 모든 값 --------------------------");
        for(int i=0; i<(count); i++) {
            System.out.println(i+1 + "회차 입력 값 : " + inputArray[i][0] + " , " + inputArray[i][1] + " , " + inputArray[i][2]);
        }
        System.out.println("전체 결과 보기 --------------------------");
        for(int i=0; i<(count); i++) {
            System.out.println(i + 1 + "회차 판정 -- " + rs[i][0] + " 스트라이크, " + rs[i][1] + " 볼");
        }
    }
}
