package mybatis.mapper;

import mybatis.pojo.User;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/7 16:33
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 根据ID查询单条用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}
