package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/9 16:10
 * @Version 1.0
 *
 * 特殊SQL语句查询
 */
public interface SqlMapper {

    /**
     * 根据用户名进行模糊查询
     * @param username
     * @return
     */
    List<User> getUserByLike(@Param("username") String username);


    /**
     * 批量删除
     * @return
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 查询指定表中的数据，动态设置表名
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);


    /**
     * 添加用户信息
     * 并获取自动递增的主键
     */
    int insertUser(User user);
}
