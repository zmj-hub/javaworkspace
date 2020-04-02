package BoxUtil;

import java.util.List;
import java.util.Map;

public class DomLoadModel {
    private double Q1;//较小四分位数  Q1的位置=（n+1）/4
    private double Q2;//中位数 Q2的位置=（n+1）/2　
    private double Q3;//较大四分位数 Q3的位置=3（n+1）/4
    private double min;//下限  下限=Q1-1.5IQR   四分位距IQR=Q3-Q1
    private double max;//上限  上限=Q3+1.5IQR
    private List<Map> errNums;//异常值   异常值的一个标准：异常值被定义为小于Q1－1.5IQR或大于Q3＋1.5IQR的值 （即大于上限或小于下限的值）

    public DomLoadModel() {
    }

    public DomLoadModel(double q1, double q2, double q3, double min, double max, List<Map> errNums) {
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        this.min = min;
        this.max = max;
        this.errNums = errNums;
    }

    public double getQ1() {
        return Q1;
    }

    public void setQ1(double q1) {
        Q1 = q1;
    }

    public double getQ2() {
        return Q2;
    }

    public void setQ2(double q2) {
        Q2 = q2;
    }

    public double getQ3() {
        return Q3;
    }

    public void setQ3(double q3) {
        Q3 = q3;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public List<Map> getErrNums() {
        return errNums;
    }

    public void setErrNums(List<Map> errNums) {
        this.errNums = errNums;
    }

    @Override
    public String toString() {
        return "DomLoadModel{" +
                "Q1=" + Q1 +
                ", Q2=" + Q2 +
                ", Q3=" + Q3 +
                ", min=" + min +
                ", max=" + max +
                ", errNums=" + errNums +
                '}';
    }
}
