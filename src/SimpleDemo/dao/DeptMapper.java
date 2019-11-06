package SimpleDemo.dao;

import SimpleDemo.bean.Dept;

public interface DeptMapper {
	public Dept getDeptById(Integer id);
	
	public Dept getDeptByIdPlus(Integer id);
	
	public Dept getDeptByIdStep(Integer deptID);
}
