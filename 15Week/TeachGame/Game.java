package Ballgame.TeachGame;




import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game {

    public static String fileName = "C:/Temp/loglog.txt";
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
            if (choice == 1) {
                value = 1;
            } else if (choice == 2) {
                if (totalResult.size() == 0) {
                    BaseballGame b = parseJSON("C:/Temp/loglog.txt");
                    if(b == null) {
                        System.out.println("진행된 게임이 없습니다.");
                    } else {
                        totalResult.add(b);
                        totalPrint();
                    }
                } else {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            saveJSON();
                        }
                    });
                    thread.start();
                    parseJSON("C:/Temp/loglog.txt");
                    totalPrint();
                }
//                지난 게임 기록 불러오는 문장
                System.out.println();
                System.out.println("1. 메뉴로 돌아가기 || 2. 모든게임 기록 삭제하기 || 3. 종료하기 ");
                int a = sc.nextInt();

                while (a != 1 && a != 2 && a != 3) {
                    System.out.println("올바른 숫자를 입력해주세요.");
                    a = sc.nextInt();
                }
                if (a == 3) {
                    System.out.println("게임을 종료합니다.");
                    saveJSON();
                    game = a;
                }
                if (a == 2) {
                    System.out.println("정말 모든 게임의 결과를 삭제하시겠습니까?");
                    System.out.println("======== 1. 예 || 2. 아니오 ========");
                    int delete = sc.nextInt();
                    while (delete != 1 && delete != 2) {
                        System.out.println("올바른 숫자를 입력해주세요.");
                    }
                    if (delete == 1) {
                        Writer writer = new FileWriter(fileName, Charset.forName("UTF-8"));
                        writer.write("");
                        writer.flush();
                        writer.close();
                    } else if (delete == 2) {
                        a = 1;
                    }
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
                startGame(gameCount);
                System.out.println(tryCount + "회차 게임을 종료합니다. ");
                System.out.println(">> 게임을 계속하시겠습니까? 계속하려면 1을 입력하세요.");
                value = sc.nextInt();
                tryCount++;
            }
        }
    }

    public static void saveJSON() { //종료할때 JSON에 때려넣는 메서드
        JSONArray jsonArray = new JSONArray();
        try {
            File f = new File(fileName);

            if(f.exists() == false) {
                System.out.println("파일이 존재하지 않으므로 새로 생성합니다.");
                f.createNewFile(); }
            for (int i = 0; i < totalResult.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("PlayDate", totalResult.get(i).playDate);
                jsonObject.put("Success", totalResult.get(i).clearORfail);
                jsonObject.put("Chance for Game", totalResult.get(i).gameCount);
                jsonObject.put("CorrectAnswer", totalResult.get(i).rand_num);
                jsonObject.put("Case Total Info", totalResult.get(i).caseList);
                jsonArray.put(jsonObject);
                String json = jsonArray.toString();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f, true));
                bufferedWriter.newLine();
                bufferedWriter.write(json);
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BaseballGame parseJSON(String fileName) {

        BaseballGame result = new BaseballGame();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName, Charset.forName("UTF-8")));
            StringBuilder jsonContent = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            if(jsonContent.length() == 0) {   // 예외처리 왜 안됨??????????????????????????????????????????????????????
//                원래 의도 : 빈 파일로 바로 기록보기 누르면 기록된 게임이 없습니다 뜨면서 다시 메뉴로 돌라갈라 했는데
//                여기서 리턴을 걸어줘도 아래로 넘어가버린다
                return result;
            }
            reader.close();
            JSONObject jsonObject = null;
            JSONArray jsonArray = new JSONArray(jsonContent.toString());
            for(int i=0; i<jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
            }


            result.playDate = jsonObject.getString("PlayDate");
            result.clearORfail = jsonObject.getBoolean("Success");
            result.gameCount = jsonObject.getInt("Chance for Game");

            JSONArray correctAnswerArray = jsonObject.getJSONArray("CorrectAnswer");
            for (int i = 0; i < correctAnswerArray.length(); i++) {
                result.rand_num = new Integer[3];
                result.rand_num[i] = (correctAnswerArray.getInt(i));
            }

            JSONArray roundInfoArray = jsonObject.getJSONArray("Case Total Info");
            for (int j = 0; j < roundInfoArray.length(); j++) {
                JSONObject roundInfoObject = roundInfoArray.getJSONObject(j);
                CaseInfo roundInfo = new CaseInfo();
                roundInfo.resultText = roundInfoObject.getString("resultText");
                JSONArray userInputArray = roundInfoObject.getJSONArray("user_input");
                for (int k = 0; k < userInputArray.length(); k++) {
                    roundInfo.user_input[k] = userInputArray.getInt(k);
                }
                result.caseList.add(roundInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return result;
    }


        public static void totalPrint () { //토탈 출력문
            if (totalResult.size() == 0) {
                System.out.println("기록이 없습니다. 먼저 게임을 진행해주세요.");
            } else {
                PrintResult rs = new PrintResult();
                int i = 1;
                for (BaseballGame gm : totalResult) {
                    System.out.println(totalResult.get(i - 1).playDate + "에 실행한 게임");
                    System.out.println("\n" + i + "번째 게임");
                    rs.print(gm);
                    i++;
                }
            }
        }


        public static void startGame ( int gameCount){

            BaseballGame myGame = new BaseballGame(gameCount);

            // 랜덤 수 만들기
            MakeNumber maker = new MakeNumber();
            Integer[] comNumber = maker.makeNumber();
            myGame.rand_num = comNumber;

            // 사용자 숫자 입력
            for (int cnt = 0; cnt < gameCount; cnt++) {

                CaseInfo caseinfo = new CaseInfo(cnt + 1);
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
