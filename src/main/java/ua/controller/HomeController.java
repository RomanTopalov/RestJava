package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by -rom- on 16.02.2017.
 */
@Controller
public class HomeController {
    @GetMapping({ "/", "/home" })
    public String home() {

        return "home";
    }
    @RequestMapping(value = "/human", method = RequestMethod.GET)
    public  String human(Model model){



        return "human";
    }
}
