package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by -rom- on 13.02.2017.
 */
@Controller
public class HumanController  {


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home(Model model) {

        return "home";
    }
}
