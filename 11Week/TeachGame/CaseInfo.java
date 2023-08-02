package Ballgame.TeachGame;
public class CaseInfo {

    private int caseNo = 0;
    private Integer[] user_input = null;
    private String resultText = "";

    private int strike_num = 0;
    private int ball_num = 0;

    public CaseInfo(){
        user_input = new Integer[3];
    }

    public CaseInfo(int no){
        caseNo = no ;
        user_input = new Integer[3];
    }

    public int getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(int caseNo) {
        this.caseNo = caseNo;
    }

    public Integer[] getUser_input() {
        return user_input;
    }

    public void setUser_input(Integer[] user_input) {
        this.user_input = user_input;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResult(int strike_num, int ball_num) {

        this.strike_num = strike_num;
        this.ball_num = ball_num;

        String result = "" + caseNo + "회차 판정 -- " + this.strike_num + " 스트라이크 , " + this.ball_num + " 볼 ";
        this.resultText = result;
    }

    public int getStrike_num() {
        return strike_num;
    }

    public void setStrike_num(int strike_num) {
        this.strike_num = strike_num;
    }

    public int getBall_num() {
        return ball_num;
    }

    public void setBall_num(int ball_num) {
        this.ball_num = ball_num;
    }

}
