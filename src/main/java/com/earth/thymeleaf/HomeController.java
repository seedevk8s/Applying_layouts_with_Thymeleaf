package com.earth.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 프로그램으로 등록
@Controller
public class HomeController {   //원격 프로그램
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String earth() {
        return "index";         // templates/index.html
    }
}