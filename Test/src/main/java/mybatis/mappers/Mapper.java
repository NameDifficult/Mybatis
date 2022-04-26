package mybatis.mappers;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/9 11:56
 * @Version 1.0
 */
public interface Mapper {
    int insertUser(User user);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User selectForOne(@Param("username")String username,@Param("password")String password);


    List<User> selectListUser(@Param("username")String username);
}
