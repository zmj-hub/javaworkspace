import java.util.HashMap;

public class QualityControlSampleType {
    //外部
    public static HashMap<String, Integer> externalCodeType = new HashMap();

    static {
        //普通
        externalCodeType.put("INSPECTION", 1);
        //互检
        externalCodeType.put("MUTUAL_INSPECTION", 2);
        //平行
        externalCodeType.put("PARALLEL", 3);
    }

    //获取一个Key
    public static String getKey(Integer value) {
        String key = null;
        for (String getKey : externalCodeType.keySet()) {
            if (externalCodeType.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
    }
}
