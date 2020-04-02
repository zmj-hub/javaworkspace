package IsolationTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IsolationTreeTool {

    private int maxTreeNum = 100;
    private int maxSampling = 256;
    private double factor = 0.6f;
    private String fieldName;

    private List<Map<String, Object>> normal;
    private List<Map<String, Object>> abnormal;

    private IsolationForest forest;

    public IsolationTreeTool() {
    }

    public IsolationTreeTool(String fieldName) {
        this.fieldName = fieldName;
    }

    public IsolationTreeTool(int maxTreeNum, int maxSampling) {
        this.maxTreeNum = maxTreeNum;
        this.maxSampling = maxSampling;
    }


    public List<List<Map<String, Object>>> timeSeriesAnalyse(List<Map<String, Object>> list) {

        double[] data = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
//            data[i] = (Double) list.get(i).get(this.fieldName);
            data[i] = Double.parseDouble(list.get(i).get(this.fieldName).toString()) ;
        }
//        this.results = new ArrayList<Result>();
        this.abnormal = new ArrayList<>();
        this.normal = new ArrayList<>();
        IsolationForest tempForest = new IsolationForest(maxTreeNum, maxSampling);
        tempForest.createForest(data.clone());
        this.forest = tempForest;
        cutAnomaly(data, factor, list);
        List<List<Map<String, Object>>> result = new ArrayList<>();
        result.add(normal);
        result.add(abnormal);
        return result;
    }

    /**
     * 选出所有异常值
     *
     * @param data
     * @param factor
     */
    public void cutAnomaly(double[] data, double factor, List<Map<String, Object>> list) {
        for (int i = 0; i < data.length; i++) {
            if (this.forest.searchForest(data[i]) > factor) {
                this.abnormal.add(list.get(i));
            } else {
                this.normal.add(list.get(i));
            }
        }
    }

    public List<Map<String, Object>> getNormal() {
        return normal;
    }

    public void setNormal(List<Map<String, Object>> normal) {
        this.normal = normal;
    }

    public List<Map<String, Object>> getAbnormal() {
        return abnormal;
    }

    public void setAbnormal(List<Map<String, Object>> abnormal) {
        this.abnormal = abnormal;
    }


    public int getMaxSampling() {
        return maxSampling;
    }

    public void setMaxSampling(int maxSampling) {
        this.maxSampling = maxSampling;
    }

    public int getMaxTreeNum() {
        return maxTreeNum;
    }

    public void setMaxTreeNum(int maxTreeNum) {
        this.maxTreeNum = maxTreeNum;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
