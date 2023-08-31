package quiz.someMade;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 필터링하여 총합 계산
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0) // (1) 짝수만 필터링
                .mapToInt(Integer::intValue) // (2) Integer를 int로 변환
                .sum();// (3) 합계 계산

        System.out.println("짝수의 합: " + sum);
    }
}