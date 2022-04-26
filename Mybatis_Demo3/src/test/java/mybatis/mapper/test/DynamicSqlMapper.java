package mybatis.mapper.test;

import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/14 15:06
 * @Version 1.0
 */
public class DynamicSqlMapper {
    /**
     * 动态SQL
     * 1. if标签：根据标签中test属性所对应的表达式判断标签中的内容是否需要拼接到SQL语句中
     * 2. where标签：当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉(内容后的不能去掉)
     *              当where标签中没有内容时，where标签没有任何效果，不会生成where关键字
     * 3. trim标签：
     *          prefix/suffix ：将trim标签中内容前面或者后面添加指定内容
     *          prefixOverrides/suffixOverrides : 将trim标签中内容前面或后面去掉指定内容
     *
     * 4. choose,when,otherwise相当于if……else  if……else
     * 5. foreach：循环操作。循环删除或者循环添加
     */
    @Test
    public void getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        mybatis.mapper.DynamicSqlMapper mapper = sqlSession.getMapper(mybatis.mapper.DynamicSqlMapper.class);
//        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null,"张三",null,null,null));
        List<Emp> empByCondition = mapper.getEmpByCondition(null);
        empByCondition.forEach(emp -> System.out.println(emp));
    }


    /**
     * 测试：choose,when,otherwise相当于if……else  if……else
     */
    @Test
    public void getEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        mybatis.mapper.DynamicSqlMapper mapper = sqlSession.getMapper(mybatis.mapper.DynamicSqlMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, null, 32, null, null));
        list.forEach(emp -> System.out.println(emp));
    }


    /**
     * 测试批量删除
     */
    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        mybatis.mapper.DynamicSqlMapper mapper = sqlSession.getMapper(mybatis.mapper.DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }




    /**
     * 测试批量添加
     */
    @Test
    public void insertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        mybatis.mapper.DynamicSqlMapper mapper = sqlSession.getMapper(mybatis.mapper.DynamicSqlMapper.class);
        List<Emp> empList = new ArrayList<>();
        Emp emp1 = new Emp(null,"a",10,"男","123qq.com");
        Emp emp2 = new Emp(null,"b",10,"男","123qq.com");
        Emp emp3 = new Emp(null,"c",10,"男","123qq.com");
        Emp emp4 = new Emp(null,"d",10,"男","123qq.com");
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        int i = mapper.insertMoreByList(empList);
        System.out.println(i);


    }
}
