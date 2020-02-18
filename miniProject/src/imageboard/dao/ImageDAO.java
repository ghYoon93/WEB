package imageboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;
import imageboard.bean.ImageDTO;

public class ImageDAO {
    private static ImageDAO instance;

    private static SqlSessionFactory sqlSessionFactory;
    
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
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(ImageDTO imageDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("imageSQL.write", imageDTO);
        sqlSession.commit();
        sqlSession.close();
    }

    public List<ImageDTO> imageboardList(Map<String,Integer> map) {
        List<ImageDTO> list = new ArrayList<ImageDTO>();
        String sql = "SELECT * FROM"
                     + "(SELECT ROWNUM rn, tt.* FROM  "
                       + "(SELECT * FROM imageboard ORDER BY seq DESC)tt"
                + ")where rn>=? and rn<=?";
        SqlSession sqlSession = sqlSessionFactory.openSession();
        list = sqlSession.selectList("imageboardSQL.imageboardList", map);
        sqlSession.close();
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
