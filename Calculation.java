package quiz.someMade.Week2;

public class Calculation {
    int plus(int a, int b) {
        int result = a+b;
        System.out.println("더하기 : "+result);
        return result;
    }
    int minus(int a, int b) {
        int result = a-b;
        System.out.println("빼기 : "+result);
        return result;
    }

    int multiplication(int a, int b) {
        int result = a*b;
        System.out.println("곱하기 : "+result);
        return result;
    }

    int division(int a, int b) {
        int result = a/b;
        System.out.println("나누기 : "+result);
        return result;

    }


}