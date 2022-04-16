package com.eph.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/gotox")
    public String testParam(Map<String, Object> map,
                           Model model,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        map.put("hello", "ephraim");
        model.addAttribute("world", "ephraim");
        request.setAttribute("message", "helloworld");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/sxx";
    }

    @GetMapping("/paramxx")
    public String testParamx(Map<String, Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {

        map.put("hello", "params yoyoyo");
        model.addAttribute("hello-model", "model params yoyoyo");
        request.setAttribute("hello-request", "request attributes yoyoyo");

        Cookie cookie = new Cookie("cookieYea", "cookieValueYea");
        cookie.setDomain("localhost");
        cookie.setMaxAge(100000);
        response.addCookie(cookie);

        return "forward:/sxxx";
    }

    @ResponseBody
    @GetMapping("/sxxx")
    public Map sxxx(HttpServletRequest request,
                    @RequestAttribute("hello") Object mapHello,
                    @RequestAttribute("hello-model") Object modelHello,
                    @RequestAttribute("hello-request") Object requestHello) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("mapHello" ,mapHello);
        map.put("modelHello", modelHello);
        map.put("requestHello", requestHello);

        Object hello1 = request.getAttribute("hello");
        Object hello2 = request.getAttribute("hello-model");
        Object hello3 = request.getAttribute("hello-request");

        map.put("mapHello*",hello1);
        map.put("modelHello*",hello2);
        map.put("requestHello*",hello3);

        return map;
    }

    @ResponseBody
    @GetMapping("/sxx")
    public Map sxx(HttpServletRequest request,
                          @RequestAttribute(value = "msg", required = false) String msg) {
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        HashMap<Object, Object> map = new HashMap<>();
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);
        map.put("msg", msg);

        return map;
    }
}
