package board.dao;

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

import board.bean.BoardDTO;

public class BoardDAO {
    private static BoardDAO instance; 
    private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO() {
	    try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
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
	public void boardWrite(Map<String,String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<BoardDTO> boardList(Map<String,Integer> map){
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public BoardDTO getBoard(int seq) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
	    sqlSession.close();
		return boardDTO;
	}
	
	public int getBoardTotalA() {
		int totalA=0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
        totalA = sqlSession.selectOne("boardSQL.getBoardTotalA");
        sqlSession.close();
		return totalA;
	}
	
	public void boardModify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardModify", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void boardHit(int seq) {
	    SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("boardSQL.boardHit", seq);
        sqlSession.commit();
        sqlSession.close();
	}
    public void boardReply(Map<String, String> map) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BoardDTO pDTO = sqlSession.selectOne("boardSQL.getBoard",Integer.parseInt(map.get("pseq"))); // 원글
        
        //글 순서
        sqlSession.update("boardSQL.boardReply1", pDTO);
        //답글 쓰기
        int ref = pDTO.getRef();
        int lev = pDTO.getLev()+1;
        int step = pDTO.getStep()+1;
        map.put("ref", ref+"");
        map.put("lev", lev+"");
        map.put("step", step+"");
        sqlSession.insert("boardSQL.boardReply2", map);
        //답글 수
        sqlSession.update("boardSQL.boardReply3",map.get("pseq"));
        sqlSession.commit();
        sqlSession.close();
    }
    public void boardDelete(int seq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //pseq 업데이트
        sqlSession.update("boardSQL.boardDelete1",seq);
        //reply 업데이트
        sqlSession.update("boardSQL.boardDelete2", seq);
        //글 삭제
        sqlSession.delete("boardSQL.boardDelete3",seq);
        sqlSession.commit();
        sqlSession.close();
    }
}


















