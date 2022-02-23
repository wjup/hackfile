package top.wjup.hello;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class IndexController {

    @Value("${show.text}")
    private String showText;

    @RequestMapping("/topArticle")
    public String topArticle() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 5; i++) {
            JSONObject json = new JSONObject();
            json.put("id", i);
            json.put("name", "test" + i);
            jsonArray.add(json);
        }
        jsonObject.put("data", jsonArray);

        return jsonObject.toJSONString();
    }

    @PostMapping("/topImg")
    public String topImg() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);

        JSONArray jsonArray = new JSONArray();
        JSONObject json1 = new JSONObject();
        json1.put("path", "https://gitee.com/wjup/img/raw/master/img/banner006.jpg");
        json1.put("id", 0);
        jsonArray.add(json1);
        JSONObject json2 = new JSONObject();
        json2.put("path", "https://gitee.com/wjup/img/raw/master/img/banner002.jpg");
        json2.put("id", 1);
        jsonArray.add(json2);
        JSONObject json3 = new JSONObject();
        json3.put("path", "https://gitee.com/wjup/img/raw/master/img/banner003.jpg");
        json3.put("id", 2);
        jsonArray.add(json3);
        JSONObject json4 = new JSONObject();
        json4.put("path", "https://gitee.com/wjup/img/raw/master/img/banner004.jpg");
        json4.put("id", 3);
        jsonArray.add(json4);
        JSONObject json5 = new JSONObject();
        json5.put("path", "https://gitee.com/wjup/img/raw/master/img/banner005.jpg");
        json5.put("id", 4);
        jsonArray.add(json5);
        JSONObject json6 = new JSONObject();
        json6.put("path", "https://gitee.com/wjup/img/raw/master/img/banner001.jpg");
        json6.put("id", 5);
        jsonArray.add(json6);

        jsonObject.put("data", jsonArray);

        return jsonObject.toJSONString();
    }


}
