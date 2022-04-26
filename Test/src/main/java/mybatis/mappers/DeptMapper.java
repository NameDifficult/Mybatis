package mybatis.mappers;

import mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Mi
 * @Date 2022/3/15 17:24
 * @Version 1.0
 */
public interface DeptMapper {

    /**
     * 根据员工ID
     * 查询员工信息及其所属部门
     */
    Dept selectEmpAndDeptTwo(@Param("did") Integer did);


    /**
     * 根据部门编号查询部门的所有员工
     */
    Dept selectDeptAndEmp(@Param("deptName") String deptName);
}
