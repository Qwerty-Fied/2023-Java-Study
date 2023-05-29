package quiz.imade.importStar;

public class ImportStar {
    String a;

    String b = "*";
    public ImportStar(String a) {
        System.out.println("별이 내립니다.");
        for(int i=0; i<9; i++) {
            b += a;
            System.out.println(b);
        }
    }

}