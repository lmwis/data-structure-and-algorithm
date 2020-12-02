package exp4;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-06 19:44
 * @Version 1.0
 */
public class OrderGenerator {

    public static void main(String[] args) {
        System.out.println(generateOrderId("admin"));
    }

    /**
     * D+年份+月份+日期+时钟+分钟+秒钟+系统用户账号
     * @param count
     * @return
     */
    public static String generateOrderId(String count){
        StringBuffer stringBuffer = new StringBuffer("D");
        Calendar instance = Calendar.getInstance();
//        stringBuffer.append(instance.get(Calendar.YEAR));
//        stringBuffer.append(instance.get(Calendar.MONTH)+1);
//        stringBuffer.append(instance.get(Calendar.DAY_OF_MONTH));
        stringBuffer.append(instance.get(Calendar.HOUR_OF_DAY));
//        stringBuffer.append(instance.get(Calendar.MINUTE));
//        stringBuffer.append(instance.get(Calendar.SECOND));
        stringBuffer.append(count);
        return stringBuffer.toString();
    }
}
