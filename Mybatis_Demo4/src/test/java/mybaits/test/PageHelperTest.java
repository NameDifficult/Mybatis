package mybaits.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/15 12:14
 * @Version 1.0
 */
public class PageHelperTest {
    @Test
    public void testPageHelper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        /*
         * 分页
         * pageNum：当前页码
         * pageSize：每页数据条数
         * 需要在查询功能前使用分页
         * 返回的page对象中有总页码，总记录数等数据
         */
//        Page<Object> objects = PageHelper.startPage(1, 3);
        PageHelper.startPage(1, 3);
        List<Emp> empList = mapper.selectByExample(null);
        //navigatePages：分页栏数。如 1 2 3 4 5 。则是5
        PageInfo<Emp> page = new PageInfo<>(empList,3);
        empList.forEach(emp -> System.out.println(emp));
        System.out.println(page);
        /**
         * pageNum：当前页页码
         * pageSize：每页显示的条数
         * Size：当前页显示的真实条数
         * total：总记录数
         * pages：总页数
         * prePage：上一页的页码
         * nextPage：下一页的页码
         * isFirstPage/isLastPage：是否是第一页/是否是最后一页
         * hasPreviousPage/hasNextPage：是否存在上一页/是否存在下一页
         * navigatePages：导航分页的页码数
         * navigatePageNums：导航分页的页码  [2,3,4,5,6]
         */
    }
}
