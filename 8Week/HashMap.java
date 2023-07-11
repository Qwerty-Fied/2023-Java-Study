package quiz;

import java.util.*;
    public class HashMap {
        public static void main(String[] args) {
            ArrayList<java.util.HashMap<String,String>> list = new ArrayList<java.util.HashMap<String,String>>();
            java.util.HashMap<String,String> personMap1 = new java.util.HashMap<String,String>();

            personMap1.put("이름","박준수");
            personMap1.put("나이","23");
            personMap1.put("직업","학생");
            java.util.HashMap<String ,String> personMap2 = new java.util.HashMap<String,String>();
            personMap2.put("이름","장대현");
            personMap2.put("나이","23");
            personMap2.put("직업","학생");

            list.add(new java.util.HashMap<>(personMap1));//Map을 list 에 담기
            list.add(new java.util.HashMap<>(personMap2));// Map을 list 에 담기

            java.util.HashMap<String,String> takeMap1 = (java.util.HashMap<String, String>) list.get(0);  //첫번째 칸 리스트에 담기
            String name1 = takeMap1.get("이름");
            String age1 = takeMap1.get("나이");
            String job1 = takeMap1.get("직업");

            java.util.HashMap<String,String> takeMap2 = (java.util.HashMap<String, String>) list.get(1);  //두번째 칸 리스트에 담기
            String name2 = takeMap2.get("이름");
            String age2 = takeMap2.get("나이");
            String job2 = takeMap2.get("직업");

            System.out.println(takeMap1);
            System.out.println(takeMap2);
        }
    }


