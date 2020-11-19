package exp2;

public class BusTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver=new Driver("张三","男",35,"d001");
		Passengers pass1=new Passengers("罗佳利",17,"美少女");
		Passengers pass2=new Passengers("向东平",20,"男");
		Passengers pass3=new Passengers("肖嘉庆",20,"男");
		Passengers pass4=new Passengers("小红",18,"女");

		Bus bus= new Bus("陕8888Z","比亚迪", 50);
		bus.setDriver(driver);
		bus.setNum("336");

		bus.upOnePass(pass1);
		bus.upOnePass(pass2);
		bus.upOnePass(pass3);
		bus.upOnePass(pass4);
		System.out.println("当前乘客数量"+bus.getCurrentCount());
		bus.downOnePass(pass2);
		bus.downOnePass(pass3);
		System.out.println("当前乘客数量"+bus.getCurrentCount());

		bus.printAttributes(bus);
	}

}
