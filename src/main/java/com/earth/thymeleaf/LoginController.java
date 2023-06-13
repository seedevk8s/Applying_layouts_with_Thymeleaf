package com.earth.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    //@RequestMapping("/login/login")
    //@RequestMapping(value = "/login/login", method = RequestMethod.GET)
    @GetMapping("/login")
    public String showLogin() {
        return "login";         //login.html
    }

    // 하나의 메서드로 GET, POST 둘다 처리하는 경우
    //@RequestMapping(value = "/login/login", method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/login")
    public String login(HttpServletRequest request, String id, String pwd, RedirectAttributes model) throws UnsupportedEncodingException {
        // 1. id, pwd를 확인
        if (loginCheck(id, pwd)) {
            // 2. 일치하면, userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);

            return "userInfo";              // userInfo.html
        } else {
            //    일치하지 않으면, login.html로 이동
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            model.addAttribute("msg", msg);
            model.addFlashAttribute("msg", "일회용 메시지");  //session에 잠깐 저장되었다가 삭제됨
            request.setAttribute("msg", "request에 저장된 msg");

            return "forward:/";
            //return "forward:/login/login";          // /login/login POST 요청임 => 이렇게되면 무한루프가 됨
            //return "redirect:/login/login?msg="+msg;        //GET 요청 - URL 재작성
        }

    }

    private boolean loginCheck(String id, String pwd) {
        return ("earth").equals(id) && ("0630").equals(pwd);

    }
}


