import java.util.Scanner;

public class answer2WeekQuiz {
    public static void main(String[] args){
        System.out.println("사과는 어디에 있을까요?");
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[3][3];
        int randomFolder1 = (int)(Math.random()*3);
        int randomFolder2 = (int)(Math.random()*3);
        array[randomFolder1][randomFolder2] = 1;
        boolean start = true;
        int life = 5;
        while(start) {
            System.out.print("상자를 선택하세요. 1~3 : ");
            int firstInput = sc.nextInt();
            int fIn = firstInput-1;
            System.out.print("두번째 상자를 선택하세요. 1~3 : ");
            int secondInput = sc.nextInt();
            int sIn = secondInput-1;
            int[][] anwerarray = new int[3][3];
            anwerarray[fIn][sIn] = 1;
            if((array[randomFolder1][randomFolder2]) == (array[fIn][sIn])) {
                System.out.println("정답입니다! 사과는 여기 있었습니다.");
                start = false;
            } else if((array[randomFolder1][randomFolder2]) != array[fIn][sIn]){
                System.out.println("땡! 사과는 여기 없습니다.");
                life--;
            }
            if(life == 0) {
                System.out.println("기회가 모두 소진되었습니다. 사과는 " + randomFolder1 + ", " + randomFolder2 + "에 있었습니다.");
            }
        }
    }
}