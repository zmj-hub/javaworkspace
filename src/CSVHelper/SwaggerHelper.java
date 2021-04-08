//package CSVHelper;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class SwaggerHelper {
//
//
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://39.104.109.13/detecting/api/v1/v2/api-docs";
//        ResponseEntity<String> responseEntity = null;
//        try {
//            responseEntity = restTemplate.getForEntity(url, String.class);
//        } catch (RestClientException e) {
//            e.printStackTrace();
//        }
//        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
//        JSONArray tags = jsonObject.getJSONArray("tags");
//        JSONObject paths = (JSONObject) jsonObject.get("paths");
//        for (Map.Entry<String, Object> entry : paths.entrySet()) {
//            String menUrl = entry.getKey();
//            JSONObject method = ((JSONObject) entry.getValue());
//            for (Map.Entry<String, Object> entry1 : method.entrySet()) {
//                String tagsName = ((JSONArray) (((JSONObject) entry1.getValue()).get("tags"))).get(0).toString();
//                String menuDescribe = (((JSONObject) entry1.getValue()).get("summary")).toString();
//                String operationId = (((JSONObject) entry1.getValue()).get("operationId")).toString();
//                String menuMethod = operationId.substring(0, operationId.indexOf("Using"));
//                String menuClass = null;
//                for (Object tag : tags) {
//                    JSONObject temp = (JSONObject) tag;
//                    if (tagsName.equals(temp.getString("name"))) {
//                        menuClass = temp.getString("description").replaceAll(" ", "");
//                    }
//                }
//                String sql = "insert into menu (menu_url, menu_describe, menu_class, menu_method) VALUES ('" + menUrl + "', '" + menuDescribe + "', '" + menuClass + "', '" + menuMethod + "');";
////                System.out.println(sql);
//                list.add(sql);
//            }
//        }
//        System.out.println(list.toString());
//
//    }
//
//}
