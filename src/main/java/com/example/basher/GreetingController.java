package com.example.basher;

import com.example.basher.domain.Messages;
import com.example.basher.repos.MessagesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Messages> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String teg, Map<String, Object> model){
        Messages message=new Messages(text, teg);
        messagesRepo.save(message);

        Iterable<Messages> messages = messagesRepo.findAll();
        model.put("messages", messages);
        return "main";
    }
}
