package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryCapitalQuiz {
    public static void main(String[] args) {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("한국", "서울");
        countryCapitalMap.put("미국", "워싱턴 D.C.");
        countryCapitalMap.put("일본", "도쿄");
        countryCapitalMap.put("중국", "베이징");
        countryCapitalMap.put("영국", "런던");

        Scanner scanner = new Scanner(System.in);

        System.out.println("나라 이름을 입력하세요:");
        String country = scanner.nextLine();

        if (countryCapitalMap.containsKey(country)) {
            String capital = countryCapitalMap.get(country);
            System.out.println(country + "의 수도는 " + capital + "입니다.");
        } else {
            System.out.println("해당 나라의 수도 정보를 찾을 수 없습니다.");
        }

        scanner.close();
    }
}
