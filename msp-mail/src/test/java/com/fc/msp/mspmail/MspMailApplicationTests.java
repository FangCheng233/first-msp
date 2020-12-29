package com.fc.msp.mspmail;

import com.fc.msp.mspmail.entity.SysMenu;
import com.fc.msp.mspmail.mapper.SysMenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class MspMailApplicationTests {

    @Test
    void contextLoads() {
    }
//    @Test
    public static void main(String[] args) throws IOException {
        String confPath = "./SqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(confPath);

        // 2. 构建SqlSessionFactory(用于获取sqlSession)
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);

        // 3. 获取sqlSession对象(用于具体的CRUD)
        SqlSession sqlSession = sessionFactory.openSession();
        SysMenuMapper studentDao = sqlSession.getMapper(SysMenuMapper.class);
        SqlSession sqlSession1 = sessionFactory.openSession();

        SysMenuMapper studentDao1 = sqlSession1.getMapper(SysMenuMapper.class);
        SqlSession sqlSession2 = sessionFactory.openSession();

        SysMenuMapper studentDao2 = sqlSession2.getMapper(SysMenuMapper.class);
        SysMenu studentList = studentDao.selectByPrimaryKey(1);
        sqlSession.commit();
        System.out.println("studentList: " + studentList);
        SysMenu studentList1 = studentDao1.selectByPrimaryKey(1);

        sqlSession1.commit();
        sqlSession.close();
        System.out.println("studentList1: " + studentList1);
        for(int i = 0;i<20;i++){
            SysMenu studentList2 = studentDao2.selectByPrimaryKey(1);
            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }
            sqlSession2.commit();
            System.out.println("studentList2: " + studentList2);
        }

    }
}
