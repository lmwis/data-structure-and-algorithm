package homework.file;

public class Test {
    public static void main(String[] args) {
        StudentDeal deal=new StudentDeal();
        System.out.println("===文件中数据===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===查找===");
		Student stu=deal.findStuByNum("201806060527");
		System.out.println(stu.name);
        System.out.println("===查找结束===");
		Student newstu1=new Student("201906060125","千巩义","男","6-542","电控学院","电信192班");
        Student newstu2=new Student("201706070811","向梦晨","女","5-332","轻工学院","轻工174班");
        System.out.println("===添加===");
        deal.addStudent(newstu1);
        System.out.println("===添加结束===");
        System.out.println("===文件中数据===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===删除===");
        deal.delStuByNum("201806060313");
        System.out.println("===删除结束===");
        System.out.println("===文件中数据===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===更新===");
        deal.updateStu(newstu2);
        System.out.println("===结束===");
        System.out.println("===文件中数据===");
        deal.showInfos();
        System.out.println("===============");
    }
}
