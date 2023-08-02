package Ballgame.TeachGame;




import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {

    public static ArrayList<BaseballGame> totalResult = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        int gameCount = 3;
        Scanner sc = new Scanner(System.in);
        int game = 1;
        int value = 0;

        //성적보기함수 들어갈 자리
        int tryCount = 1; //회차 정리를 위한 변수 선언
        while (game == 1) {
            System.out.println("======숫자야구 게임을 시작합니다======");
            System.out.println("1.게임시작 || 2.게임성적보기 || 3.종료");
            System.out.println("==================================");
            int choice = sc.nextInt();
            if(choice == 1) {
                value = 1;
            } else if (choice == 2) {
                totalPrint();
                System.out.println();
                System.out.println("1. 메뉴로 돌아가기 || 2. 종료하기 ");
                int a = sc.nextInt();

                while(a != 1 && a != 2) {
                    System.out.println("올바른 숫자를 입력해주세요.");
                    a = sc.nextInt();
                }
                if(a == 2) {
                    System.out.println("게임을 종료합니다.");
                    saveJSON();
                    game = a;
                }
                //1이면 메뉴, 2면 종료하기 == 1,2가 아닐시 예외처리 필요
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                saveJSON();
                exit(0);
            } else {
            System.out.println("올바른 숫자를 입력하세요. (1, 2, 3)");
            }
            while (value == 1) {
                System.out.println("\n\n>> " + tryCount + "회차 게임을 시작합니다.");
                startGame(gameCount, totalResult);
                System.out.println(tryCount + "회차 게임을 종료합니다. ");
                System.out.println(">> 게임을 계속하시겠습니까? 계속하려면 1을 입력하세요.");
                value = sc.nextInt();
                tryCount++;
            }
        }
    }

    public static void saveJSON() throws IOException{ //종료할때 JSON에 때려넣는 메서드
        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<totalResult.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(" 성공여부 ",totalResult.get(i).clearORfail);
            jsonObject.put(" 한 게임당 기회 ",totalResult.get(i).gameCount);
            jsonObject.put(" 정답 ",totalResult.get(i).rand_num);
            jsonObject.put(" 회차정보 ",totalResult.get(i).caseList);
            jsonArray.put(jsonObject);
            String json = jsonArray.toString();
            System.out.println(json);

            Writer writer = new FileWriter("C:/Users/PARK/Desktop/loglog.json", Charset.forName("UTF-8"));
            writer.write(json);
            writer.flush();
            writer.close();

        }
    }
    public static void totalPrint() { //토탈 출력문
        if(totalResult.size() == 0) {
            System.out.println("기록이 없습니다. 먼저 게임을 진행해주세요.");
        }
        PrintResult rs = new PrintResult();
        int i = 1;
        for(BaseballGame gm : totalResult) {
            System.out.println("\n" + i + "번째 게임");
            rs.print(gm);
            i++;
        }
    }


    public static void startGame(int gameCount, ArrayList<BaseballGame> totalResulty){

        BaseballGame myGame = new BaseballGame(gameCount);

        // 랜덤 수 만들기
        MakeNumber maker = new MakeNumber();
        Integer[] comNumber = maker.makeNumber();
        myGame.rand_num = comNumber;

        // 사용자 숫자 입력
        for(int cnt = 0; cnt < gameCount ; cnt++) {

            CaseInfo caseinfo = new CaseInfo(cnt+1);
            myGame.inputUserNumber(caseinfo);
            int strike_num = myGame.checkNumber();
            if (strike_num == 3) {
                System.out.println("\n === 게임 클리어");
                break;
            } else if (cnt == gameCount - 1) {
                //System.out.println("\n === 게임 클리어 실패");

            }
        }
        PrintResult printer = new PrintResult();
        printer.print(myGame);

        totalResult.add(myGame);
    }
}
