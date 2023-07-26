package quiz.Allquiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Qwer {
    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();   //선언및 대입

        int n = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Count : ");
        n = sc.nextInt();

        String name = "";
        ArrayList<Integer> score = null;
        int total = 0;
        int kor = 0;
        int eng = 0;
        int math = 0;
        double avg = 0.0;

        for (int i = 0; i < n; i++) {
            total = 0;
            HashMap<String, Object> personMap = new HashMap<String, Object>();
            System.out.print("Name : ");
            name = sc.next();
            personMap.put("name", name);

            score = new ArrayList<Integer>();
            System.out.print("국어점수 : ");
            kor = sc.nextInt();
            score.add(kor);
            total += kor;
            System.out.print("영어점수 : ");
            eng = sc.nextInt();
            score.add(eng);
            total += eng;
            System.out.print("수학점수 : ");
            math = sc.nextInt();
            score.add(math);
            total += math;
            score.add(total);
            personMap.put("score", score);

            avg = total / 3.0f;
            personMap.put("avg", avg);

            list.add(personMap);
        }

        int[] array = new int[n];
        String[] array2 = new String[n];
        for (int i = 0; i < n; i++) {
            HashMap<String, Object> personMap = list.get(i);
            ArrayList<Integer> scores = (ArrayList<Integer>) personMap.get("score");
            array[i] = scores.get(3);
            array2[i] = (String) personMap.get("name");
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];  //임시저장 변수 선언
                    array[i] = array[j];
                    array[j] = tmp;
                    String nameTmp = array2[i];
                    array2[i] = array2[j];
                    array2[j] = nameTmp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + ". " + array2[i] + " 학생의 점수" + array[i]);
        }

    }
}