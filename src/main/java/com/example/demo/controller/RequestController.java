package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String getToPage(HttpServletRequest request) {

        request.setAttribute("msg","12345");
        request.setAttribute("msg2","6789");


        return "forward:/success";

    }

    @GetMapping("/params")
    public String paramTest(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        map.put("hello","world22");
        model.addAttribute("world","shijieheping");
        request.setAttribute("message","helloworld");

        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");

        response.addCookie(cookie);


        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute(value = "msg",required = false) String msg
                                        ,@RequestAttribute(value = "msg2",required = false) String msg2
                                        ,HttpServletRequest request) {

        Object org1 = request.getAttribute("msg");

        request.getAttribute("hello");

        Map<String,Object> map = new HashMap<>();

//        map.put("org1",org1);
//        map.put("msg",msg);
//        map.put("msg2",msg2);

        map.put("hello",request.getAttribute("hello"));
        map.put("world",request.getAttribute("world"));
        map.put("message",request.getAttribute("message"));


        return map;
    }



    // /cars/sell;low=34;brand=byd,ah.dh
    @ResponseBody
    @RequestMapping("/car/{path}")
    public Map<String,Object> carSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand) {

        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);

        return map;

    }

}
