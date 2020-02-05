package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;

public class BoardDAO {
    private static BoardDAO instance;
    
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String userName = "c##java";
    private String password = "bit";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public BoardDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static BoardDAO getInstance() {
        if(instance == null) {
            synchronized (BoardDAO.class) {
                instance = new BoardDAO();                
            }
        }
        return instance;
    }
    
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void write(BoardDTO boardDTO) {
        String sql = "INSERT INTO board(seq, id, name, email, subject, content, ref) "
                         + "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, ?, ?, SEQ_BOARD.NEXTVAL)";
        getConnection();
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, boardDTO.getId());
            pstmt.setString(2, boardDTO.getName());
            pstmt.setString(3, boardDTO.getEmail());
            pstmt.setString(4, boardDTO.getSubject());
            pstmt.setString(5, boardDTO.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
                try {
                    if(pstmt!=null) conn.close();
                    if(conn!=null) conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}
