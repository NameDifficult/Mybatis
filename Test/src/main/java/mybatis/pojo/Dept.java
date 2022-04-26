package mybatis.pojo;

import java.util.List;

/**
 * @Author Mi
 * @Date 2022/3/15 17:18
 * @Version 1.0
 */
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> list;
    private Integer count;

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }


    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", list=" + list +
                ", count=" + count +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }
}
