package bigwork;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Car {

    private String carLicense;
    private String carType;
    private String onwer;
    private String onwerAddress;
    private String engineNumber;
    private String vehicleNumber;
    private String birthDay;
    private double trankCapacity;
    private double currentTrankCapacity;
    private String weigth;
    private String deadWeight;
    private Image image;
    private double strokeKilmeter;

    public String getDesigner(){
        // 补充姓名学号
        return "设计者：[姓名] 学号：[学号] 班级：[班级]";
    }
    double currentSpeed=0;
    double everySecondCount=1;
    public void addSpeed(double add){
        System.out.println("加速："+add);
        currentSpeed+=add;
    }
    public void drive(){
        currentSpeed=1;
        System.out.println("启动中：初始速度为:"+currentSpeed);
    }
    public void slowDown(double slow){
        System.out.println("减速："+slow);
        currentSpeed-=slow;
    }
    public void stop(){
        currentSpeed=0;
        System.out.println("停车");
    }
    public void currentTrankUse(){

        System.out.println("当前平均油耗为："+everySecondCount);
    }
    public void addTrank(double count){
        System.out.println("加油");
        currentTrankCapacity+=count;
    }
    public void reckonTravelableDistance(){
        System.out.println("估计可行驶距离："+currentTrankCapacity/everySecondCount);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carLicense='" + carLicense + '\'' +
                ", carType='" + carType + '\'' +
                ", onwer='" + onwer + '\'' +
                ", onwerAddress='" + onwerAddress + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", trankCapacity=" + trankCapacity +
                ", currentTrankCapacity=" + currentTrankCapacity +
                ", weigth='" + weigth + '\'' +
                ", deadWeight='" + deadWeight + '\'' +
                ", image=" + image +
                ", strokeKilmeter=" + strokeKilmeter +
                ", currentSpeed=" + currentSpeed +
                ", everySecondCount=" + everySecondCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.trankCapacity, trankCapacity) == 0 &&
                Double.compare(car.currentTrankCapacity, currentTrankCapacity) == 0 &&
                Double.compare(car.strokeKilmeter, strokeKilmeter) == 0 &&
                Double.compare(car.currentSpeed, currentSpeed) == 0 &&
                Double.compare(car.everySecondCount, everySecondCount) == 0 &&
                Objects.equals(carLicense, car.carLicense) &&
                Objects.equals(carType, car.carType) &&
                Objects.equals(onwer, car.onwer) &&
                Objects.equals(onwerAddress, car.onwerAddress) &&
                Objects.equals(engineNumber, car.engineNumber) &&
                Objects.equals(vehicleNumber, car.vehicleNumber) &&
                Objects.equals(birthDay, car.birthDay) &&
                Objects.equals(weigth, car.weigth) &&
                Objects.equals(deadWeight, car.deadWeight) &&
                Objects.equals(image, car.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carLicense, carType, onwer, onwerAddress, engineNumber, vehicleNumber, birthDay, trankCapacity, currentTrankCapacity, weigth, deadWeight, image, strokeKilmeter, currentSpeed, everySecondCount);
    }

    public Car(String carLicense, String carType, String onwer, String onwerAddress, String engineNumber, String vehicleNumber, String birthDay, double trankCapacity, double currentTrankCapacity, String weigth, String deadWeight, Image image, double strokeKilmeter) {
        this.carLicense = carLicense;
        this.carType = carType;
        this.onwer = onwer;
        this.onwerAddress = onwerAddress;
        this.engineNumber = engineNumber;
        this.vehicleNumber = vehicleNumber;
        this.birthDay = birthDay;
        this.trankCapacity = trankCapacity;
        this.currentTrankCapacity = currentTrankCapacity;
        this.weigth = weigth;
        this.deadWeight = deadWeight;
        this.image = image;
        this.strokeKilmeter = strokeKilmeter;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOnwer() {
        return onwer;
    }

    public void setOnwer(String onwer) {
        this.onwer = onwer;
    }

    public String getOnwerAddress() {
        return onwerAddress;
    }

    public void setOnwerAddress(String onwerAddress) {
        this.onwerAddress = onwerAddress;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getTrankCapacity() {
        return trankCapacity;
    }

    public void setTrankCapacity(double trankCapacity) {
        this.trankCapacity = trankCapacity;
    }

    public double getCurrentTrankCapacity() {
        return currentTrankCapacity;
    }

    public void setCurrentTrankCapacity(double currentTrankCapacity) {
        this.currentTrankCapacity = currentTrankCapacity;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(String deadWeight) {
        this.deadWeight = deadWeight;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getStrokeKilmeter() {
        return strokeKilmeter;
    }

    public void setStrokeKilmeter(double strokeKilmeter) {
        this.strokeKilmeter = strokeKilmeter;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double getEverySecondCount() {
        return everySecondCount;
    }

    public void setEverySecondCount(double everySecondCount) {
        this.everySecondCount = everySecondCount;
    }

    public void show() {
        toString();
        JFrame frame = new JFrame("图片显示");
        ImageIcon imgicon = new ImageIcon(image);
        frame.setSize(imgicon.getIconWidth(), imgicon.getIconHeight());
        JLabel label = new JLabel();
        label.setIcon(imgicon);
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
