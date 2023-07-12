package Ballgame.MyArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballArray {

    public static void main(String[] args) { //입력한 수, 회차, 판정결과
        Scanner sc = new Scanner(System.in);
        int count = 3;
        int game = 1;
        while (game == 1) {
            gameStart(count);
            System.out.println();
            System.out.println("한번 더 하시려면 1을 눌러주세요");
            int in = sc.nextInt();
            if(in != 1) {
                game = in;
            }
        }
        System.out.println("게임을 종료합니다.");
    }

    public static void gameStart(int count) {
        SavaData savaData = new SavaData();
        BaseballUtil util = new BaseballUtil();
        util.ranNum(savaData); //랜덤넘버 넘어옴
        for(int i=0; i<count; i++) {
            util.inputNum(i, savaData); //인풋넘버 넘어옴
            util.checkNum(i, savaData);
            int strike = util.checkNum(i, savaData);

            //////////////////////////////////////////////////////////////////////
            for(int q=0; q<3; q++){   //여기서부터
                for(int w=0; w<3; w++){
                    System.out.print(savaData.myResult[q][w]);
                }
                System.out.println();
                for(int e=0; e<2; e++){
                    System.out.print(savaData.strikeBall[q][e]);
                }
                System.out.println();
            }
            for(int r=0; r<10; r++) {
                System.out.print(savaData.inputNum[r]);
            }
            System.out.println(savaData.COUNT);  //여기까지 디버깅 문장
            /////////////////////////////////////////////////////////////////////

            if (strike == 3) {
                System.out.println("클리어 하셨습니다. 게임을 종료합니다.");
                util.save(i, savaData);
              //  list.add(new BaseballResult(count, myResult, strikeBall)); //리스트에 회차, 입력값, 결과 추가
                break;
            } else if (i == count -1){
                System.out.println("게임이 종료되었습니다. 클리어에 실패하셨습니다.");
            }
        }
        PrintResults printResults = new PrintResults();
        printResults.totalResults(count, savaData);
        /*printResults.print(베이스볼 리절트에 리스트 꺼내오기);*/

    }
}