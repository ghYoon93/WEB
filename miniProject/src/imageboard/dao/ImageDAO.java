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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        list = sqlSession.selectList("imageSQL.imageboardList", map);
        sqlSession.close();
        return list;
    }

    public int getImageBoardTotalA() {
    	int totalA=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
        totalA = sqlSession.selectOne("imageSQL.getImageBoardTotalA");
        sqlSession.close();
        
        return totalA;
    }

    public ImageDTO getImageBoard(int seq) {
        ImageDTO imageDTO = new ImageDTO();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        imageDTO = sqlSession.selectOne("imageSQL.getImageBoard", seq);
        sqlSession.close();
        return imageDTO;
    }

    public void delete(String[] seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("imageSQL.delete",seq);
        sqlSession.commit();
        sqlSession.close();
        
    }
    
}
