package bigwork;

/**
 * @Description: 大数相乘
 * @Author: lmwis
 * @Date 2020-12-22 15:23
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        MyBigInteger num1 = new MyBigInteger("111111");
        MyBigInteger num2 = new MyBigInteger("0");
        MyBigInteger mul = num1.mul(num2);
        mul.show();
    }
}
class MyBigInteger{

    int[] value;
    String num="";
    MyBigInteger(String num){
        this.num = num;
        value = new int[num.length()];
        for(int i=0;i<num.length();i++){
            value[i] = Integer.parseInt(num.charAt(i)+"");
        }
    }
    MyBigInteger(int[] value){
        this.value = value;
        for(int i=0;i<value.length-1;i++){
            num+=value[i];
        }
    }

    public MyBigInteger mul(MyBigInteger num){
        int[] numChar = num.value;
        int[] res = new int[value.length+numChar.length];
        // AB*CD = AC()BD
        for(int i=0;i<value.length;i++){
            for(int j=0;j<numChar.length;j++){
                res[i+j] +=  value[i] *  numChar[j];
            }
        }
        // 进位
        int flag;
        for(int j=res.length-1;j>0;j--){
            flag = res[j]/10;
            res[j-1]+=flag;

            res[j] = res[j]%10;
        }
        return new MyBigInteger(res);
    }
    public void show(){
        System.out.println(this.num);
    }

}
