package quiz.imade;


/*다음은 클래스의 타입변환에 관련된 문제입니다.
 스캐너에 true를 입력시 부모클래스의 Myquiz가 실행되도록,
 false를 입력시 자식클래스의 Myquiz가 실행되도록 else if 문을 완성해주세요.
 **객체이름은 어떻게 지어도 상관없습니다**
 */


import java.util.Scanner;
class Myquiz {
    public void myHeart() {
        System.out.println("무슨 소리 하십니까. 책펴고 공부하십쇼");
    }
}

class MyExtends extends Myquiz {
    @Override
    public void myHeart() {
        System.out.println("좋습니다. 열심히 하십쇼");
    }
}

public class VacationMindset {
    public static void main(String[] args) {
        Myquiz myquiz = new MyExtends();
        Scanner sc = new Scanner(System.in);
        System.out.println("방학이니 공부를 좀 쉬고 놀러고가고 싶습니까? true / false");
        boolean b = sc.nextBoolean();
        if(b == true) {
            myquiz.myHeart();
        } else if(b == false) {
            ###########이곳을 완성해주세요##############
            ★★★.myHeart();
        }
    }
}
