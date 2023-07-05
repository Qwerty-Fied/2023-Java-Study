package quiz;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] A = {13,99,50,71,2,7,41,62,77,85};

        for(int i=0; i<A.length; i++) { //i가 배열의 길이만큼 커질때까지 반복
            for(int j=i+1; j<A.length; j++) {
                if(A[i] > A[j]) { // i를 i 다음 인덱스번호의 J와 비교
                    int tmp = A[i];  //임시저장 변수 선언
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }
        System.out.println();
        for (int i : A) {  //순서대로 가져와서
            System.out.println(i); //출력
        }
    }
}
