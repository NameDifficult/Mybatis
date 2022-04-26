import mybatis.mapper.DeptMapper;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/11 9:38
 * @Version 1.0
 */
public class ResultMapTest {
    /**
     *  解决字段名和属性名不一致的情况
     *  a：为字段名起别名
     *  b：设置全局配置，将_自动映射为驼峰 config.xml中 <settings>
     *                                                      <setting name="mapUnderscoreToCamelCase" value="true"/>
     *                                            </settings>
     *
     *  c：通过resultMap来设置自定义的映射关系
     *  <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"></id>
     *         <result property="empName" column="emp_name"></result>
     *         <result property="age" column="age"></result>
     *         <result property="sex" column="sex"></result>
     *         <result property="email" column="email"></result>
     *  </resultMap>
     *  <select id="getAllEmp" resultMap="empResultMap">
     *         select * from t_emp;
     *  </select>
     *
     */



    @Test
    public void getAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(emp -> System.out.println(emp));
    }


    /**
     * 处理多对一的映射关系：
     *   a: 级联属性赋值
     *   b：association标签：专门处理多对一的映射关系
     *   c：分布查询
     */
    @Test
    public void getEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getEmpAndDept(1);
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void getEmpAndDeptTwo(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getEmpAndDeptTwo(2);
        list.forEach(emp -> System.out.println(emp));
    }


    /**
     * 分布查询
     * 分布查询的优点：
     *              1. 可以实现延迟加载，但是必须在核心配置文件中设置全局配置信息（把下划线映射为驼峰的标签）
     *              2. lazyLoadingEnabled：延迟加载的全局开关。当开启时，所有关联对象、分布查询都会延迟加载（延时加载时要开启）
     *              3. aggressiveLazyLoading：当开始时，任何方法的调用都会加载该对象的所有属性。否则，每个属性都会按需加载（延时加载时要关闭）
     *              4.
     */
    @Test
    public void getEmpAndDeptByStepTwo(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
        System.out.println("------------------------------------------------");
        System.out.println(emp.getDept());
    }


    /**
     * 处理一对多的映射关系
     *  1. connection
     */
    @Test
    public void getDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }


    /**
     * 处理一对多的映射关系
     *  2. 分布查询
     */
    @Test
    public void getDeptAndEmpByStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(deptAndEmp.getDeptName());
        System.out.println("------------------------------------------------");
        System.out.println(deptAndEmp.getEmps().get(0));
    }

}
