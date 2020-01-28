package member.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    private static MemberDAO instance;
    
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String userName = "c##java";
    private String password = "bit";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public MemberDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static MemberDAO getInstance() {
        if(instance == null) {
            synchronized (MemberDAO.class) {
                instance = new MemberDAO();                
            }
        }
        return instance;
    }
    public boolean isExistId(String id) {
        boolean isExist = false;
        String sql = "SELECT * FROM member WHERE id=?";
        try {
            this.getConnection();
//            System.out.println("id: "+id);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(rs!=null)rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            
        }
        return false;
    }

    public boolean isPwMatch(String id, String pw) {
        String sql = "SELECT * FROM member WHERE id=? AND pwd=?";
        try {
            this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if(rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
        return false;
    }

    public String findName(String id) {
        String name="";
        String sql = "SELECT name FROM member WHERE id = ?";
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) name = rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
        return name;
    }
}
