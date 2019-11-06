package SimpleDemo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import SimpleDemo.bean.Emp;
import SimpleDemo.bean.Emp_Dept;
import SimpleDemo.bean.Student;

public interface EmpMapper {

	public Emp getEmpById(Integer id);
	public Emp getEmpByIdAndlastName(Integer id,String lastName);
	
	public void addEmp(Emp emp);
	public void addStu(Student stu);
	public void updateEmp(Emp emp);
	public void deleteEmpById(Integer id);
	
	public List<Emp> getEmpBytitle(String title);
	public Map<String,Object> getEmpByMap(Integer id);
	@MapKey("id")
	public Map<Integer,Emp> getEmpByTitleMap(String title);
	
	public Emp_Dept getEmpDeptById(Integer id);
	
	public Emp_Dept getEmpDeptByIdStep(Integer id);
	
	public List<Emp> getEmpByDeptID(Integer deptID);

	
}
