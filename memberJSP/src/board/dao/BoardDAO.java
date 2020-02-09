package board.dao;

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

import board.bean.BoardDTO;

public class BoardDAO {
    private static BoardDAO instance;
    
    private DataSource ds;
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public BoardDAO() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
        } catch (NamingException e) {
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
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void boardWrite(Map<String, String> map) {
        String sql = "INSERT INTO board(seq, id, name, email, subject, content, ref) "
                         + "VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, ?, ?, SEQ_BOARD.NEXTVAL)";
        try {
            conn = ds.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, map.get("id"));
            pstmt.setString(2, map.get("name"));
            pstmt.setString(3, map.get("email"));
            pstmt.setString(4, map.get("subject"));
            pstmt.setString(5, map.get("content"));
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
    } // boardWrite();
    
    public int getTotalArticle() {
        int totalA = 0;
        String sql = "SELECT COUNT(*) FROM board";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.next();
            totalA = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(rs!=null) rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn!=null) conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return totalA;
    } // getTotalArticle()
    
    public List<BoardDTO> getArticle(int startNum,int endNum){
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        String sql = "SELECT * "
                   + "  FROM ("
                            + "SELECT ROWNUM rn, tt.* "
                            + "  FROM (SELECT *"
                                    + "  FROM board "
                                    + " ORDER BY ref DESC)tt"
                          + ") "
                    + "WHERE rn>=? AND rn<=?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                boardDTO.setSeq(rs.getInt("seq"));
                boardDTO.setId(rs.getString("Id"));
                boardDTO.setName(rs.getString("name"));
                boardDTO.setEmail(rs.getString("email"));
                boardDTO.setSubject(rs.getString("subject"));
                boardDTO.setContent(rs.getString("content"));
                boardDTO.setRef(rs.getInt("ref"));
                boardDTO.setLev(rs.getInt("lev"));
                boardDTO.setPseq(rs.getInt("pseq"));
                boardDTO.setReply(rs.getInt("reply"));
                boardDTO.setHit(rs.getInt("hit"));
                boardDTO.setLogtime(rs.getString("logtime"));
                list.add(boardDTO);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
                try {
                    if(pstmt!=null) pstmt.close();
                    if(conn!=null) conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return list;
    } // getArticle()
    public BoardDTO viewContent(int seq) {
        BoardDTO boardDTO = new BoardDTO();
        String sql = "SELECT * FROM board WHERE seq=?";
        try {
            conn = ds.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();
            rs.next();
            boardDTO.setSeq(rs.getInt("seq"));
            boardDTO.setId(rs.getString("Id"));
            boardDTO.setName(rs.getString("name"));
            boardDTO.setEmail(rs.getString("email"));
            boardDTO.setSubject(rs.getString("subject"));
            boardDTO.setContent(rs.getString("content"));
            boardDTO.setRef(rs.getInt("ref"));
            boardDTO.setLev(rs.getInt("lev"));
            boardDTO.setPseq(rs.getInt("pseq"));
            boardDTO.setReply(rs.getInt("reply"));
            boardDTO.setHit(rs.getInt("hit"));
            boardDTO.setLogtime(rs.getString("logtime"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return boardDTO;
    } // viewContent
    
    public void modifyBoard(Map<String, String> map) {
    	int seq = Integer.parseInt(map.get("seq"));
    	String subject = map.get("subject");
    	String content = map.get("content");
    	String sql="UPDATE board "
    			+ "    SET subject=?, content=?, logtime=SYSDATE "
    			  + "WHERE seq=?";
    	try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
    } // modifyBoard()
    
    public void updateHit(int seq) {
    	String sql = "Update board "
    			      + "SET hit=hit+1 "
    			    + "WHERE seq=?";
    	try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
    } // updateHit
}
