package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    //路径变量传入参数 在mapping映射注解上直接后缀/{参数}
    //@PathVariable路径参数注解
    //@RequestHeader获取请求头的全部信息
    //@RequestParam获取请求是带入的参数的信息
    //@CookieVale 获取缓存的信息
    @GetMapping("/car/{id}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id){
                                    //, @PathVariable Map<String,Object> map1
//                                    , @RequestHeader("User-Agent") String userAgent
//                                    , @RequestHeader Map<String,Object> map2
//                                    , @RequestParam("age") Integer age
//                                    , @RequestParam("inters") List<String> inters //直接打印所有参数
//                                    , @RequestParam Map<String,Object> params
//                                    , @CookieValue("_ga") String ga) {

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        //map.put("pv",map1);
//        map.put("userAgent",userAgent);
//        map.put("header",map2);

        return map;
    }

    // @RequestBody就是获取请求体的信息（一般只有post请求才有请求体）
    @PostMapping("/user")
    public Map<String,Object> postMethod(@RequestBody String content) {

        Map<String,Object> map = new HashMap<>();

        map.put("content",content);

        return map;
    }
}
