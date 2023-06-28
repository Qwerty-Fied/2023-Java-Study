package quiz.someMade.Week6;

public class SE {
    public static void main(String[] args){
        AB ab = new SI();

        ab.dM1(); //디폴트 메소드 호출
        System.out.println();
        ab.dM2();
        System.out.println();

        AB.sM1(); //정적메소드 호출
        System.out.println();
        AB.sM2();


/*
dM1 종속코드
dM 중복코드A
dM 중복코드B

dm2 종속코드
dM 중복코드A
dM 중복코드B

sM1 종속코드
sM 중복코드C
sM 중복코드D

sM2 종속코드
sM 중복코드C
sM 중복코드D
위 와 같이결과값이 나오도록 코딩해주세용
*/
    }
}
