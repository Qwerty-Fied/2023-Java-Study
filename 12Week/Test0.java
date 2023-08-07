package quiz.imade.test1;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test0 {

    public static void main(String[] args) throws IOException {

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
        for (int i = 0; i < n; i++) {
            HashMap<String, Object> personMap = list.get(i);

            System.out.println("name : " + personMap.get("name"));

            ArrayList<Integer> scores = (ArrayList<Integer>) personMap.get("score");

            // 해시맵에서 get(input)=입력한 과목의 값의 점수(get score)를 가져와 Arraylist의 0번째 값과 i번째 값을 비교해, i번째 값이 크다면 min에 i를 넣음
            System.out.println("국어 : " + scores.get(0));
            System.out.println("영어 : " + scores.get(1));
            System.out.println("수학 : " + scores.get(2));
            System.out.println("total : " + scores.get(3));
            System.out.println("average : " + personMap.get("avg"));


        }
        saveSungjuk(list, "sungjuk.txt");

    }
    public static void saveSungjuk(ArrayList<HashMap<String,Object>> list, String fileName){
        if(list.isEmpty()){
            System.out.println("데이터가 없습니다.");
            return;
        }

        PrintWriter logFile = null;
        try {
            logFile = new PrintWriter(new FileWriter(fileName, false));

            JSONArray logAllJson = new JSONArray();
            for(HashMap<String,Object> personMap : list){
                JSONObject jObj = new JSONObject();
                jObj.put ("name" , personMap.get("name"));

                ArrayList<Integer> scores = (ArrayList<Integer>)personMap.get("score");
                jObj.put ("국어" , scores.get(0));
                jObj.put ("영어" , scores.get(1));
                jObj.put ("수학" , scores.get(2));
                jObj.put ("total" , scores.get(3));
                jObj.put ("average" , personMap.get("avg"));

                logAllJson.put(jObj);
            }

            logFile.println(logAllJson.toString());

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        if(logFile != null){
            logFile.close();
        }
    }

}