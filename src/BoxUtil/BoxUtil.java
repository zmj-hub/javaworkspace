package BoxUtil;

import java.util.*;

/**
 * @author gwh
 */
public class BoxUtil {


    public static DomLoadModel boxNums(List<Map> data, String name) {

        Double[] arr = new Double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = (Double) data.get(i).get(name);
        }
        if (arr.length == 0) {
            return new DomLoadModel(0, 0, 0, 0, 0, new ArrayList<>());
        }
        if (arr.length == 1) {
            return new DomLoadModel(arr[0], arr[0], arr[0], arr[0], arr[0], new ArrayList<>());
        }
        Double[] arrCopy = arr.clone();
        Arrays.sort(arr);
        double Q1 = 0.0;//较小四分位数  Q1的位置=（n+1）/4
        double Q2 = 0.0;//中位数 Q2的位置=（n+1）/2　
        double Q3 = 0.0;//较大四分位数 Q3的位置=3（n+1）/4
        double IQR = 0.0;//四分位距IQR=Q3-Q1
        double min = 0.0;//下限  下限=Q1-1.5IQR   四分位距IQR=Q3-Q1
        double max = 0.0;//上限  上限=Q3+1.5IQR
//        List<Double> errNums = new ArrayList<Double>();//异常值   异常值的一个标准：异常值被定义为小于Q1－1.5IQR或大于Q3＋1.5IQR的值 （即大于上限或小于下限的值）
        List<Map> errNums = new ArrayList<>();
        List<Double> nomalValues = new ArrayList<Double>();//正常值
        List<Map> nomalNums = new ArrayList<>();//正常值
        Q2 = getMedian(arr);
        if (arr.length % 2 == 0) {//偶数
            Q1 = getMedian(Arrays.copyOfRange(arr, 0, arr.length / 2));
            Q3 = getMedian(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        } else {//奇数
            Q1 = getMedian(Arrays.copyOfRange(arr, 0, arr.length / 2));
            Q3 = getMedian(Arrays.copyOfRange(arr, arr.length / 2 + 1, arr.length));
        }
        IQR = Q3 - Q1;
        min = Q1 - 1.5 * IQR;
        max = Q3 + 1.5 * IQR;
//        for (double i : arr) {
//            if (i < min || i > max) {
//                errNums.add(i);
//            } else {
//                nomalNums.add(i);
//            }
//        }
        for (int i = 0; i < arrCopy.length; i++) {
            if (i < min || i > max) {
                errNums.add(data.get(i));
            } else {
                nomalNums.add(data.get(i));
                nomalValues.add(arrCopy[i]);
            }
        }
        return new DomLoadModel(Q1, Q2, Q3, Collections.min(nomalValues), Collections.max(nomalValues), errNums);
    }

    /**
     * 求中位数
     *
     * @param arr
     * @return
     */
    public static double getMedian(Double[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        Double[] tempArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tempArr);
        if (tempArr.length % 2 == 0) {
            return (tempArr[tempArr.length >> 1] + tempArr[(tempArr.length >> 1) - 1]) / 2.0;
        } else {
            return tempArr[(tempArr.length >> 1)];
        }
    }

    public static void main(String[] args) {
//        List<Double> nomalNums = new ArrayList<Double>();
//        nomalNums.add(3.0);
//        nomalNums.add(1.0);
//        nomalNums.add(4.0);
////        System.out.println("nomalNums: " + nomalNums);
////        System.out.println("min: " + Collections.min(nomalNums));
////        System.out.println("max: " + Collections.max(nomalNums));
////        Collections.sort(nomalNums);
////        System.out.println("nomalNums11: " + nomalNums);
//        Double[] doubles = {3.0, 1.0, 4.0};
//        Double[] doubles1 = new Double[nomalNums.size()];
//        nomalNums.toArray(doubles1);
//        List<Map> data = new ArrayList<>();
//        Map<String, Object> data1 = new HashMap<>();
//        data1.put("a", 3.0);
//        data1.put("b", 333.0);
//        Map<String, Object> data2 = new HashMap<>();
//        data2.put("a", 1.0);
//        data2.put("b", 111.0);
//        Map<String, Object> data3 = new HashMap<>();
//        data3.put("a", 4.0);
//        data3.put("b", 444.0);
//        Map<String, Object> data4 = new HashMap<>();
//        data4.put("a", 999999.0);
//        data4.put("b", 9999.0);
//        Map<String, Object> data5 = new HashMap<>();
//        data5.put("a", 9.0);
//        data5.put("b", 9999.0);
//        data.add(data1);
//        data.add(data2);
//        data.add(data3);
//        data.add(data4);
//        data.add(data5);
////        DomLoadModel domLoadModel = boxNums(doubles);
//        DomLoadModel domLoadModel = boxNums(data, "a");
//        System.out.println(domLoadModel.toString());

    }

}