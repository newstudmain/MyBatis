package SimpleDemo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Emp_Dept {

	private BigDecimal id;//ID
	private String lastName;//LAST_NAME 
	private String firstName;//FIRST_NAME
	private BigDecimal salary;//SALARY
	private Date startDate;//START_DATE startDate
	private Dept Dept;
	
	public Emp_Dept() {
		super();
	}

	public Emp_Dept(BigDecimal id, String lastName, String firstName, BigDecimal salary, Date startDate,
			Dept dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.startDate = startDate;
		Dept = dept;
	}

	public Emp_Dept(BigDecimal id, String lastname, String firstname, BigDecimal salary, Date date) {
		super();
		this.id = id;
		this.lastName = lastname;
		this.firstName = firstname;
		this.salary = salary;
		this.startDate = date;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return startDate;
	}

	public void setDate(Date date) {
		this.startDate = date;
	}

	
	public Dept getDept() {
		return Dept;
	}

	public void setDept(Dept dept) {
		Dept = dept;
	}

	@Override
	public String toString() {
		return "Emp_Dept [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", salary=" + salary
				+ ", startDate=" + startDate + ", Dept=" + Dept + "]";
	}

	
}
