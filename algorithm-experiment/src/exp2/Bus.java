package exp2;

public class Bus {
	private String busId;  //���ƺ�
	private String num;   //���ļ���·
	private String brand;  // ����Ʒ��
	private int maxCount;
	private int currentCount;
	private Driver driver;
	private Passengers[] passList;

	//	�вι��췽��
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


	//	�޲ι��췽��
	public void startBus() {
		System.out.println("������ʼ������.......");
	}

	//�˿��ϳ��ķ���
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
			System.out.println("�����һ��");
		}
		else
		{
			currentCount++;
			for(int i=0;i<passList.length;i++)
			{
				if(passList[i]==null)
				{
					passList[i]=pass;
					System.out.println(pass.getName()+"���ϳ�");
					break;
				}
			}
		}
	}
	//		�˿��³��ķ���
	public void downOnePass(Passengers pass)
	{
		for(int i=0;i<passList.length;i++)
		{
			if(passList[i]!=null)
			{
				if(passList[i].equals(pass))
				{
					passList[i]=null;
					System.out.println(pass.getName()+"���³�");
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

	//		��ӡ��������
	public void printAttributes(Bus bus){
		System.out.println("���ƺţ�" + getbusId());
		System.out.println("Ʒ�ƣ�" + getBrand());
		System.out.println("��·�ߣ�"+getNum());
		System.out.println("����ؿ�����" + getMaxCount());
		System.out.println("��ǰ�˿�����"+getCurrentCount());
	}
}


