package quiz.someMade.Week3;

public class TurboModeCarExample {
    public static void main(String[] args) {
        TurboModeCar tcar = new TurboModeCar();

        tcar.startCar();
        tcar.drive();
        tcar.driveMode = TurboModeCar.TURBO;
        tcar.driveMode();
        tcar.driveMode = TurboModeCar.NORMAl;
        tcar.driveMode();
        tcar.stopCar();
       /*
        시동을 겁니다.
        일반모드로 주행합니다
        터보모드로 주행합니다.
        일반모드로 주행합니다
        시동을 끕니다.

        위와 같은 출력값이 나오도록 코드 입력
        */
    }
}
