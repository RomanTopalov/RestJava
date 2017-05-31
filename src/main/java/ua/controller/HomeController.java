package ua.controller;

import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.entity.TaskManager;
import ua.servise.TaskManagerService;

/**
 * Created by -rom- on 27.05.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private TaskManagerService taskManagerService;

    @GetMapping({ "/", "/home" +
            "" +
            "" })
    public String home(Model model) {

        model.addAttribute("taskManagers" , taskManagerService.findAll());
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String loginprocesing() {
        return "redirect:/home";
    }

    @RequestMapping("/loginpage")
    public String login() {
        return "loginpage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout() {

        return "redirect:/";
    }





}
