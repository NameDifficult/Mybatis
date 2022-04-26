package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author Mi
 * @Date 2022/3/9 15:06
 * @Version 1.0
 */
public interface SelectMapper {
    /**
     * 根据ID查询用户信息
     */
    User getUserByID(@Param("id") Integer id);


    /**
     * 查询所有的用户信息
     * @return 返回用list集合接收
     */
    List<User> getAllUser();


    /**
     * 根据ID查询用户的所有信息，并以map集合接收
     * 适用于查询到的数据不能封装到一个实体类中。如多表查询的信息
     * @param id
     * @return
     */
    @MapKey("id")
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);
}
