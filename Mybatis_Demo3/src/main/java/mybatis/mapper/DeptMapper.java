package mybatis.mapper;

import mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/11 9:31
 * @Version 1.0
 */
public interface DeptMapper {

    /**
     * 查询员工以及员工所对应的部门信息
     * 分布查询：
     *          第二步 ： 通过did查询员工所对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);


    /**
     * 获取部门以及部门中所有的员工信息
     *  运用collection
     */
    Dept getDeptAndEmp(@Param("id")Integer did);



    /**
     * 获取部门以及部门中所有的员工信息
     *  运用分布查询
     *          第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did")Integer did);
}
