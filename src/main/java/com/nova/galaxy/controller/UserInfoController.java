package com.nova.galaxy.controller;

import com.nova.galaxy.entity.UserInfo;
import com.nova.galaxy.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("/test")
    public String test() {
        return "Hello Galaxy!!!";
    }

    @PostMapping("/save")
    public UserInfo saveUser(@RequestBody UserInfo userInfo) {
        return userInfoService.saveUser(userInfo);
    }
}
