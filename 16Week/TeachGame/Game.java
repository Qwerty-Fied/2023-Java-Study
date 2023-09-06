package TeachGame;




import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Game {
    public static String server = "localhost"; // MySQL 서버 주소
    public static String database = "baseballgame"; // MySQL DATABASE 이름
    public static String user_name = "root"; //  MySQL 서버 아이디
    public static String password = "1234"; // MySQL 서버 비밀번호
    public static Connection con = null;


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
                    roadDB();
                    System.out.println("이전 게임의 데이터를 불러왔습니다");
                } else {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            saveDB();
                        }
                    });
                    thread.start();
                    roadDB();
                    totalPrint();
                }
//                지난 게임 기록 불러오는 문장
                System.out.println();
                System.out.println("1. 메뉴로 돌아가기 || 2. 종료하기 ");
                int a = sc.nextInt();

                while (a != 1 && a != 2) {
                    System.out.println("올바른 숫자를 입력해주세요.");
                    a = sc.nextInt();
                }
                if (a == 2) {
                    System.out.println("게임을 종료합니다.");
                    if(totalResult.size() != 0) {
                        saveDB();
                    }
                    game = a;
                }
                //1이면 메뉴, 2면 종료하기 == 1,2가 아닐시 예외처리 필요
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                if(totalResult.size() != 0) {
                    saveDB();
                }
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

    public static void saveDB() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password); /*1. db연결문*/
            if(con != null) /*if not null=널이 아니면*/
            {
                out.println("Database Connect  : [ success ]"); /*볼드체*/
            }else{ /*널이면*/
                out.println("Database Connect  : [ fail ]"); /* + 앞뒤 문자열 더하기*/
            }; /*2. DB연결 확인 후 출력*/
            String sql = "INSERT INTO ballgame (playdate, passorfail, answer) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
            for(int i=0; i<totalResult.size(); i++) {
                preparedStatement.setString(1, totalResult.get(i).playDate);
                preparedStatement.setBoolean(2, totalResult.get(i).clearORfail);
                String answer = "";
                for(int j=0; j<totalResult.get(i).rand_num.length; j++) {
                    answer += totalResult.get(i).rand_num[j];
                }
                preparedStatement.setInt(3, Integer.parseInt(answer));
            }
            int checkInsert = preparedStatement.executeUpdate();

            if (checkInsert > 0) {
                System.out.println("잘 올라감");
            } else {
                System.out.println("문제 있음");
            }

            preparedStatement.close();
            con.close(); /*5. DB연동 해제*/
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void roadDB() { //종료할때 JSON에 때려넣는 메서드
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password); /*1. db연결문*/
            if(con != null) /*if not null=널이 아니면*/
            {
                out.println("Database Connect  : [ success ]"); /*볼드체*/
            }else{ /*널이면*/
                out.println("Database Connect  : [ fail ]"); /* + 앞뒤 문자열 더하기*/
            }; /*2. DB연결 확인 후 출력*/
            PreparedStatement preparedStatement = con.prepareStatement("select * from ballgame");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String playdate = rs.getString("playdate");
                Boolean porf = rs.getBoolean("passorfail");
                int answer = rs.getInt("answer");
                out.println("플레이 날짜 : " + playdate);
                out.println("성공여부 : " + porf);
                out.println("정답 : " + answer);
                out.println("----------------------------------------------------------");
            }
            preparedStatement.close();
            con.close(); /*5. DB연동 해제*/
        }catch(Exception e){
            e.printStackTrace();
        }
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
