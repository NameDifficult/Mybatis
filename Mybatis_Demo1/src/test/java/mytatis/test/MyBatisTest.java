package mytatis.test;

import mybatis.mapper.UserMapper;
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
 * @Date 2022/3/7 16:52
 * @Version 1.0
 */
public class MyBatisTest {

    /**
     * 增加
     * @throws IOException
     */
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.insertUser();
        //手动提交事务
        sqlSession.commit();
        System.out.println(result);
    }


    /**
     * 修改
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser();
        sqlSession.commit();
        System.out.println(i);
    }

    /**
     * 删除
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser();
        System.out.println(i);
    }

    /**
     * 根据ID查找单个
     */
    @Test
    public void testSelectForOneById() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById();
        System.out.println(userById);
    }


    /**
     * 根据ID查找多个
     */
    @Test
    public void testSelectAllUser() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }
}
