package quiz;

import java.util.ArrayList;
import java.util.HashMap;

    public class HashMap1 {
        public static void main(String[] args) {
            ArrayList<HashMap<String,String>> list = new ArrayList<>();
            HashMap<String,String> personMap1 = new HashMap<>();

            personMap1.put("이름","박준수");
            personMap1.put("나이","23");
            personMap1.put("직업","학생");
            HashMap<String ,String> personMap2 = new HashMap<>();
            personMap2.put("이름","장대현");
            personMap2.put("나이","23");
            personMap2.put("직업","학생");

            list.add(personMap1);//Map을 list 에 담기
            list.add(personMap2);// Map을 list 에 담기

            for(HashMap<String, String> getHash : list) {
                System.out.println(getHash.toString());
            }
        }
    }


