package homework.file;

public class Test {
    public static void main(String[] args) {
        StudentDeal deal=new StudentDeal();
        System.out.println("===�ļ�������===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===����===");
		Student stu=deal.findStuByNum("201806060527");
		System.out.println(stu.name);
        System.out.println("===���ҽ���===");
		Student newstu1=new Student("201906060125","ǧ����","��","6-542","���ѧԺ","����192��");
        Student newstu2=new Student("201706070811","���γ�","Ů","5-332","�ṤѧԺ","�Ṥ174��");
        System.out.println("===���===");
        deal.addStudent(newstu1);
        System.out.println("===��ӽ���===");
        System.out.println("===�ļ�������===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===ɾ��===");
        deal.delStuByNum("201806060313");
        System.out.println("===ɾ������===");
        System.out.println("===�ļ�������===");
        deal.showInfos();
        System.out.println("===============");
        System.out.println("===����===");
        deal.updateStu(newstu2);
        System.out.println("===����===");
        System.out.println("===�ļ�������===");
        deal.showInfos();
        System.out.println("===============");
    }
}
