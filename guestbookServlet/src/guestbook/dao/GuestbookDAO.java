package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import guestbook.bean.GuestbookDTO;

public class GuestbookDAO {
    private static GuestbookDAO instance;

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String userName = "c##java";
    private String password = "bit";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public GuestbookDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static GuestbookDAO getInstance() {
        if(instance==null) {
            synchronized (GuestbookDAO.class) {
                instance = new GuestbookDAO();
            }
        }
        return instance;
    }
    
    private void getConnection() {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insert(GuestbookDTO dto) {
        String name = dto.getName();
        String email = dto.getEmail();
        String homepage = dto.getHompage();
        String subject = dto.getSubject();
        String content = dto.getContent();
        
        String sql = "INSERT INTO guestbook VALUES(seq_guestbook.NEXTVAL, ?, ?, ?, ?, ?, sysdate)";
        try {
//            System.out.println("DAO"+dto.getHompage());
            this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, homepage);
            pstmt.setString(4, subject);
            pstmt.setString(5, content);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<GuestbookDTO> selectAll(int startNum, int endNum){
        ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
        String sql = "SELECT *"
                    + " FROM (SELECT ROWNUM rn, tt.*"
                            + " FROM(SELECT seq, name, email, homepage, subject, content"
                                       + ", TO_CHAR(logtime, 'YYYY.MM.DD') AS \"logtime\""
                                   + " FROM guestbook"
                                   +" ORDER BY seq DESC)tt)"
                    + "WHERE rn>=? AND rn<=?";
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                GuestbookDTO guestbookDTO = new GuestbookDTO();
                guestbookDTO.setSeq(rs.getInt("seq"));
                guestbookDTO.setName(rs.getString("name"));
                guestbookDTO.setEmail(rs.getString("email"));
                guestbookDTO.setHomepage(rs.getString("homepage"));
                guestbookDTO.setSubject(rs.getString("subject"));
                guestbookDTO.setContent(rs.getString("content"));
                guestbookDTO.setLogTime(rs.getString("logtime"));
                list.add(guestbookDTO);
            } 
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int getTotalArticle() {
        int totalA=0;
        String sql = "SELECT COUNT(*) FROM guestbook";
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            rs.next();
            totalA = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(rs!=null) rs.close();
                    if(pstmt!=null)pstmt.close();
                    if(conn!=null)conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return totalA;
    }
    
}
