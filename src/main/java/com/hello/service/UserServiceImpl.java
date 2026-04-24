package com.hello.service;

import com.hello.dao.UserDao;
import com.hello.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService 구현체
 * @Transactional로 트랜잭션 관리
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        logger.info("전체 사용자 조회");
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        logger.info("사용자 조회: id={}", id);
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public boolean registerUser(User user) {
        logger.info("사용자 등록: {}", user);
        return userDao.insert(user) > 0;
    }

    @Override
    @Transactional
    public boolean modifyUser(User user) {
        logger.info("사용자 수정: {}", user);
        return userDao.update(user) > 0;
    }

    @Override
    @Transactional
    public boolean removeUser(int id) {
        logger.info("사용자 삭제: id={}", id);
        return userDao.delete(id) > 0;
    }
}
