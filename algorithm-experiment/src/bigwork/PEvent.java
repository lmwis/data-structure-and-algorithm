package bigwork;

import java.util.Objects;

public class PEvent {
    private Double x;
    private Double y;
    // 时间戳
    private long time;

    public PEvent(Double x, Double y, long time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public String getDesigner(){
        // 补充姓名学号
        return "设计者：[姓名] 学号：[学号] 班级：[班级]";
    }

    /**
     * 直角坐标系转极坐标系
     * @return
     */
    public REvent convertToREvent(){
        double r = Math.sqrt(x*x+y*y);
        double angle = Math.asin(y/r);
        return new REvent(r,angle,time);
    }

    /**
     * 到原点的距离
     * @return
     */
    public double distance(){
        return Math.sqrt(x*x+y*y);
    }

    /**
     * 两点间的距离
     * @param pevent
     * @return
     * @throws Exception
     */
    public double distance(PEvent pevent) throws Exception {
        if (time!=pevent.getTime())
            throw new Exception("不为同一时刻没有意义");
        return Math.sqrt(Math.abs((x-pevent.x)*(x-pevent.x)+(y-pevent.y)*(y-pevent.y)));
    }

    @Override
    public String toString() {
        return "PEvent{" +
                "x=" + x +
                ", y=" + y +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PEvent pEvent = (PEvent) o;
        return time == pEvent.time &&
                Objects.equals(x, pEvent.x) &&
                Objects.equals(y, pEvent.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, time);
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
