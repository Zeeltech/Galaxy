package com.nova.galaxy.repository;

import com.nova.galaxy.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    public UserInfo findByEmail(String email);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    UserInfo findByUserName(String userName);
}
