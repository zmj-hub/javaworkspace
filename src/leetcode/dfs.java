package leetcode;

import Utils.FileUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class dfs {
    public static String[] ids = new String[1000];
    public static int i = 0;

    public static void main(String[] args) throws Exception {
        String json = FileUtils.readFile();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        dfs(jsonArray);
//        System.out.println(jsonArray);
        for (int j = 0; j < i; j++) {
            System.out.print(ids[j] + " ");
        }
        System.out.println();
        System.out.println(i);
    }


    //    public static void dfs(Object object) {
//        if (object instanceof JSONObject) {
//            JSONObject jsonObject = (JSONObject) object;
//            if (jsonObject.get("id") != null) {
//                ids[i] = jsonObject.get("id").toString();
//                i++;
//            }
//            for (Map.Entry<String, Object> firstEntry : jsonObject.entrySet()) {
//                if (firstEntry.getValue() instanceof JSONObject || firstEntry.getValue() instanceof JSONArray) {
//                    dfs(firstEntry.getValue());
//                }
//            }
//        }
//        if (object instanceof JSONArray) {
//            JSONArray jsonArray = (JSONArray) object;
//            for (int j = 0; j < jsonArray.size(); j++) {
//                dfs(jsonArray.get(j));
//            }
//        }
//    }
    public static void dfs(Object object) {
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            if (jsonObject.get("id") != null) {
                ids[i] = jsonObject.get("id").toString();
                i++;
            }
            if (jsonObject.get("sonList") != null) {
                JSONArray jsonArray = (JSONArray) jsonObject.get("sonList");
                dfs(jsonArray);
            }
        }
        if (object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            for (int j = 0; j < jsonArray.size(); j++) {
                dfs(jsonArray.get(j));
            }
        }
    }
}
