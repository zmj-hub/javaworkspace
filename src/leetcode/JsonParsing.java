package leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParsing {
    static List<Object> nodeList = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        String[] strings = {
                "h3",
                "h2", "h3",
                "h1", "h2", "h3", "h3", "h2", "h3",
                "h1", "h2", "h4", "h2", "h3"
        };

//        int[] arr = {3, 2, 3, 1, 2, 3, 3, 2, 3, 1, 2, 4, 2, 3};
//        List<Node> nodeList = new ArrayList<>();
//        for (int n : arr) {
//            Node node = new Node(n);
//            nodeList.add(node);
//        }
//        backTracking(nodeList);
        find(strings, nodeList, 0);
//        System.out.println(111);
        System.out.println(JSONObject.toJSON(nodeList));
    }

    public static void find(String[] strings, List<Object> lists, int root) {
        while (count < strings.length) {
            int temp = Integer.parseInt(strings[count].substring(1));
            if (temp < root || temp == root)
                return;
            else {
                System.out.print(root);
                List<Object> list1 = new ArrayList<>();
                lists.add(new Node(strings[count], list1));
                count++;
                if ((count) < strings.length)
                    find(strings, list1, temp);
            }
        }

    }


//    public static void backTracking(List<Node> nodeList) {
//        List<Node> rightNodeList = new ArrayList<>();
//        rightNodeList.add(nodeList.get(0));
//        for (int i = 1; i < nodeList.size(); i++) {
//            if (nodeList.get(i).getName() > nodeList.get(i - 1).getName()) {
//                nodeList.get(i - 1).getChild().add(nodeList.get(i));
//            } else {
//                for (int j = rightNodeList.size() - 1; j >= 0; j--) {
//                    if (rightNodeList.get(j).getName() < nodeList.get(i).getName()) {
//                        rightNodeList.get(j).getChild().add(nodeList.get(i));
//                        break;
//                    }
//                }
//                rightNodeList.add(nodeList.get(i));
//            }
//        }
//        System.out.println(JSONObject.toJSON(rightNodeList));
//    }
}
