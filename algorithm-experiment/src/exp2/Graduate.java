package exp2;

public class Graduate {
	private String name;
	private int age;
	private String sex;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	
	public Graduate(String name,int age,String sex)
	{
		setName(name);
		setSex(sex);
		setAge(age);
	}
}
