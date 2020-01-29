package guestbook.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            System.out.println("DAO"+dto.getHompage());
            this.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, homepage);
            pstmt.setString(4, subject);
            pstmt.setString(5, content);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
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
    }
    
    public ArrayList<GuestbookDTO> selectAll(){
        ArrayList<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
        String sql = "SELECT name, email, homepage, content, TO_CHAR(SYSDATE, 'YYYY.MM.DD') AS \"date\""
                    + " FROM guestbook";
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                GuestbookDTO dto = new GuestbookDTO();
                dto.setName(rs.getString("name"));
                dto.setDate(rs.getString("date"));
                dto.setEmail(rs.getString("email"));
                dto.setHomepage(rs.getString("homepage"));
                dto.setContent(rs.getString("content"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
