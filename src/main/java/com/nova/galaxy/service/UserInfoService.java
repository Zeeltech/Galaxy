package com.nova.galaxy.service;

import com.nova.galaxy.dto.ResponseUserInfoDTO;
import com.nova.galaxy.entity.UserInfo;
import com.nova.galaxy.mapper.ModelMapper;
import com.nova.galaxy.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public ResponseUserInfoDTO saveUser(UserInfo userInfo) {

//        UserInfo temp = userInfoRepository.findByEmail(userInfo.getEmail());

        boolean temp = userInfoRepository.existsByFirstNameAndLastName(userInfo.getFirstName(), userInfo.getLastName());

        if(!temp) {
            UserInfo savedUserInfo = userInfoRepository.save(userInfo);
            return ModelMapper.getResponseUserInfoDTO(savedUserInfo);
        } else {
            throw new RuntimeException("User with this fistName and LastName Already Exist!!!");
        }
    }
}
