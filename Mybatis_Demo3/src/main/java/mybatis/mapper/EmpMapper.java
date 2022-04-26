package mybatis.mapper;

import mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/11 9:31
 * @Version 1.0
 */
public interface EmpMapper {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Emp> getAllEmpOld();

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Emp> getAllEmp();


    /**
     * 查询员工以及员工所对应的部门信息
     * 级联属性查询
     */
    List<Emp> getEmpAndDept(@Param("id") Integer id );


    /**
     * 查询员工以及员工所对应的部门信息
     * association标签：专门处理多对一的映射关系
     */
    List<Emp> getEmpAndDeptTwo(@Param("id") Integer id );



    /**
     * 查询员工以及员工所对应的部门信息
     * 分布查询：
     *          第一步 ： 查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("id") Integer id );




    /**
     * 和上面不是一个分布查询
     * 获取部门以及部门中所有的员工信息
     *  运用分布查询
     *          第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
