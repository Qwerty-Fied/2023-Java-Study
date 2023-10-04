/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcdaotest;

import com.ithows.ResultMap;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mailt
 */
public class JDBCDaoTest {
    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("1. Insert // 2. Select");
        System.out.println("3. Update // 4. Delete");
        
        int a = sc.nextInt();
        switch(a) {
            case 1: JDBCDaoTest.inputData();
                    break;
            case 2: 
                    break;
                
        }
       
        
        
        
        
        //TestDAO.insertUser("Park", "대전시 전민동 10");
        //TestDAO.insertUser("Kim Yong", "대전시 전민동 20");
        
        
       
    }
    
    public static void inputData() {
        int stunum = sc.nextInt();
        String stuname = sc.next();
        int kor = sc.nextInt();
        int eng = sc.nextInt();
        int math = sc.nextInt();
        int total = kor + eng + math;
        double avg = total / 3;
        TestDAO.insertUser(stunum, stuname, kor, eng, math, total, avg);
        
    }
    
    public static void selectData() {
        System.out.println("검색할 항목을 입력하세요");
        String a = sc.next();
        System.out.println(a + "(이)가 * 인 사람 검색하기. * 에 들어갈 값을 입력해주세요.");
        String b = "";
        if (a.equals("stuname")) {b = sc.next(); }
        else {
        }
    }
    public static void updateData() {
        System.out.println("A 값이 B인 사람의 C 값을 D로 바꾸기");
        System.out.println("-------------------------------");
        System.out.println("A의 값 : ");
        String a = sc.next();
        System.out.println("B의 값 : ");
        String b = sc.next();
        System.out.println("C의 값 : ");
        String c = sc.next();
        System.out.println("D의 값 : ");
        String d = sc.next();
        TestDAO.updateUser(0, a, 0, 0, 0, 0, 0);
    }
    public static void deleteData() {
        
    }
        
    
}
    
/* if(a == 1) {
                JDBCDaoTest.inputData();
        } else if(a == 2) {
        
        }
        
            ArrayList<ResultMap> list = (ArrayList<ResultMap>)TestDAO.selectUserList();

        for(ResultMap item : list){
            System.out.println("번호 " + item.getInt("stunum"));
            System.out.println("이름 " + item.getString("stuname"));
            System.out.println("주소 " + item.getString("kor"));
            System.out.println("---------------------------------------------------------");
        }
         TestDAO.deleteUser(5);
        

        list = (ArrayList<ResultMap>)TestDAO.selectUserList();

        for(ResultMap item : list){
            System.out.println("번호 " + item.getInt("고객번호"));
            System.out.println("이름 " + item.getString("이름"));
            System.out.println("주소 " + item.getString("주소"));
            System.out.println("---------------------------------------------------------");
        } */