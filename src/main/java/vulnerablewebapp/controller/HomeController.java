package vulnerablewebapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vulnerablewebapp.repository.CommentRepository;

@Controller
public class HomeController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("comments", commentRepository.findAll());

        return "home";
    }
}