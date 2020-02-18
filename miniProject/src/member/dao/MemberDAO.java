package member.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
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
import org.junit.jupiter.api.Assertions;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {
	private static MemberDAO instance;

	private static SqlSessionFactory sqlSessionFactory;

	public static MemberDAO getInstance() {
		if(instance==null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}
	
	public MemberDAO() {
	    Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public boolean isExistId(String id) {
	    boolean exist = false;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.selectOne("memberSQL.isExistId",id);
        sqlSession.close();
        Assertions.assertTrue(result>0);
        if(result>0) exist = true;
		
		return exist;
	}

	public void write(MemberDTO memberDTO) {
		int su=0;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert("memberSQL.write",memberDTO);
	    sqlSession.commit();
	    sqlSession.close();
	}

	public MemberDTO login(Map<String,String> map) {
		MemberDTO memberDTO = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
        memberDTO = sqlSession.selectOne("memberSQL.login", map);
        sqlSession.close();
		return memberDTO;
	}
	
	public List<ZipcodeDTO> getZipcodeList(Map<String,String> map){
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
        list = sqlSession.selectList("memberSQL.getZipcodeList", map);
        sqlSession.close();
		return list;
	}
	
	public MemberDTO getMember(String id){
		MemberDTO memberDTO = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
        memberDTO = sqlSession.selectOne("memberSQL.getMember", id);
        sqlSession.close();
		return memberDTO;
	}
	
	public void modify(MemberDTO memberDTO) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();sqlSession.update("memberSQL.modify", memberDTO);
        sqlSession.commit();
        sqlSession.close();
	}
}













