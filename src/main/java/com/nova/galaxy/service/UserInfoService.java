package com.nova.galaxy.service;

import com.nova.galaxy.dto.ResponseUserInfoDTO;
import com.nova.galaxy.entity.UserInfo;
import com.nova.galaxy.mapper.ModelMapper;
import com.nova.galaxy.repository.UserInfoRepository;
import com.nova.galaxy.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public ResponseUserInfoDTO saveUser(UserInfo userInfo) throws NoSuchAlgorithmException {

        UserInfo savedUserInfo;
        try {
            if(StringUtils.isNotBlank(userInfo.getPassword())) {
                userInfo.setPassword(HashUtil.getHashedValue(userInfo.getPassword()));
            }
            savedUserInfo = userInfoRepository.save(userInfo);
        } catch (Exception e) {
            throw e;
        }

        return ModelMapper.getResponseUserInfoDTO(savedUserInfo);
    }

    public ResponseUserInfoDTO loginUser(UserInfo userInfo) throws NoSuchAlgorithmException {

        UserInfo dbUserInfo = userInfoRepository.findByUserName(userInfo.getUserName());
        // password matching
        String currentHashedValue = HashUtil.getHashedValue(userInfo.getPassword());
        if(currentHashedValue.equals(dbUserInfo.getPassword())) {
            return ModelMapper.getResponseUserInfoDTO(dbUserInfo);
        }

        throw new RuntimeException("WRONG PASSWORD!!!");
    }


}
