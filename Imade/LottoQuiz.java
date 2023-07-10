package quiz.imade.Lotto;

import java.util.*;

public class LottoQuiz {
    public static void main(String[] ar) {
        Map<Character, Integer> map = new HashMap();    //<키 자료형, 값 자료형>
        Scanner sc = new Scanner(System.in);
        for (int i = 65; i < 91; i++) {
            int random = (int) (Math.random()*10);
            map.put((char)i, random);
        }
        System.out.println(map); //정상출력 확인을 위한 map 출력
        System.out.println("찾을 숫자를 입력하세요");
        int search = sc.nextInt();

        /*for(Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(search)) {
                Character findKey = entry.getKey();
                System.out.println(search + "는 " + findKey + "에 있습니다.");
            }
        }*/

        ★★★<Entry<○○○, ●●●>> entrySet = map.☆☆☆();
        Iterator<Entry<○○○, ●●●>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<○○○, ●●●> entry = entryIterator.next();
            if(entry.getValue().equals(search)) {
                ○○○ findKey = entry.＃＃＃();
                System.out.println(search + "는 " + findKey + "에 있습니다.");
            }
        }
    }
}