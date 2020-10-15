package com.example.abuseapp.speaknativeappjava.controllers;

import com.example.abuseapp.speaknativeappjava.models.Phrase;
import com.example.abuseapp.speaknativeappjava.models.User;
import com.example.abuseapp.speaknativeappjava.repositories.PhraseRepo;
import com.example.abuseapp.speaknativeappjava.services.UserService;
import com.example.abuseapp.speaknativeappjava.services.UserServiceImpl;
import com.example.abuseapp.speaknativeappjava.logging.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@Controller
public class UserController implements ApplicationContextAware {

    private final UserService userService;
    private final PhraseRepo phraseRepo;

    private ApplicationContext applicationContext;

    @Autowired
    public UserController(UserService userService, PhraseRepo phraseRepo)
    {
        this.userService = userService;
        this.phraseRepo = phraseRepo;
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("users", userService.getAll());
        return "users/users-all";
    }

    @RequestMapping("/{id}")
    public String index(@PathVariable("id") UUID id)
    {
        var sb = new StringBuilder();
        sb.append("Hello :");
        sb.append(id);
        sb.append("\r\n");

        var res = phraseRepo.findAllById(Arrays.asList(id));
        for(Phrase item : res)
            sb.append(" : " + item.toString());

        return sb.toString();
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public String createUser(Model model)
    {
        model.addAttribute("user", new User());

        return "users/users-create";
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public RedirectView createUserPost(
            @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model)
    {
        var newUser = userService.createUser(user.getEmail(), generateRandom(10));

        return new RedirectView("/");
    }

    @RequestMapping(value = "/users/delete/{id}")
    public RedirectView delete(@PathVariable("id") UUID id)
    {
        userService.delete(id);

        return new RedirectView("/");
    }


    private String generateRandom(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
