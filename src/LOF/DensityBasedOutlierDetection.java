package LOF;

import java.util.*;

//<dependency>
//<groupId>com.googlecode.efficient-java-matrix-library</groupId>
//<artifactId>ejml</artifactId>
//<version>0.25</version>
//</dependency>


/**
 * LOF
 *
 * @author outsider
 */
public class DensityBasedOutlierDetection {
    private String fieldName;
    //数据列分隔符
//    public static String ITEM_SPLIT = ",";
    //数据维度
//    public static int ATRIBUTE_NUMBER = 4;
    //数据之间的欧式距离
    public Map<Integer, List<Distance>> distances = new HashMap<>();
    //list索引及数据的索引
    public List<Result> results;

    public DensityBasedOutlierDetection(String fieldName) {
        this.fieldName = fieldName;
    }

    public static void main(String[] args) throws Exception {
        //设置维度之间分隔符及维度数量
//        ITEM_SPLIT = ",";
//        ATRIBUTE_NUMBER = 4;
//        ArrayList<double[]> data = readFile("data/iris.txt");

        List<Map<String, Object>> data = new ArrayList<>();
//        Map<String, Object> data1 = new HashMap<>();
//        Map<String, Object> data2 = new HashMap<>();
//        Map<String, Object> data3 = new HashMap<>();
//        Map<String, Object> data4 = new HashMap<>();
//        Map<String, Object> data5 = new HashMap<>();
//        Map<String, Object> data6 = new HashMap<>();
//        Map<String, Object> data7 = new HashMap<>();
//        Map<String, Object> data8 = new HashMap<>();
//        Map<String, Object> data9 = new HashMap<>();
//        Map<String, Object> data10 = new HashMap<>();
//        data1.put("a", 9122);
//        data2.put("a", 11);
//        data3.put("a", 1);
//        data4.put("a", 4);
//        data5.put("a", 0);
//        data6.put("a", 53);
//        data7.put("a", 15);
//        data8.put("a", 12);
//        data9.put("a", 20);
//        data10.put("a", 3);
//        data.add(data1);
//        data.add(data2);
//        data.add(data3);
//        data.add(data4);
//        data.add(data5);
//        data.add(data6);
//        data.add(data7);
//        data.add(data8);
//        data.add(data9);
//        data.add(data10);

        for (int i = 0; i <50 ; i++) {
            Map<String, Object> data1 = new HashMap<>();
            data1.put("a", (int)(Math.random()*100));
            data.add(data1);
        }

        DensityBasedOutlierDetection densityBasedOutlierDetection = new DensityBasedOutlierDetection("a");
//        densityBasedOutlierDetection.Lof(data);
        List<List<Map<String, Object>>> result = densityBasedOutlierDetection.Lof(data,6);
        System.out.println(result.size());
        //搜索结果k=9
        //搜索超参数k
		/*Set<Integer> targetIndices = new HashSet<>();
		targetIndices.add(41);
		targetIndices.add(106);
		targetIndices.add(109);
		targetIndices.add(117);
		targetIndices.add(131);
		lof.gridSearch(2, 40, targetIndices, data);*/
    }

    public List<List<Map<String, Object>>> Lof(List<Map<String, Object>> data,int k) {
        Double[] arr = new Double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = Double.parseDouble(data.get(i).get(fieldName).toString());
        }
//        dataNormalize(arr);
        DensityBasedOutlierDetection lof = new DensityBasedOutlierDetection(fieldName);
        lof.run(arr, k);
        return lof.printResult(data);
    }


    public void run(Double[] data, int k) {
        //1.计算各数据之间的欧式距离
        distancesBetweenSamples(data);
        //2.计算每个点p的局部可达密度（包括了第k领域以及第k距离的计算）
        kDisAndReachDisAndLRD(data, k);
        //3.计算局部离群因子
        LOF();
    }

    /**
     * 搜索超参数k，让给定的targetIndexes的lof值尽快排在前面
     *
     * @param ks            k最小值
     * @param ke            k最大值
     * @param targetIndexes 目标数据索引
     * @param data          数据
     */
    public void gridSearch(int ks, int ke, Set<Integer> targetIndexes, Double[] data) {
        //排名index的和最小
        int min = Integer.MAX_VALUE;
        int bestK = 0;
        for (int i = ks; i <= ke; i++) {
            System.out.println("searching...k=" + i);
            run(data, i);
            int rankSum = 0;
            for (int j = 0; j < results.size(); j++) {
                if (targetIndexes.contains(results.get(j).p)) {
                    rankSum += j;
                }
            }
            if (rankSum < min) {
                min = rankSum;
                bestK = i;
            }
        }
        System.out.println("best K:" + bestK);

    }

    public List<List<Map<String, Object>>> printResult(List<Map<String, Object>> data) {
        System.out.println("可能的异常点:");
        System.out.println("index\tlof");
        int c = 0;
        List<List<Map<String, Object>>> relResult = new ArrayList<>();
        List<Map<String, Object>> normal = new ArrayList<>();//正常数据
        List<Map<String, Object>> abnormal = new ArrayList<>();//异常数据
        for (Result result : results) {
            //lof越接近1，越小于1都是正常，越大于1则可能是异常点
            if (result.lof <= 1.1)
                normal.add(data.get(result.p));
            else {
                abnormal.add(data.get(result.p));
                c++;
            }
            System.out.println(data.get(result.p).get("a") + "  " + result.lof);
        }
        System.out.println("共" + c + "个点");
        relResult.add(normal);
        relResult.add(abnormal);
        return relResult;
    }

    //计算局部离群因子并由大到小排序
    public void LOF() {
        for (int i = 0; i < results.size(); i++) {
            //p与邻域内点的局部可达密度之比的平均值
            Result result = results.get(i);
            double avg = 0;
            for (int j = 0; j < result.neighbors.size(); j++) {
                int index = result.neighbors.get(j);
                avg += results.get(index).lrd;
            }
            avg /= result.lrd;
            result.lof = avg / result.neighbors.size();
        }
        //有个麻烦问题就是如果这里排序了那么索引就乱了，Result还是得保存p的index
        Collections.sort(results);
    }


    // k <= data.size - 1
    public void kDisAndReachDisAndLRD(Double[] data, int k) {
        results = new ArrayList<>(data.length);
        for (int i = 0; i < data.length; i++) {
            Result knia = new Result();
            knia.p = i;
            //1.获取点p到其他点的距离
            List<Distance> p2Others = new ArrayList<>(data.length - 1);
            for (int j = 0; j < data.length; j++) {
                if (i != j) {
                    //bug:如果i > j，比如i=2,j=1,那么实际调用getDistance时获取的时i=1,j=2
                    //问题就是返回的对象中distance.j就变成了2，实际上应该是1
                    //最好的办法就需要动态设置distance对象中的属性
                    p2Others.add(getDistance(i, j));
                }
            }
            //2.对距离降序排列，选取前k个，如果k+1到p的距离等于k到p，那么加进去，依次类推，k+2,k+3
            Collections.sort(p2Others);
            //0..k-1
            double p2k = p2Others.get(k - 1).dis;
            int m = k;
            while (m < data.length && p2Others.get(m).dis == p2k) m++;
            //System.out.println("m==k?"+(m==k));
            //将这些邻域点加进去,并保存k距离
            List<Integer> indices = new ArrayList<>(m);
            for (int c = 0; c < m; c++) {
                indices.add(p2Others.get(c).j);
            }
            knia.neighbors = indices;
            knia.kDis = p2k;
            results.add(knia);
        }
        for (int i = 0; i < data.length; i++) {
            //3.计算p到其他点的可达距离
            Result ki = results.get(i);
            double avg = 0;
            for (int j = 0; j < ki.neighbors.size(); j++) {
                int index = ki.neighbors.get(j);
                avg += Math.max(results.get(index).kDis, getDistance(i, index).dis);
            }
            //4.计算p的局部可达密度:邻域内平均可达距离的倒数
            ki.lrd = 1 / (avg / ki.neighbors.size());
        }
    }

    public void distancesBetweenSamples(Double[] data) {
        //实际保存的距离数量
        //int len = (data.size()*(data.size()-1))/2;
        if (distances != null && distances.size() > 0)
            return;
        for (int i = 0; i < data.length - 1; i++) {
            List<Distance> dis = new ArrayList<>(data.length - i - 1);
            distances.put(i, dis);
            for (int j = i + 1; j < data.length; j++) {
                //dis[j-i-1] = distance(data.get(i), data.get(j));
                Distance distance = new Distance();
                distance.j = j;
//                distance.dis = distance(data.get(i), data.get(j));
                distance.dis = Math.abs(data[i] - data[j]);
                dis.add(distance);
            }
        }
    }

    public Distance getDistance(int i, int j) {
        //索引必须小的在前面
        Distance distance = null;
        //对j索引做偏移，j-i-1
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
            distance = distances.get(i).get(j - i - 1);
            distance.j = i;
        } else {
            distance = distances.get(i).get(j - i - 1);
            distance.j = j;
        }
        return distance;
    }

    //欧式距离
    public double distance(double[] v1, double[] v2) {
        double sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(sum);
    }

    //数据点p的第k邻域数据索引及可达密度及局部离群因子等计算结果保存
    public static class Result implements Comparable<Result> {
        public int p;
        //p的局部可达密度
        public double lrd;
        //p的k距离
        public double kDis;
        //局部离群因子
        public double lof;
        //邻域点的索引
        public List<Integer> neighbors;

        @Override
        public int compareTo(Result o) {
            return o.lof > this.lof ? 1 : -1;
        }
    }

    public static class Distance implements Comparable<Distance> {
        //数据i到j的欧式距离，这里j为数据索引，i存储到map中的key
        public int j;
        public double dis;

        @Override
        public int compareTo(Distance o) {
            return o.dis > this.dis ? -1 : 1;
        }
    }

    /**
     * 数据归一化
     * 如果不做归一化并且不修改weka中DBSCAN的设置那么结果将大不一样
     * x = (x - min)/(max - min)
     */
    public static void dataNormalize(Double[] inputValues) {
        //x = (x - min)/(max - min)
        double mins = Double.MIN_VALUE;
        double maxs = Double.MAX_VALUE;

        for (int i = 0; i < inputValues.length; i++) {
            mins = inputValues[i] < mins ? inputValues[i] : mins;
            maxs = inputValues[i] > maxs ? inputValues[i] : maxs;
        }

        double maxsReduceMins = maxs - mins;

        for (int i = 0; i < inputValues.length; i++) {
            inputValues[i] = (inputValues[i] - mins) / maxsReduceMins;
        }
    }

}