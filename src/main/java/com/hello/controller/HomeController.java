package com.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 메인 홈 컨트롤러
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /** GET / → home.jsp */
    @GetMapping
    public String home(Model model) {
        logger.info("홈 페이지 요청");
        model.addAttribute("message", "Spring Framework 학습 프로젝트에 오신 것을 환영합니다!");
        return "home";  // → /WEB-INF/views/home.jsp
    }
}
