package com.example.hrteamproject.Controller;


import com.example.hrteamproject.Dao.DocumentRepository;
import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Dao.PersonalDocumentRepositoty;
import com.example.hrteamproject.Pojo.DigitalDocument;
import com.example.hrteamproject.Pojo.PersonalDocument;
import com.example.hrteamproject.Pojo.RegistrationToken;
import com.example.hrteamproject.Pojo.response.GeneralResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    PersonalDocumentRepositoty personalDocumentRepositoty;

    @Autowired
    EmployeeRepository employeeRepository;

    @Value("${upload.address}")
    String fileBasePath;

    @CrossOrigin
    @GetMapping("/document")
    public @ResponseBody
    ResponseEntity<List<DigitalDocument>> getAllDocuments(){
        List<DigitalDocument> documentList = documentRepository.findAll();
        return ResponseEntity.ok(documentList);
    }

    @CrossOrigin
    @PostMapping("/document/download")
    public @ResponseBody
    ResponseEntity downloadDocument(@RequestBody DigitalDocument digitalDocument) {
        Path path = Paths.get(digitalDocument.getTemplateLocation());
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(digitalDocument.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/document/upload")
    public @ResponseBody
    ResponseEntity uploadDocument(@RequestParam("file") MultipartFile file, @RequestBody PersonalDocument personalDocument, HttpServletRequest request) {
        int id = Integer.valueOf((String)request.getAttribute("employId"));

        personalDocument.setEmployee(employeeRepository.findById(id));

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path path = Paths.get(fileBasePath + fileName);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok("");

    }


}
