package com.gong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/10/29/029.
 */
@RestController
@RequestMapping("/test")
public class Test {
    @RequestMapping(value ="/test")
    public String getUserBasic() {
        return "gyk";
    }
}
