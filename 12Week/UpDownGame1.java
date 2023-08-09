package quiz;

import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;

public class UpDownGame1 {

    public static void main(String[] args) {
        // JSON 파일에서 데이터 읽기
        try (FileReader fileReader = new FileReader("C:/Temp/score.txt")) {
            StringBuilder content = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                content.append((char) character);
            }

            // JSON 문자열을 JSONObject로 변환하여 데이터 읽기
            JSONObject json = new JSONObject(content.toString());

            int randomNumber = json.getInt("randomNumber");
            int userNumber = json.getInt("userNumber");
            String result = json.getString("result");

            System.out.println("랜덤 숫자: " + randomNumber);
            System.out.println("입력 숫자: " + userNumber);
            System.out.println("결과: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}