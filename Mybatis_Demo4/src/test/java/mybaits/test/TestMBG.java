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
 * @Date 2022/3/15 10:53
 * @Version 1.0
 */
public class TestMBG {
    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        List<Emp> empList = mapper.selectByExample(null);
//        empList.forEach(emp -> System.out.println(emp));
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("李四").andAgeEqualTo(12);
        empExample.or().andDidIsNotNull();
        List<Emp> emps = mapper.selectByExample(empExample);
        emps.forEach(emp -> System.out.println(emp));

    }
}
