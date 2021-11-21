package com.example.basher.controller;

import com.example.basher.domain.Messages;
import com.example.basher.domain.User;
import com.example.basher.repos.MessagesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/")
    public String greeting(
            Map<String, Object> model
    ) {
        Iterable<Messages> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Messages> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String teg, Map<String, Object> model){
        Messages message=new Messages(text, teg, user);
        messagesRepo.save(message);

        Iterable<Messages> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}
