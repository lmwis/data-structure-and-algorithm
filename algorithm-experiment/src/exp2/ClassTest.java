package exp2;

public class ClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher teacher =new Teacher ("杨婧","女",28);
		Committee committee1 = new Committee("卢昭熙",22,"男");
		Committee committee2 = new Committee("刘国安",21,"男");
		Committee committee3 = new Committee("樊子睿",19,"女");
		Committee committee4 = new Committee("孙露茜",20,"女");
		Committee committee5 = new Committee("赵子龙",20,"男");

		Classmates classmates1 = new Classmates("小芳",23,"女");
		Classmates classmates2 = new Classmates("小亮",22,"男");
		Classmates classmates3 = new Classmates("强子",23,"男");


		Class class1 = new Class("计算机181班",38);

		class1.tManageClass(teacher);
		class1.stuBeCommittee(committee1);
		class1.stuBeCommittee(committee2);
		class1.stuBeCommittee(committee3);
		class1.stuBeCommittee(committee4);
		class1.stuBeCommittee(committee5);
	}

}
