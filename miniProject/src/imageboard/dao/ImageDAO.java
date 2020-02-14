package imageboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import imageboard.bean.ImageDTO;

public class ImageDAO {
    private static ImageDAO instance;
    
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private DataSource ds;
    
    public static ImageDAO getInstance() {
        if(instance==null) {
            synchronized (ImageDAO.class) {
                instance = new ImageDAO();
            }
        }
        return instance;
    }
    
    public ImageDAO() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");//Tomcat의 경우
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void write(ImageDTO imageDTO) {
        String sql = "INSERT INTO imageboard VALUES(seq_imageboard.NEXTVAL, "
                                                 + "?, "
                                                 + "?, "
                                                 + "?, "
                                                 + "?, "
                                                 + "?, "
                                                 + "?, "
                                                 + "SYSDATE)";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, imageDTO.getImageId());
            pstmt.setString(2, imageDTO.getImageName());
            pstmt.setInt(3, imageDTO.getImagePrice());
            pstmt.setInt(4, imageDTO.getImageQty());
            pstmt.setString(5, imageDTO.getImageContent());
            pstmt.setString(6, imageDTO.getImage1());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }

    public List<ImageDTO> imageboardList(int startNum, int endNum) {
        List<ImageDTO> list = new ArrayList<ImageDTO>();
        String sql = "SELECT * FROM"
                     + "(SELECT ROWNUM rn, tt.* FROM  "
                       + "(SELECT * FROM imageboard ORDER BY seq DESC)tt"
                + ")where rn>=? and rn<=?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setSeq(rs.getInt("seq"));
                imageDTO.setImageId(rs.getString("imageId"));
                imageDTO.setImageName(rs.getString("imageName"));
                imageDTO.setImagePrice(rs.getInt("imagePrice"));
                imageDTO.setImageQty(rs.getInt("imageQty"));
                imageDTO.setImageContent(rs.getString("imageContent"));
                imageDTO.setImage1(rs.getString("image1"));
                imageDTO.setLogtime(rs.getString("logtime"));
                list.add(imageDTO);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
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

    public int getBoardTotalA() {
        int totalA=0;
        String sql = "select count(*) from imageboard";
        
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            rs.next();
            totalA = rs.getInt(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null) rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn!=null) conn.close();
                 
            }catch(SQLException e){
                e.printStackTrace();
            }
         }
        
        return totalA;
    }
    
}
