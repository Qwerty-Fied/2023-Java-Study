package quiz.imade.week6Quiz;

public interface VoiceInterface {

    void off();
    void setVolume(int volume);

    default void setMute(boolean mute) {
        if(mute) {
            System.out.println("볼륨이 0이므로 전원을 끕니다.");
        }
    }
}
//힌트 = 볼륨이 0이면 호출될 default 메서드를 작성해야한다.
