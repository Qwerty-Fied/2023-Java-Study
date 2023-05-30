package quiz.someMade.Week3;

public class TurboModeCar extends Car {

    public static final int NORMAl = 1;
    public static final int TURBO = 2;

    public int driveMode = NORMAl;

    //@Override
    public void driveMode()  {
        if (driveMode == TURBO) {
            System.out.println("터보모드로 주행합니다.");
        } else {
            super.drive();
        }
    }

}
