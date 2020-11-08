package bigwork;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Driver {

    private String name;
    private String nationality;
    private String address;
    private String birthday;
    private String firstLicenseDate;
    private String permitModel;
    private String validDate;
    private String validTime;
    private Image image;
    private String recodeId;

    public Driver(String name, String nationality, String address, String birthday, String firstLicenseDate, String permitModel, String validDate, String validTime, Image image, String recodeId) {
        this.name = name;
        this.nationality = nationality;
        this.address = address;
        this.birthday = birthday;
        this.firstLicenseDate = firstLicenseDate;
        this.permitModel = permitModel;
        this.validDate = validDate;
        this.validTime = validTime;
        this.image = image;
        this.recodeId = recodeId;
    }

    public String getDesigner() {
        // 补充姓名学号
        return "设计者：[姓名] 学号：[学号] 班级：[班级]";
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", firstLicenseDate='" + firstLicenseDate + '\'' +
                ", permitModel='" + permitModel + '\'' +
                ", validDate='" + validDate + '\'' +
                ", validTime='" + validTime + '\'' +
                ", image=" + image +
                ", recodeId='" + recodeId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name) &&
                Objects.equals(nationality, driver.nationality) &&
                Objects.equals(address, driver.address) &&
                Objects.equals(birthday, driver.birthday) &&
                Objects.equals(firstLicenseDate, driver.firstLicenseDate) &&
                Objects.equals(permitModel, driver.permitModel) &&
                Objects.equals(validDate, driver.validDate) &&
                Objects.equals(validTime, driver.validTime) &&
                Objects.equals(image, driver.image) &&
                Objects.equals(recodeId, driver.recodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality, address, birthday, firstLicenseDate, permitModel, validDate, validTime, image, recodeId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstLicenseDate() {
        return firstLicenseDate;
    }

    public void setFirstLicenseDate(String firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
    }

    public String getPermitModel() {
        return permitModel;
    }

    public void setPermitModel(String permitModel) {
        this.permitModel = permitModel;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getRecodeId() {
        return recodeId;
    }

    public void setRecodeId(String recodeId) {
        this.recodeId = recodeId;
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
