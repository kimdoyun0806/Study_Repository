package com.hello;

import com.hello.model.User;
import com.hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * UserService 통합 테스트
 * root-context.xml을 로드하여 실제 DB 연동 테스트
 *
 * 실행 전: PostgreSQL에 users 테이블 생성 및 db.properties DB 정보 설정 필요
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserList() {
        List<User> list = userService.getUserList();
        assertNotNull(list);
        System.out.println("전체 사용자 수: " + list.size());
    }

    @Test
    public void testRegisterAndDelete() {
        User user = new User("테스트유저", "test@example.com", "password123");
        boolean inserted = userService.registerUser(user);
        assertTrue("등록 실패", inserted);

        List<User> list = userService.getUserList();
        User found = list.stream()
            .filter(u -> "test@example.com".equals(u.getEmail()))
            .findFirst()
            .orElse(null);
        assertNotNull("등록된 유저를 찾지 못함", found);

        boolean deleted = userService.removeUser(found.getId());
        assertTrue("삭제 실패", deleted);
    }
}
