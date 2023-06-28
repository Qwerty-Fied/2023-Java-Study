package quiz.someMade.Week6;

public class Extends {
    public static void main(String[] args) {
        MaruSeries mrsr = new MaruSeries();

        HoduMaru hm = mrsr;
        hm.mathodA();
        System.out.println();

        NockchaMaru nm = mrsr;
        nm.methodB();
        System.out.println();

        CherryMaru cm = mrsr;
        cm.mathodA();
        cm.methodB();
        cm.methodC();
        System.out.println();
    }
}
