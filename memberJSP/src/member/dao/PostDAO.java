package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.PostDTO;

public class PostDAO {
private static PostDAO instance;
    
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String userName = "c##java";
    private String password = "bit";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public PostDAO() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static PostDAO getInstance() {
        if(instance == null) {
            synchronized (PostDAO.class) {
                instance = new PostDAO();                
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
    
    public List<PostDTO> select(String sido, String sigungu, String roadname){
        List<PostDTO> list = new ArrayList<PostDTO>();
        
        String sql = "SELECT *"
                    + " FROM newzipcode"
                   + " WHERE sido = ?"
                     + " AND NVL(sigungu, ' ') LIKE ?"
                     + " AND NVL(roadname, ' ') LIKE ?"; 
        this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sido);
            pstmt.setString(2, "%"+sigungu+"%");
            pstmt.setString(3, "%"+roadname+"%");
            rs = pstmt.executeQuery();
            while(rs.next()) {
                PostDTO postDTO = new PostDTO();
                
                postDTO.setZipcode(rs.getString("zipcode"));
                postDTO.setSido(rs.getString("sido"));
                if(rs.getString("sigungu")!=null) {                    
                    postDTO.setSigungu(rs.getString("sigungu"));
                } else {
                    postDTO.setSigungu("");
                }
                if(rs.getString("yubmyundong")!=null) {
                    postDTO.setYubmyundong(rs.getString("yubmyundong"));
                } else {
                    postDTO.setYubmyundong("");
                }
                
                if(rs.getString("ri")!=null) {
                    postDTO.setRi(rs.getString("ri"));
                } else {
                    postDTO.setRi("");
                }
                
                postDTO.setRoadname(rs.getString("roadname"));
                
                if(rs.getString("buildingname")!=null) {
                    postDTO.setBuildingname(rs.getString("buildingname"));
                }else {
                    postDTO.setBuildingname("");
                }
                list.add(postDTO);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        } finally{
                try {
                    if(rs!=null) rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn!=null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
        }
        return list;
        
    }
}
