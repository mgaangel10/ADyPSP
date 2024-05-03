package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.StorageService;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileController {

    private final StorageService service;

    @Autowired
    public FileController(StorageService service){
        this.service = service;
    }
    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", service.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = service.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        service.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    //subir fichero atraves de una peticion post utilizar requestParam
    @PostMapping("subida/fichero")
    public ResponseEntity<?> subidaFichero(@RequestPart("file") MultipartFile multipartFile){
        FileResponse response = uploadFile(multipartFile);
    }

    private FileResponse uploadFile(MultipartFile multipartFile){
        String nombre = service.store(multipartFile);
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/dowland")
                .path(nombre)
                .toUriString();
        return FileResponse
    }
}
