package exp2;

public class Bus {
	private String busId;  //车牌号
	private String num;   //车的几号路
	private String brand;  // 车的品牌
	private int maxCount;
	private int currentCount;
	private Driver driver;
	private Passengers[] passList;

	//	有参构造方法
	public Bus(String busId,String brand,int maxCount)
	{
		this.setBrand(brand);
		this.setMaxCount(maxCount);
		this.setbusId(busId);
		passList=new Passengers[maxCount];
	}

	public void setbusId(String busId) {
		this.busId = busId;
	}

	public String getbusId() {
		return busId;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNum() {
		return num;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setPassList(Passengers[] passList) {
		this.passList = passList;
	}

	public Passengers[] getPassList() {
		return passList;
	}


	//	无参构造方法
	public void startBus() {
		System.out.println("汽车开始工作了.......");
	}

	//乘客上车的方法
	public void upPasses(Passengers[] upPassList)
	{
		for(int i=0;i<upPassList.length;i++)
		{
			upOnePass(upPassList[i]);
		}
	}

	public void upOnePass(Passengers pass)
	{
		if(currentCount==maxCount)
		{
			System.out.println("请等下一趟");
		}
		else
		{
			currentCount++;
			for(int i=0;i<passList.length;i++)
			{
				if(passList[i]==null)
				{
					passList[i]=pass;
					System.out.println(pass.getName()+"已上车");
					break;
				}
			}
		}
	}
	//		乘客下车的方法
	public void downOnePass(Passengers pass)
	{
		for(int i=0;i<passList.length;i++)
		{
			if(passList[i]!=null)
			{
				if(passList[i].equals(pass))
				{
					passList[i]=null;
					System.out.println(pass.getName()+"已下车");
					currentCount--;
					break;
				}
			}
		}
	}

	public void downPasses(Passengers[] downPassList)
	{
		for(int i=0;i<downPassList.length;i++)
		{
			downOnePass(downPassList[i]);
		}
	}

	//		打印所有属性
	public void printAttributes(Bus bus){
		System.out.println("车牌号：" + getbusId());
		System.out.println("品牌：" + getBrand());
		System.out.println("车路线："+getNum());
		System.out.println("最大载客量：" + getMaxCount());
		System.out.println("当前乘客数："+getCurrentCount());
	}
}


