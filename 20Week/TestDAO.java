package jdbcdaotest;

import com.ithows.JdbcDao;
import java.sql.SQLException;
import java.util.List;

public class TestDAO {
    // 등록된 Edge AP에 대한 정보를 가져 옴
    public static List selectUserList(){

        String query = "select *  " +
                "from testdata " +
                "order by stunum asc " ;

        List list = null;
        try {
            list = JdbcDao.queryForMapList(query, new Object[]{});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

        
    
    public static void deleteUser(int stunum)  {
        try {
                JdbcDao.update("DELETE FROM testdata where stunum= ? ; " ,  new Object[]{stunum});
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
    }
    
    // 찾은 위치에 따라 그리드 id 부여
    public static void updateUser(int stunum, String stuname, int kor, int eng, int math, int total, double avg) {
       

        try {
            JdbcDao.update("UPDATE testdata SET stunum=?, stuname=?, korscore=?, engscore=?, mathscore=?, total=?, average=?  WHERE =? ; ", new Object[]{ stunum, stuname, kor, eng, math, total, avg });
        } catch (SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
       return;
    }
    
     
    
     public static void insertUser(int stunum, String stuname, int kor, int eng, int math, int total, double avg){
        
        String SQL = "insert into " + 
                     "testdata ( stunum, stuname, korscore, engscore, mathscore, total, average ) values (?,?,?,?,?,?,?);";
        
        try {
            
              JdbcDao.update(SQL, new Object[]{ stunum, stuname, kor, eng, math, total, avg });
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ;
    }
    
}
