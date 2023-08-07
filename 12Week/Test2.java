package quiz.imade.test1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;


public class Test2 {
    public static void main(String[] args) {
        System.out.println("총점 270점 넘으면 아이스크림 사줌");
        try {
            FileReader fileReader = new FileReader("sungjuk.txt");
            StringBuilder eachPerson = new StringBuilder();
            int score;
            while (true) {
                score = fileReader.read();
                if(score == -1) break;
                eachPerson.append((char) score);
            }


            JSONArray jsonArray = new JSONArray(eachPerson.toString());//어레이 불러오기
            HashMap<String, Integer> whoIstheBest = new HashMap<>();

            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject map = (JSONObject) jsonArray.get(i);
                int total = (int) map.get("total");
                if(total >= 270) {
                    String name = map.get("name").toString();
                    whoIstheBest.put(name, total);
                }
            }
            System.out.println();
            whoIstheBest.forEach((k,v) -> System.out.println(String.format("아이스크림을 먹는 사람은 총합 " + v + " 점의 " + k)));


            for(int i=0; i<jsonArray.length(); i++) {
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
