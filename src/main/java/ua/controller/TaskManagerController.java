package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
import ua.entity.TaskManager;
import ua.entity.User;
import ua.servise.TaskManagerService;
import ua.servise.UserService;

/**
 * Created by -rom- on 27.05.2017.
 */
@Controller
public class TaskManagerController {
    @Autowired
    private TaskManagerService taskManagerService;

    @Autowired
    private UserService userService;

    @RequestMapping (value = "/taskManager" , method = RequestMethod.GET)
    public String taskManager(Model model){
        model.addAttribute("taskManager" , new TaskManager());
        model.addAttribute("taskManagers" , taskManagerService.findAll());
        model.addAttribute("user", new User());
        model.addAttribute("users" , userService.findAll() );
        return "taskManager";
    }


    @RequestMapping(value ="/saveTask",method = RequestMethod.POST)
    public String saveTask(@ModelAttribute TaskManager taskManager){

        /*User user = userService.findOne(new User().getId());
        taskManager.setAutor(user.getName());*/
        taskManagerService.save(taskManager);
        return "redirect:/taskManager";
    }

    @RequestMapping(value ="/updateTaskManager/{id}",method = RequestMethod.GET)
    public String updateTask(@PathVariable int id , Model model){

        TaskManager taskManager = taskManagerService.findOne(id);

        model.addAttribute("taskManager" , taskManager);
        model.addAttribute("taskManagers" , taskManagerService.findAll());

        return "updateTaskManager";
    }

    @RequestMapping(value = "/updateTaskManager",method = RequestMethod.POST)
    public String updateTaskSome(@RequestParam String id , @RequestParam String title ,
                             @RequestParam String text,@RequestParam String autor){
        TaskManager taskManager = taskManagerService.findOne(Integer.parseInt(id));
        taskManager.setTitle(title);
        taskManager.setText(text);
        taskManager.setAutor(autor);
        taskManagerService.save(taskManager);
        return "redirect:/taskManager";
    }


    @RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable String id) {

        taskManagerService.delete(Integer.parseInt(id));

        return "redirect:/taskManager";
    }



}
