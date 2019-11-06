package SimpleDemo.bean;

import java.math.BigDecimal;
import java.util.List;

public class Dept {
	
	private BigDecimal id;
	private String name;
	private BigDecimal regionId;
	
	private List<Emp> emps;
	
	public Dept() {
		super();
	}

	

	public Dept(BigDecimal id, String name, BigDecimal regionId) {
		super();
		this.id = id;
		this.name = name;
		this.regionId = regionId;
	}


	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getRegionId() {
		return regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", regionId=" + regionId + ", emps=" + emps + "]";
	}

}
