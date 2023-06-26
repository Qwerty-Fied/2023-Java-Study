package quiz.imade.week7Quiz;

public class Music implements VoiceInterface {

    @Override
    public void off() {
        System.out.println("전원을 끕니다.");
    }

    @Override
    public void setVolume(int volume) {
        if(volume == 0) {
            Music ms = new Music();
            ms.off();
        } else {
            System.out.println("볼륨을 " + volume + "으로 설정합니다.");
        }
    }
}
// 중복 수행 가능성이 있으므로 setvolume 메서드를 수정한다.