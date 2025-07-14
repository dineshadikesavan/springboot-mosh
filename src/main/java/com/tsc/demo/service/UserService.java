package com.tsc.demo.service;

import com.tsc.demo.model.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> findAllUsers();

    UserVO addUser(UserVO userVO);

    UserVO getUser(Long id);
}
