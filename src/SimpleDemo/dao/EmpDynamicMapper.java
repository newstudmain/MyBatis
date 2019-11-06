package SimpleDemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import SimpleDemo.bean.Emp;

public interface EmpDynamicMapper {

	public List<Emp> getEmpByConditionIf(Emp emp);
	public List<Emp> getEmpByConditionTrim(Emp emp);
	public List<Emp> getEmpByConditionChoose(Emp emp);
	
	public int getEmpByConditionSet(Emp emp);
	public void getEmpByConditionSet_Trim(Emp emp);
	
	public List<Emp> getEmpByConditionForeach(@Param("fils")List<Integer> flis);
	
	public void addEmps(@Param("emps")List<Emp> emps);
	public List<Emp> getEmpInnerparameter(Emp emp);
	public List<Emp> getEmpSQL();
}
