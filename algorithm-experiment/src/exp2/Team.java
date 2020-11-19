package exp2;

public class Team {
	private String name;
	private int maxCount;
	private Teacher teacher;
	private Undergraduate[]  undergraList;
	private Graduate[] graList;

	//	有参构造方法
	public Team(String name,int maxCount){
		this.setName(name);
		this.setMaxCount(maxCount);
		undergraList = new Undergraduate[maxCount / 2];
		graList = new Graduate[maxCount / 2];
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setUndergraList(Undergraduate[] undergraList) {
		this.undergraList = undergraList;
	}

	public Undergraduate[] getUndergraList() {
		return undergraList;
	}

	public void setgraList(Graduate[] graList) {
		this.graList = graList;
	}

	public Graduate[] getGraList() {
		return graList;
	}

	//	一些方法描述团队行为
//	老师加入团队
	public void tJoinTeam(Teacher teacher){
		setTeacher(teacher);
		System.out.println(teacher.getName() + "老师加入" + getName());
	}
	//	老师离开团队
	public void tOutTeam(Teacher teacher){
		setTeacher(null);
		System.out.println(teacher.getName() + "老师离开" + getName());
	}
	//	一个本科生加入团队
	public void uJoinTeam(Undergraduate undergraduate){
		for(int i=0;i<undergraList.length;i++){
			if(undergraList[i] == null){
				undergraList[i] = undergraduate;
				System.out.println("本科生" + undergraduate.getName() + "加入" + getName());
				break;
			}
			if(i == undergraList.length-1){
				System.out.println("本科生人数已满");
			}
		}
	}

	//	一个本科生离开团队
	public void uOutTeam(Undergraduate undergraduate){
		for(int i=0;i<undergraList.length;i++){
			if(undergraList[i].equals(undergraduate)){
				undergraList[i] = null;
				System.out.println("本科生" + undergraduate.getName() + "离开" + getName());
				break;
			}
			if(i == undergraList.length-1){
				System.out.println("团队中没有这个本科生");
			}
		}
	}

	//	一个研究生加入团队
	public void gJoinTeam(Graduate graduate){
		for(int i=0;i<graList.length;i++){
			if(graList[i] == null){
				graList[i] = graduate;
				System.out.println("研究生" + graduate.getName() + "加入" + getName());
				break;
			}
			if(i == graList.length-1){
				System.out.println("研究生人数已满");
			}
		}
	}

	//	一个研究生离开团队
	public void gOutTeam(Graduate graduate){
		for(int i=0;i<graList.length;i++){
			if(graList[i].equals(graduate)){
				graList[i] = null;
				System.out.println("研究生" + graduate.getName() + "离开" + getName());
				break;
			}
			if(i == graList.length-1){
				System.out.println("团队中没有这个本科生");
			}
		}
	}
}
