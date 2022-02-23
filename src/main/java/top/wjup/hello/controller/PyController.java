package top.wjup.hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.wjup.hello.service.PyService;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/py")
public class PyController {

    @Autowired
    private PyService pyService;

    @ResponseBody
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {

        // 图片存储路径
        String path = "G:\\computer";
        // 判断是否有路径
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        File tempFile = new File(path, fileName);
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        System.out.println("文件获取成功：" + fileName);

        return "ok!";
    }


    @ResponseBody
    @RequestMapping("/readConf")
    public String readConf() {
        Map<String, Object> map = pyService.getConfig();
        String json1 = JSON.toJSONString(map);
        JSONObject json = JSON.parseObject(json1);

//        json.put("type", 0);
//        json.put("fileName", "公众号爬取程序.zip");
//        json.put("path", "G://公众号爬取程序.zip");

        return json.toJSONString();
    }


    @ResponseBody
    @RequestMapping("/message")
    public String message(@RequestParam("msg") String name) {
        System.out.println(name);

        return "";
    }
}
