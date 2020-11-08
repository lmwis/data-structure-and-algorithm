package bigwork;

import java.util.Objects;

public class REvent {
    private Double r;
    private Double angle;
    // 时间戳
    private long time;

    public REvent(Double r, Double angle, long time) {
        this.r = r;
        this.angle = angle;
        this.time = time;
    }

    public String getDesigner(){
        // 补充姓名学号
        return "设计者：[姓名] 学号：[学号] 班级：[班级]";
    }

    /**
     * 极坐标系转直角坐标系
     * @return
     */
    public PEvent convertToPEvent(){
        double x = r*Math.cos(angle);
        double y = r*Math.sin(angle);
        return new PEvent(x,y,time);
    }

    /**
     * 到远点的距离
     * @return
     */
    public double distance(){
        return r;
    }

    /**
     * 两点间的距离
     * @param revent
     * @return
     * @throws Exception
     */
    public double distance(REvent revent) throws Exception {
        if (time!=revent.getTime())
            throw new Exception("不为同一时刻没有意义");
        return Math.sqrt(r*r+revent.getR()*revent.getR()-2*r*revent.getR()*Math.cos(angle-revent.getAngle()));
    }

    @Override
    public String toString() {
        return "REvent{" +
                "r=" + r +
                ", angle=" + angle +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        REvent rEvent = (REvent) o;
        return time == rEvent.time &&
                Objects.equals(r, rEvent.r) &&
                Objects.equals(angle, rEvent.angle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, angle, time);
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
