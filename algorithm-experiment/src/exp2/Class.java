package exp2;

public class Class {
	private String name;
	private int count;
	private Teacher teacher;
	private Committee[]  committee;
	private Classmates[] classmates;

	//	有参构造方法
	public Class(String name,int count){
		this.setName(name);
		this.setCount(count);
		committee = new Committee[5];
		classmates = new Classmates[(count-5) / 2];
	}

	private void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setCommittee(Committee[] committee) {
		this.committee = committee;
	}

	public Committee[] getCommittee() {
		return committee;
	}

	public void setClassmates(Classmates[] classmates) {
		this.classmates = classmates;
	}

	public Classmates[] getClassmates() {
		return classmates;
	}

	//	一些方法描述团队行为、
//	辅导员管理班级
	public void tManageClass(Teacher teacher){
		setTeacher(teacher);
		System.out.println(teacher.getName() + "老师管理" + getName());
	}

	//	学生竞选班委
	public void stuBeCommittee(Committee committee){
		System.out.println(committee.getName() + "是班委之一");
	}
}
