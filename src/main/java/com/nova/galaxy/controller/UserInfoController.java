package com.nova.galaxy.controller;

import com.nova.galaxy.dto.ResponseUserInfoDTO;
import com.nova.galaxy.entity.UserInfo;
import com.nova.galaxy.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

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
    public ResponseUserInfoDTO saveUser(@RequestBody UserInfo userInfo) throws NoSuchAlgorithmException {
        return userInfoService.saveUser(userInfo);
    }

    @PostMapping("/login")
    public ResponseUserInfoDTO loginUser(@RequestBody UserInfo userInfo) throws NoSuchAlgorithmException {
        return userInfoService.loginUser(userInfo);
    }
}
