package com.springsoket.springsocket.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sms")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "sendsmsTest" ,method = RequestMethod.GET)
    public  String sendsmsTest(){
        String url = "https://open.ucpaas.com/ol/sms/sendsms";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", "010b4f20890f086382e4ad8ed3cc7e8c");
        jsonObject.put("token", "2ea4f7a08c7ca85e00202fda09b46fc8");
        jsonObject.put("appid", "b4dd9a2c5b0743f78db6a03447f655ed");
        //模板ID，在开发平台创建模板对应的模板ID
        jsonObject.put("templateid", "491457");
        // 模板对应的参数，参数之间拼接用逗号作为间隔符
        jsonObject.put("param", "5201314");
        // 要发送的手机号
        jsonObject.put("mobile", "15904961608");
        // /用户透传ID，随状态报告返回,可以不填写
        jsonObject.put("uid", "");
        String json = JSONObject.toJSONString(jsonObject);
        HttpHeaders headers = new HttpHeaders();
        //以json方式提交
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        //将请求头和请求体合并
        HttpEntity<String> httpEntity = new HttpEntity<String>(json,headers);
        String result = restTemplate.postForObject(url,httpEntity,String.class);
        return result;
    }


    /**
     * 群发短信测试
     * @Author: lcx
     *  @CreateTime: 2019/8/6
     */
    @RequestMapping(value = "/sendBatchsmsTest", method = RequestMethod.GET)
    public String sendBatchsmsTest() {
        //群发短信API
         String url = "https://open.ucpaas.com/ol/sms/sendsms_batch";
         JSONObject jsonObject = new JSONObject();
        // 基础配置，在开发平台认证后获取
        jsonObject.put("sid", "010b4f20890f086382e4ad8ed3cc7e8c");
        jsonObject.put("token", "2ea4f7a08c7ca85e00202fda09b46fc8");
        jsonObject.put("appid", "b4dd9a2c5b0743f78db6a03447f655ed");
        //模板ID，在开发平台创建模板对应的模板ID
         jsonObject.put("templateid", "491457");
         // 模板对应的参数，参数之间拼接用逗号作为间隔符
         jsonObject.put("param", "5201314");
         // 群发多个手机号之间要用逗号作为间隔符
         jsonObject.put("mobile", "15904961608,15909843036");
         // 用户透传ID，随状态报告返回,可以不填写
         jsonObject.put("uid","");
         String json = JSONObject.toJSONString(jsonObject);
         // 使用restTemplate进行访问远程服务
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
         HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
         String result = restTemplate.postForObject(url, httpEntity, String.class);
         return result;
         }
    }
