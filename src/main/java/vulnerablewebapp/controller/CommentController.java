package vulnerablewebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vulnerablewebapp.model.Comment;
import vulnerablewebapp.repository.CommentRepository;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("comments", commentRepository.findAll());
        return "home";
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam String username,
                             @RequestParam String content) {
        Comment comment = new Comment(username, content);
        commentRepository.save(comment);
        return "redirect:/home";
    }
}