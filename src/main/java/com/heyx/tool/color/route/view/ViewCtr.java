package com.heyx.tool.color.route.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author heyx
 * @date 7/16/2020 7:37 PM
 */
@Controller
public class ViewCtr {
    @GetMapping("/")
    public String main() {
        return "redirect:/home";
    }
    @GetMapping("/index")
    public String index() {
        return "views/index";
    }
    @GetMapping("/home")
    public String home() {
        return "views/home";
    }
}
