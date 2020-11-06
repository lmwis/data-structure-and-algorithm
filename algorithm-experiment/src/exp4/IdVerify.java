package exp4;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-06 19:12
 * @Version 1.0
 */
public class IdVerify {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.print("请输入身份证号码：");
        String id = input.next();
        System.out.println();
        if(id.isEmpty()|| id.length()!=18){
            throw new Exception("身份证号码不合法");
        }else {
            if(id.startsWith("610112") && id.charAt(id.length()-2)%2==1){
                System.out.println("是陕西省西安市未央区的男性");
            }else{
                System.out.println("不是陕西省西安市未央区的男性");
            }
        }

    }
}
