package vulnerablewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename != null ?
            originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase() : "";

        List<String> allowedExtensions = List.of("jpg", "jpeg", "png", "gif", "pdf", "txt");

        if (!allowedExtensions.contains(extension)) {
            model.addAttribute("error", "File type not allowed: ." + extension);
            return "upload";
        }

        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        Files.createDirectories(Paths.get(uploadDir));
        file.transferTo(Paths.get(uploadDir + originalFilename).toAbsolutePath());

        return "redirect:/home";
    }
}
