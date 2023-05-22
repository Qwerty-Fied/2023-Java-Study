package quiz;

import java.util.Scanner;

public class baseBallGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] randomArray = new int[10];  //인덱스 번호 0~9 배열 선언
        int count = 1;
        while (true) {
            int randomNum = (int) ((Math.random() * 10));
            if (count == 4) {
                break;
            } else if (randomArray[randomNum] == 0) {
                randomArray[randomNum] = count;
                count++;
            }
        }
        int answer = 0;
        for(int i=0; i<=9; i++) {      //정답인 3자리수 만들기
            if(randomArray[i] == 1) {  //입력값 1 == 100의자리수
                answer += i*100;
                if(i==0) {             //인덱스 0의 입력값이 1일 경우 100더해줌
                    answer += 100;
                }
            } else if(randomArray[i] == 2) { //입력값 2 == 10의 자리수
                answer += i*100;
                if(i==0) {
                    answer += 10;       //인덱스 0의 입력값이 1일 경우 100더해줌
                }
            } else if(randomArray[i] == 3) { //입력값 1 == 1의 자리수
                answer += i;
            }
        }
        int life = 10;
        while (true) {
            if (life == 0) {  // 기회가 남아있으면 돌아감
                System.out.println("기회가 모두 소진되었습니다. 정답은 " + answer + "였습니다.");
                break;
            } else {
                System.out.print("숫자를 입력하세요: ");
                String scInput = sc.nextLine();   //맞출 숫자 입력
                int[] inputArray = new int[10];
                for (int i = 0; i < 3; i++) {
                    int num = Integer.parseInt(scInput.substring(i, i + 1));
                    inputArray[num] = i + 1;     //인덱스 값에따라 자리수로 저장
                }
                int strike = 0;  //스트라이크, 볼 선언 = 할때마다 0으로 초기화
                int ball = 0;
                for (int i = 0; i < 10; i++) {
                    if (randomArray[i] != 0 && inputArray[i] != 0) {    //입력값의 스트라이크 볼유무 판정
                        if (randomArray[i] == inputArray[i]) {
                            strike++;   //자리수 까지 맞으면 스트라이크
                        } else {
                            ball++;     //0이 아니면 = 있긴 하면 볼
                        }
                    }
                }
                if (strike == 3) {   //숫자를 맞추면 남은 횟수와 상관없이 빠져나옴
                    System.out.println("정답입니다!");
                    break;
                } else {
                    System.out.println(strike + " 스트라이크 " + ball + " 볼");
                    life--;
                }
            }
        }
    }
}
