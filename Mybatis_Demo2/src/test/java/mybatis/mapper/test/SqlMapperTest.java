package mybatis.mapper.test;

import mybatis.mapper.SqlMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/9 16:16
 * @Version 1.0
 */
public class SqlMapperTest {

    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> admin = mapper.getUserByLike("测");
        System.out.println(admin);
    }

    @Test
    public void deleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int i = mapper.deleteMore("1,2,8");
        System.out.println(i);
    }


    @Test
    public void getUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> t_user = mapper.getUserByTableName("t_user");
        System.out.println(t_user);

    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User(null,"李四","bbbbbb",20,"男","fjla@qq.com");
        int i = mapper.insertUser(user);
        System.out.println(i);
        System.out.println(user);

    }
}
