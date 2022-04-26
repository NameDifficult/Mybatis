package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Mi
 * @Date 2022/3/8 15:15
 * @Version 1.0
 */
public interface ParameterMapper {

    /**
     * 查找时传入的参数是实体
     * @param user
     * @return
     */
    User selectByUser(User user);

    /**
     * 添加
     * 当传入的参数是实体
     */
    int insertUser(User user);

    /**
     * 验证登录，使用@param
     * 使用了@param后，mybatis会将@param里面的值作为map的键
     */
    User checkLoginByParam(@Param("username")String username,@Param("password")String password);


    /**
     * 验证登录，使用自定义map
     */
    User checkLoginByMap(Map<String,Object> map);


    /**
     * 验证登录
     */
    User checkLogin(String username,String password);

    /**
     * 根据用户名查询用户信息
     */
    User selectUserByUsername(String username);

    /**
     * 查询所有员工信息
     */
    List<User> selectAllUser();
}
