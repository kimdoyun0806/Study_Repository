package com.hello.dao;

import com.hello.model.User;
import java.util.List;

/**
 * UserDao 인터페이스
 * DB 접근 계층 (Data Access Object)
 */
public interface UserDao {

    /** 전체 사용자 조회 */
    List<User> findAll();

    /** ID로 사용자 조회 */
    User findById(int id);

    /** 사용자 등록 */
    int insert(User user);

    /** 사용자 수정 */
    int update(User user);

    /** 사용자 삭제 */
    int delete(int id);
}
