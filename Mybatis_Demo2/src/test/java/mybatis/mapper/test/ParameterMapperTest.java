package mybatis.mapper.test;

import mybatis.mapper.ParameterMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Mi
 * @Date 2022/3/8 15:23
 * @Version 1.0
 */
public class ParameterMapperTest {
    /**
     * mybatis获取参数的两种方式：${} / #{}
     * ${}本质是字符串拼接 ：可能造成SQL注入，需要手动拼接
     * #{}本质是占位符赋值
     */

    @Test
    public void selectByUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(6,"admin2","123456",0,null,null);
        User user1 = mapper.selectByUser(user);
        System.out.println(user1);
    }


    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(null,"admin","654321",12,"女","la@qq.com");
        int i = mapper.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin2", "123456");
        System.out.println(user);
    }

    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin2");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }


    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin2", "123456");
        System.out.println(user);
    }


    @Test
    public void selectUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.selectUserByUsername("张三");
        System.out.println(user);
    }


    @Test
    public void getAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.selectAllUser();
        allUser.forEach(user -> System.out.println(user));
    }


}
