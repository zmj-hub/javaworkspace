package leetcode;

import Utils.FileUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static String[] ids = new String[1000];
    public static int i = 0;

    public static void main(String[] args) throws Exception {
        String json = FileUtils.readFile();
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        bfs(jsonArray);
        for (int j = 0; j < i; j++) {
            System.out.print(ids[j] + " ");
        }
        System.out.println();
        System.out.println(i);
    }

    public static void bfs(JSONArray jsonArray) {
        Queue<Object> queue = new LinkedList<>();
        for (int j = 0; j < jsonArray.size(); j++) {
            queue.offer(jsonArray.get(j));
        }
        while (!queue.isEmpty()) {
            JSONObject jj = (JSONObject) queue.poll();
            if (jj.get("id") != null) {
                ids[i] = jj.get("id").toString();
                i++;
            }
            if (jj.get("sonList") != null) {
                JSONArray jsonArray1 = (JSONArray) jj.get("sonList");
                for (int j = 0; j < jsonArray1.size(); j++) {
                    queue.offer(jsonArray1.get(j));
                }
            }
        }
    }
}
