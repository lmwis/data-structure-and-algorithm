package exp2;
public class Driver {
	private String name;
	private String sex;
	private int age;
	private String driverNum;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setDriverNum(String driverNum) {
		this.driverNum = driverNum;
	}
	public String getDriverNum() {
		return driverNum;
	}

	public Driver(String name,String sex,int age,String driverNum)
	{
		setName(name);
		setSex(sex);
		setAge(age);
		setDriverNum(driverNum);
	}
}
