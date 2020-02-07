package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.bean.MemberDTO;

public class MemberDAO {
    private static MemberDAO instance;
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private DataSource ds; 
            
    public MemberDAO() {
        Context ctx;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    public static MemberDAO getInstance() {
    	if(instance == null) {
    		synchronized (MemberDAO.class) {
    			instance = new MemberDAO();                
    		}
    	}
    	return instance;
    }
    
    public boolean findMemberById(String id) {
        String sql = "SELECT * FROM member WHERE id=?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(rs!=null)rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }
    
    public MemberDTO findMember(String id) {
        String sql = "SELECT * FROM member WHERE id = ?";
        MemberDTO memberDTO = new MemberDTO();
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {                
                memberDTO.setId(rs.getString("id"));
                memberDTO.setName(rs.getString("name"));
                memberDTO.setGender(rs.getString("gender"));
                memberDTO.setEmail1(rs.getString("email1")==null ? "":rs.getString("email1"));
                memberDTO.setEmail2(rs.getString("email2")==null ? "":rs.getString("email2"));
                memberDTO.setTel1(rs.getString("tel1")==null ? "":rs.getString("tel1"));
                memberDTO.setTel2(rs.getString("tel2")==null ? "":rs.getString("tel2"));
                memberDTO.setTel3(rs.getString("tel3")==null ? "":rs.getString("tel3"));
                memberDTO.setZipcode(rs.getString("zipcode")==null ? "":rs.getString("zipcode"));
                memberDTO.setAddr1(rs.getString("addr1")==null ? "":rs.getString("addr1"));
                memberDTO.setAddr2(rs.getString("addr2")==null ? "":rs.getString("addr2"));
            }
        } catch (SQLException e) {
            memberDTO = null;
            e.printStackTrace();
        }finally {
                try {
                    if(rs!=null)rs.close();
                    if(pstmt!=null) pstmt.close();
                    if(conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return memberDTO;
    }

    public boolean pwdEquals(String id, String pw) {
        String sql = "SELECT * FROM member WHERE id=? AND pwd=?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if(rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
        return false;
    }

    public String getName(String id) {
        String name="";
        String sql = "SELECT name FROM member WHERE id = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) name = rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)rs.close();
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
        return name;
    }

	public void write(MemberDTO memberDTO) {
		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getId());
            pstmt.setString(3, memberDTO.getPwd());
            pstmt.setString(4, memberDTO.getGender());
            pstmt.setString(5, memberDTO.getEmail1());
            pstmt.setString(6, memberDTO.getEmail2());
            pstmt.setString(7, memberDTO.getTel1());
            pstmt.setString(8, memberDTO.getTel2());
            pstmt.setString(9, memberDTO.getTel3());
            pstmt.setString(10, memberDTO.getZipcode());
            pstmt.setString(11, memberDTO.getAddr1());
            pstmt.setString(12, memberDTO.getAddr2());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
		
	}
	
	public void update(MemberDTO memberDTO) {
	    String sql = "UPDATE member "
	                      + "SET name = ?, "
	                          + "pwd = ?, "
	                          + "gender = ?, "
	                          + "email1 = ?, "
	                          + "email2 = ?, "
	                          + "tel1 = ?, "
	                          + "tel2 = ?, "
	                          + "tel3 = ?, "
	                          + "zipcode = ?, "
	                          + "addr1 = ?, "
	                          + "addr2 = ?, "
	                          + "logtime = SYSDATE "
	                + "WHERE id = ?";
	    try {
	        conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberDTO.getName());
            pstmt.setString(2, memberDTO.getPwd());
            pstmt.setString(3, memberDTO.getGender());
            pstmt.setString(4, memberDTO.getEmail1());
            pstmt.setString(5, memberDTO.getEmail2());
            pstmt.setString(6, memberDTO.getTel1());
            pstmt.setString(7, memberDTO.getTel2());
            pstmt.setString(8, memberDTO.getTel3());
            pstmt.setString(9, memberDTO.getZipcode());
            pstmt.setString(10, memberDTO.getAddr1());
            pstmt.setString(11, memberDTO.getAddr2());
            pstmt.setString(12, memberDTO.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
	                      
	}
}

