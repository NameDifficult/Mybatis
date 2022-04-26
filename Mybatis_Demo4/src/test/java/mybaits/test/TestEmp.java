package mybaits.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/15 14:48
 * @Version 1.0
 */
public class TestEmp {
    @Test
    public void selectByExample(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample empExample = new EmpExample();
        /**
         * 查询所有数据
         */
//        List<Emp> empList = mapper.selectByExample(null);
//        empList.forEach(emp -> System.out.println(emp));

        /**
         * 根据用户名查询数据
         */
//        EmpExample empExample = new EmpExample();
//        empExample.createCriteria().andEmpNameEqualTo("张三");
//        List<Emp> empList = mapper.selectByExample(empExample);
//        empList.forEach(emp -> System.out.println(emp));

        /**
         * 模糊查询
         */
//        EmpExample empExample = new EmpExample();
//        empExample.createCriteria().andEmpNameLike("%四%");
//        List<Emp> empList = mapper.selectByExample(empExample);
//        empList.forEach(emp -> System.out.println(emp));

        /**
         * 多条件查询
         */
        empExample.createCriteria().andEmpNameEqualTo("男").andAgeEqualTo(23);
        empExample.or().andEmpNameEqualTo("男").andAgeEqualTo(32);
        empExample.or().andEmpNameEqualTo("女").andAgeEqualTo(32);
        List<Emp> empList = mapper.selectByExample(empExample);
        empList.forEach(emp -> System.out.println(emp));





    }

}
