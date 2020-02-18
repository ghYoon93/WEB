package com.mybatis.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import user.bean.UserDTO;

class TestBatis {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeAll
    static void setUp() throws Exception {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
    }
    @Test
    void shouldGetAUser() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", "Cnan");
            Assertions.assertEquals("코난", userDTO.getName());
        }
    }
    

}
