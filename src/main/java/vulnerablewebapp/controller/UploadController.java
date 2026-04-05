package vulnerablewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        // VULNERABLE: no file type validation
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        Files.createDirectories(Paths.get(uploadDir));

        String filePath = uploadDir + file.getOriginalFilename();
        file.transferTo(Paths.get(filePath).toAbsolutePath());

        return "redirect:/home";
    }
}
