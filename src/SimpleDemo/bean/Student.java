package SimpleDemo.bean;

public class Student {
	private int id;
	private String name;
	private String password;
	private int age;
	private String gender;
	
	public Student() {}

	public Student(int id, String name, String password, int age, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", gender=" + gender
				+ "]";
	}
	
}
