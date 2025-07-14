package com.tsc.demo.service;

import com.tsc.demo.model.UserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final List<UserVO> users = new ArrayList<>();

    static {
        users.add(new UserVO(1L, "Dinesh", "dinesh.adi@gmail.com", "6292446633", "password"));
        users.add(new UserVO(2L, "Divya", "divya.dinu@gmail.com", "6154409063", "password"));
        users.add(new UserVO(3L, "Lakhith", "lakhith.dinu@gmail.com", "6292446633", "password"));
    }

    @Override
    public List<UserVO> findAllUsers() {
        return users;
    }

    @Override
    public UserVO addUser(UserVO userVO) {
        users.add(userVO);
        return userVO;
    }

    @Override
    public UserVO getUser(Long id) {
        return users.stream().filter(u -> u.getUserId().equals(id)).findFirst().get();
    }
}
