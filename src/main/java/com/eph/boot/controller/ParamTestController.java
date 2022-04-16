package com.eph.boot.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamTestController {

    @GetMapping("/car/{id}/owner/{name}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("name", name);

        return map;
    }

    @GetMapping("/car2/{id}/owner/{name}")
    public Map<String, String> getCar(@PathVariable Map<String, String> pathVarMap) {
        System.out.println(pathVarMap);
        return pathVarMap;
    }

    @GetMapping("/header")
    public Map<String, String> getRequestHeader(@RequestHeader("User-Agent") String userAgent,
                                                @RequestHeader("Host") String host,
                                                @RequestHeader HttpHeaders headers) {

        System.out.println(userAgent);
        System.out.println(host);
        System.out.println(headers);

        Map<String, String> resp = new HashMap<>();
        resp.put("user-agent", userAgent);
        resp.put("host", host);

        return resp;
    }
}
