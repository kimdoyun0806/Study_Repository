package com.hello.dao;

import com.hello.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * UserDao 구현체
 * Spring JdbcTemplate을 사용한 DB 접근
 *
 * 사전 준비: DB에 아래 테이블 생성 필요
 * CREATE TABLE users (
 *     id       SERIAL PRIMARY KEY,
 *     name     VARCHAR(50)  NOT NULL,
 *     email    VARCHAR(100) NOT NULL UNIQUE,
 *     password VARCHAR(255) NOT NULL
 * );
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /** ResultSet → User 객체 변환 */
    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, name, email, password FROM users ORDER BY id";
        logger.debug("findAll SQL: {}", sql);
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT id, name, email, password FROM users WHERE id = ?";
        logger.debug("findById SQL: {}, id={}", sql, id);
        List<User> result = jdbcTemplate.query(sql, userRowMapper, id);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        logger.debug("insert user: {}", user);
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword());
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE users SET name=?, email=?, password=? WHERE id=?";
        logger.debug("update user: {}", user);
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        logger.debug("delete user id={}", id);
        return jdbcTemplate.update(sql, id);
    }
}
