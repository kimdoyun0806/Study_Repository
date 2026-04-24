package com.hello.controller;

import com.hello.model.User;
import com.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 사용자 CRUD 컨트롤러
 *
 * URL 패턴:
 *   GET  /user/list        → 목록
 *   GET  /user/form        → 등록 폼
 *   POST /user/register    → 등록 처리
 *   GET  /user/edit?id=1   → 수정 폼
 *   POST /user/update      → 수정 처리
 *   GET  /user/delete?id=1 → 삭제 처리
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /** 사용자 목록 */
    @GetMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    /** 등록 폼 */
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    /** 등록 처리 */
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        boolean result = userService.registerUser(user);
        logger.info("사용자 등록 결과: {}", result);
        return "redirect:/user/list";
    }

    /** 수정 폼 */
    @GetMapping("/edit")
    public String editForm(@RequestParam int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/form";
    }

    /** 수정 처리 */
    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        userService.modifyUser(user);
        return "redirect:/user/list";
    }

    /** 삭제 처리 */
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.removeUser(id);
        return "redirect:/user/list";
    }
}
