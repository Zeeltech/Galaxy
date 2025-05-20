package com.nova.galaxy.service;

import com.nova.galaxy.entity.UserInfo;
import com.nova.galaxy.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfo saveUser(UserInfo userInfo) {

//        UserInfo temp = userInfoRepository.findByEmail(userInfo.getEmail());

        boolean temp = userInfoRepository.existsByFirstNameAndLastName(userInfo.getFirstName(), userInfo.getLastName());

        if(!temp) {
            UserInfo savedUserInfo = userInfoRepository.save(userInfo);
            return savedUserInfo;
        } else {
            throw new RuntimeException("User with this fistName and LastName Already Exist!!!");
        }
    }
}
