package mybatis.mappers.test;

import mybatis.mappers.DeptMapper;
import mybatis.mappers.EmpMapper;
import mybatis.pojo.Dept;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author Mi
 * @Date 2022/3/15 17:36
 * @Version 1.0
 */
public class EmpTest {
    @Test
    public void selectEmpAndDept() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("testMybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectEmpAndDept(3);
        System.out.println(emp);
    }


    @Test
    public void selectDeptAndEmp() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("testMybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept a = mapper.selectDeptAndEmp("A");
        System.out.println(a);
    }
}
