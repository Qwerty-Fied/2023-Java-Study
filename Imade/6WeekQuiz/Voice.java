package quiz.imade.week7Quiz;

import java.util.Scanner;


/* 다음은 인터페이스를 이용한 볼륨이 0일경우 종료되는 프로그램입니다.
 Voiceinterface 파일에서 프로그램 종료 메시지가 출력되도록 코드를 변경해주세요.
 */
public class Voice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int volume;
        do {
        System.out.println("볼륨을 입력하세요 1~100");
        volume= sc.nextInt();
        } while (volume>100 && volume<1);
        VoiceInterface vi = new Music();
        vi.setVolume(volume);
    }
}

//힌트 = 볼륨이 0이면 PowerOff 메소드를 호출해야한다
