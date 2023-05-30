package quiz.someMade.Week3;

public class hyo0529_02 extends hyo0529_01{
    public hyo0529_02(String age, String name, String color) {
        super(age, name, color);
        System.out.println("나는 "+age+" 살이고, 이름은 " + name+ "이야. 좋아하는 색은 "+color+"이야.");
    }

    public static void main(String[] args) {
        hyo0529_02 a = new hyo0529_02("23","김효경","검정색");
    }
}
