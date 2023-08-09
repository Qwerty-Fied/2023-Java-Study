package quiz;

import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpDownGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JSONObject json = new JSONObject();

        System.out.println("1부터 5까지의 숫자 중 하나를 맞춰보세요.");
        int randomNumber = (int) (Math.random() * 5) + 1; // 1~5 사이의 난수 생성

        json.put("randomNumber", randomNumber);

        int life = 2;
        while (life != 0) {
            System.out.print("숫자를 입력하세요: ");
            int userNumber = scanner.nextInt();

            if (userNumber == randomNumber) {
                System.out.println("정답입니다.");
                json.put("result","정답입니다.");
                json.put("userNumber", userNumber);
                break;
            } else if (userNumber < randomNumber) {
                System.out.println("업!");
            } else {
                System.out.println("다운!");
            }

            life--;
            if (life > 0) {
                System.out.println("다시 시도하세요. 기회가 " + life + "번 남았습니다.");
            } else {
                System.out.println("실패입니다.");
                json.put("결과","실패입니다.");
                json.put("userNumber", userNumber);
            }
        }

        scanner.close();

        // JSON 데이터를 파일에 저장
        try (FileWriter file = new FileWriter("C:/Temp/score.txt")) {
            file.write(json.toString());
            System.out.println("JSON 데이터를 파일에 저장했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}