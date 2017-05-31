package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dto.DtoUtilMapper;
import ua.entity.User;
import ua.servise.MailSenderService;
import ua.servise.UserService;

import java.util.UUID;

/**
 * Created by -rom- on 27.05.2017.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("userDTOs", DtoUtilMapper.usersToUsersDTO(userService.findAll()));
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String newUser(@PathVariable int id) {

        userService.delete(id);

        return "redirect:/registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, Model model) throws Exception {

        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

        userService.save(user);
        String theme = "thank's for registration";
        String mailBody = "gl & hf       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

        return "redirect:/";
    }

    @RequestMapping(value = "/confirm/{uuid}", method = RequestMethod.GET)
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUUID(uuid);
        user.setEnabled(true);

        userService.update(user);

        return "redirect:/";
    }


}







