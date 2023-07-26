package quiz.Allquiz;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Count : ");
        int n = sc.nextInt();
        for (int i = 0; i<n; i++) {
            System.out.println("학생 이름 : ");
            String name = sc.next();
            List<Integer> scores = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                System.out.println(name + "의" + j + "점수");
                int score = sc.nextInt();
                scores.add(score);
            }
            scoresMap.put(name, scores);
        }
        String each = null;
        int max = 0;
        int total;
        for (String name : scoresMap.keySet()) {
            List<Integer> scores = scoresMap.get(name);
            total = scores.get(0)+scores.get(1)+scores.get(2);
            if(max < total) {  //max 값보다 가져온 토탈의 값이 크면 max에 토탈을 넣어줌 (반복)
                max = total;
                each = name;
            }
        }
        List<Integer> nc = scoresMap.get(each);
        System.out.println(nc);
        System.out.println("평균이 가장 높은 학생 이름 : " + each);
        System.out.println("첫 번쨰 점수 : " + nc.get(0));
        System.out.println("첫 번쨰 점수 : " + nc.get(1));
        System.out.println("첫 번쨰 점수 : " + nc.get(2));
        System.out.println("총점 : " + max);
        float avg = max/3.0f;
        System.out.println("평균 : " + avg);
    }
}