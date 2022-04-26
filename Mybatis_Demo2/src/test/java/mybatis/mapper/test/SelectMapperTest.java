package mybatis.mapper.test;

import mybatis.mapper.SelectMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Author Mi
 * @Date 2022/3/9 15:11
 * @Version 1.0
 */
public class SelectMapperTest {
    @Test
    public void getUserByID(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserByID(9);
        System.out.println(user);
    }


    @Test
    public void getAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(user -> System.out.println(user));
    }

    @Test
    public void getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(23);
        System.out.println(userByIdToMap);
        Map<String , Object> map = (Map<String, Object>) userByIdToMap.get(3);
        for (Map.Entry<String,Object> entry : map.entrySet()){
            System.out.println(entry.getKey() + "  = " + entry.getValue());
        }
    }
}
