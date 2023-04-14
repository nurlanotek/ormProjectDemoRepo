package org.uca.sas.cs.course1.lesson5.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uca.sas.cs.course1.lesson5.model.Message;
import org.uca.sas.cs.course1.lesson5.service.MessageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.test.util.AssertionErrors.assertTrue;


@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public String getHomePage(Message message, Model model) {
        model.addAttribute("greetings", this.messageService.getMessages());
        return "chat";
    }

    @PostMapping()
    public String addMessage(Message message, Model model) {
        messageService.addMessage(message);
        model.addAttribute("greetings", messageService.getMessages());
        message.setMessagetext("");
        return "chat";
    }
}
