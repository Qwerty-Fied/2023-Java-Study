package quiz.someMade.Week3;

public class BlueThSpeakerExample {
    public static void main(String[] args) {
        //BlueThSpeaker 객체를 mySpeaker로 생성해주세요 . model이나 color 는 임의로!
        BlueThSpeaker mySpeaker = new BlueThSpeaker("SHU-001", "BLUE");

        System.out.println("모델:" + mySpeaker.model); //여기는 Speaker로 부터 상속받은 필드 읽는 부분입니다.
        System.out.println("색상:" + mySpeaker.color);
    }
}
