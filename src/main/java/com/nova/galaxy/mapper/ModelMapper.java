package com.nova.galaxy.mapper;

import com.nova.galaxy.dto.ResponseUserInfoDTO;
import com.nova.galaxy.entity.UserInfo;
import org.springframework.beans.BeanUtils;

public class ModelMapper {

    public static ResponseUserInfoDTO getResponseUserInfoDTO(UserInfo userInfo) {
        ResponseUserInfoDTO responseUserInfoDTO = new ResponseUserInfoDTO();
        BeanUtils.copyProperties(userInfo, responseUserInfoDTO);

        return responseUserInfoDTO;
    }
}
