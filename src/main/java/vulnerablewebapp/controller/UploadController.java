@PostMapping("/upload")
public String uploadFile(MultipartFile file) throws IOException {

    String uploadDir = "uploads/";
    File dir = new File(uploadDir);
    if (!dir.exists()) {
        dir.mkdirs();
    }

    String filePath = uploadDir + file.getOriginalFilename();
    file.transferTo(new File(filePath));

    return "redirect:/home";
}