package quiz.imade;

import java.util.Scanner;

public class quizquiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 10) + 1;
        int life = 5 ;
        for(int i=1; i<=life; i++) {
            System.out.print("숫자를 입력하세요(1~10)> ");

            String input = sc.nextLine();
            int numinput = Integer.parseInt(input);
            if(randomNum == numinput) {
                System.out.println(i + "번 만에 맞췄습니다. 축하합니다!");
                break;
            } else if (randomNum > numinput) {
                System.out.println("UP");
            } else if (randomNum < numinput) {
                System.out.println("DOWN");
            }
        }
        System.out.println("정답은 " + randomNum + "였습니다. ");
    }
}
