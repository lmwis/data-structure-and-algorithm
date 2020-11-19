package exp2;

public class TeamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher teacher =new Teacher ("张美玲","女",35);
		Undergraduate undergra1 = new Undergraduate("罗佳利",18,"女");
		Undergraduate undergra2 = new Undergraduate("小樊",19,"女");
		Undergraduate undergra3 = new Undergraduate("袁国宁",20,"男");
		Undergraduate undergra4 = new Undergraduate("托尼",19,"女");

		Graduate graduate1 = new Graduate("小芳",23,"女");
		Graduate graduate2 = new Graduate("小亮",22,"男");
		Graduate graduate3 = new Graduate("强子",23,"男");

		Team team = new Team("必胜团队",20);
		team.tJoinTeam(teacher);
		team.gJoinTeam(graduate1);
		team.gJoinTeam(graduate2);
		team.gJoinTeam(graduate3);
		team.uJoinTeam(undergra4);
		team.uJoinTeam(undergra1);
		team.uJoinTeam(undergra3);

		team.tOutTeam(teacher);
		team.uOutTeam(undergra1);
		team.gOutTeam(graduate3);
	}

}
