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
import ua.validator.UserValidationMessages;

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

        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD)
                    || e.getMessage().equals(UserValidationMessages.NAME_ALREADY_EXIST)) {
                model.addAttribute("usernameException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_EMAIl_FIELD)
                    || e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)) {
                model.addAttribute("emailException", e.getMessage());
            } else if (e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)) {
                model.addAttribute("passwordException", e.getMessage());
            }
            return "registration";
        }

        String theme = "thank's for registration";
        String mailBody = "Click to confirm http://localhost:8080/confirm/" + uuid;

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







