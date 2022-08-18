package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // 서버 사이드 랜더링
    @GetMapping("hello") // http://localhost:8080/hello 뒤에 hello 붙여줌
    public String hello(Model model){
        model.addAttribute("data", "hello!!!!!"); // 데이터를 담아서 넘긴다.
        return "hello"; // 화면 이름 '.html'이 자동으로 붇는다.
    }
}
