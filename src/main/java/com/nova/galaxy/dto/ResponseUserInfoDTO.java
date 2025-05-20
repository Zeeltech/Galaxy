package com.nova.galaxy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserInfoDTO {
    private String userName;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String profileImageLink;
}
