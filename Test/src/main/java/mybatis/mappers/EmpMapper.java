package mybatis.mappers;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/15 17:23
 * @Version 1.0
 */
public interface EmpMapper {

    /**
     * 根据员工ID
     * 查询员工信息及其所属部门
     */
    Emp selectEmpAndDept(@Param("eid") Integer eid);


    /**
     * 根据部门编号查询部门的所有员工
     */
    List<Emp> selectDeptAndEmpTwo(@Param("did") Integer did);

    /**
     * 根据部门编号查询部门员工总数
     */
    Integer selectEmpCount(@Param("did") Integer did);
}
