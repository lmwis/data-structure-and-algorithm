package bigwork;

import java.awt.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-08 17:32
 * @Version 1.0
 */
public class SystemTest {
    public static void main(String[] args) {
        Toolkit  imgtool= Toolkit.getDefaultToolkit();
        Image driverImage=imgtool.getImage("zhangsan.jpg");
        Driver driver = new Driver("张三", "中国",
                "北京","1984日10月12日",
                "2004日5月10日","机动车",
                "2034日5月10日","30年",driverImage,"x001");
        Image carImage=imgtool.getImage("waiguan.jpg");
        Car car = new Car("XG2001","机动车",driver.getName()
                ,driver.getAddress(),"12345","432123"
                ,"2004日5月10日",20,5,"10kg"
                ,"5kg",carImage,100);
        // 启动汽车
        car.drive();
        // 加速
        car.addSpeed(1);
        // 减速
        car.slowDown(1);
        // 停车
        car.stop();
        // 加油
        car.addTrank(10);
        car.currentTrankUse();
        car.reckonTravelableDistance();
        driver.show();
        car.show();
    }
}
