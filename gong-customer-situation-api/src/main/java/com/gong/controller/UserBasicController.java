package com.gong.controller;

import com.gong.customer.situation.service.UserBasicService;
import com.seven.commons.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 59448
 * @date 2018/10/25
 */
@RestController
@RequestMapping("/web/user")
public class UserBasicController {

    @Autowired
    private UserBasicService userBasicService;

    @RequestMapping("/get-user-basic")
    public BaseResponse getUserBasic(){
        //return BaseResponse.buildSuccess("gyk");

       return BaseResponse.buildSuccess(userBasicService.searchUserBasic());
    }
}
