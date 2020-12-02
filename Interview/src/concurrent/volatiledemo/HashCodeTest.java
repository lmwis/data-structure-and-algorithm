package concurrent.volatiledemo;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-12-02 21:38
 * @Version 1.0
 */
public class HashCodeTest {
    public static void main(String[] args) {
        Integer i = 128;
        Integer j = 128;
        Integer x = new Integer(128);
        Integer y = new Integer(128);
        System.out.println(i==j);
        System.out.println(x==y);
        System.out.println(i.equals(x));
        try{

        }catch (Throwable e){

        }
    }
}
