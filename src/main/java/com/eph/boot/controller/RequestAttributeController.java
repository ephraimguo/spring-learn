package com.eph.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RequestAttributeController {

    @GetMapping("/request")
    public String forward(HttpServletRequest request) {
//        System.out.println(request);

        request.setAttribute("msg", "yay");
        request.setAttribute("code", "200");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public String success(@RequestAttribute("msg") String msg, HttpServletRequest request) {
        System.out.println(request.getAttribute("msg"));
        System.out.println(request.getAttribute("code"));
        System.out.println(msg);
        return "success";
    }
}
