package vulnerablewebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vulnerablewebapp.repository.UserRepository;
import vulnerablewebapp.repository.CommentRepository;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("comments", commentRepository.findAll());
        return "admin";
    }
}