package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import param.bean.ParamDTO;
import user.bean.UserDTO;

public class UserDAO {
    private static UserDAO instance;
    private SqlSessionFactory sqlSessionFactory;
    public UserDAO() {
        /*
         * mybatis-config.xml 파일을 읽어서 SqlSessionFactory를 생성한다.
         * IO stream
         * 1. byte - InputStream
         * 2. 
         */
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static UserDAO getInstance() {
        if(instance == null) {
            synchronized (UserDAO.class) {
                instance = new UserDAO();
            }
        }
        return instance;
    }
    public void userWrite(UserDTO userDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userSQL.userWrite", userDTO);
        sqlSession.commit();
        sqlSession.close();
    }
    public List<UserDTO> getUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
        sqlSession.close();
        return list;
        
    }
    public UserDTO getUser(String id) {
        UserDTO userDTO = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userDTO = sqlSession.selectOne("userSQL.getUser", id);
        sqlSession.close();
        return userDTO;
    }
    public void userUpdate(UserDTO userDTO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userSQL.userUpdate", userDTO);
        sqlSession.commit();
        sqlSession.close();
    }
    public void userDelete(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userSQL.userDelete", id);
        sqlSession.commit();
        sqlSession.close();
    }
    public List<UserDTO> userSearch(String colName, String value) {
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setColName(colName);
        paramDTO.setValue(value);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserDTO> list= sqlSession.selectList("userSQL.userSearch", paramDTO);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
}
