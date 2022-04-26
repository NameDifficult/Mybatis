package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/14 14:55
 * @Version 1.0
 */
public interface DynamicSqlMapper {

    /**
     * 多条件 查询
     */
    List<Emp> getEmpByCondition(Emp emp);


    /**
     * 测试 choose ， when ， otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);


    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("integers") Integer[] integers);


    /**
     * 批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}



