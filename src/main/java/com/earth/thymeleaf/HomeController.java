package com.earth.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 1. 원격 프로그램으로 등록
@Controller
public class HomeController {   //원격 프로그램
    // 2. URL과 메서드를 연결
    @RequestMapping("/")
    public String earth() {
        return "index";         // templates/index.html
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("lastName", "Hojin");
        model.addAttribute("firstName", "Chu");

        model.addAttribute("list", Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee"));

        model.addAttribute("bno", 1128);
        return "test";          // templates/test.html
    }
}
