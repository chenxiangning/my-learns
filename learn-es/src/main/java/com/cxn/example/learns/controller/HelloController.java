package com.cxn.example.learns.controller;

import com.cxn.example.learns.beans.config.MyInfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private MyInfoConfig myInfoConfig;

    @RequestMapping(value = "/info",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String info() {
        System.out.println(myInfoConfig.getName());
        return myInfoConfig.toString();
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hello(@RequestParam(value = "param1", required = false) String param1) {
        return "hello:" + param1;
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String hello(@RequestBody Map map) {
        return map.toString();
    }
}
