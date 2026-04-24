package com.hello.service;

import com.hello.model.User;
import java.util.List;

/**
 * UserService 인터페이스
 * 비즈니스 로직 계층
 */
public interface UserService {

    List<User> getUserList();

    User getUserById(int id);

    boolean registerUser(User user);

    boolean modifyUser(User user);

    boolean removeUser(int id);
}
