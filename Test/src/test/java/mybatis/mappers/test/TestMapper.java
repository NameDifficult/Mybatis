package mybatis.mappers.test;

import mybatis.mappers.Mapper;
import mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/9 12:00
 * @Version 1.0
 */
public class TestMapper {
    @Test
    public void insertUserTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("testMybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        User user = new User(null,"测试","222222",200,"女","bbb@qq.com");
        int i = mapper.insertUser(user);
        System.out.println(i);
    }


    @Test
    public void selectForOneUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("testMybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        User user = mapper.selectForOne("张三", "123456");
        System.out.println(user);
    }


    @Test
    public void selectListUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("testMybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        List<User> users = mapper.selectListUser("测试");
        System.out.println(users);
    }
}
