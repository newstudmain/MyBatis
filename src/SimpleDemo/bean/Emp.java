package SimpleDemo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Emp {

	private BigDecimal id;//ID
	private String lastName;//LAST_NAME 
	private String firstName;//FIRST_NAME
	private BigDecimal salary;//SALARY
	private Date startDate;//START_DATE startDate
	
	public Emp() {
		super();
	}

	public Emp(BigDecimal id, String lastname, String firstname, BigDecimal salary, Date date) {
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

	@Override
	public String toString() {
		return "Emp [id=" + id + ", lastname=" + lastName + ", firstname=" + firstName + ", salary=" + salary
				+ ", stratdate=" + startDate + "]";
	}
	
}
