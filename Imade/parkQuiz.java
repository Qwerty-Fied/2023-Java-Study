import java.util.Scanner;

public class parkQuiz {
	public static void main(String[] args){
		System.out.print("사과는 어디에 있을까요?");
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		int[][] array = new int[3][3];
		int randomFolder1 = (int)((Math.random()*3)+1);
		int randomFolder2 = (int)((Math.random()*3)+1);
		array[randomFolder1][randomFolder2] = 1;
		boolean start = true;
		int life = 5;
		while(start) {
			System.out.print("상자를 선택하세요. 1~3 : ");
			int firstInput = sc.nextInt();
			System.out.print("두번째 상자를 선택하세요. 1~3 : ");
			int secondInput = sc.nextInt();
			array[firstInput][secondInput] =1;
			
			if((array[randomFolder1][randomFolder2]) == (array[firstInput][secondInput])) {
				System.out.println("정답입니다! 사과는 여기 있었습니다.");
				start = false;
			} else if((array[randomFolder1][randomFolder2]) != (array[firstInput][secondInput])){
				System.out.println("땡! 사과는 여기 없습니다.");
				life--;
			} else if(life == 0) {
				System.out.println("기회가 모두 소진되었습니다. 사과는 " + randomFolder1 + ", " + randomFolder2 + "에 있었습니다.");
			}
		}
		
	}
}
