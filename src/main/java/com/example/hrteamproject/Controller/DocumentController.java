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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    ResponseEntity downloadDocument(@RequestBody DigitalDocument digitalDocument1) {
        DigitalDocument digitalDocument = documentRepository.findByTitle(digitalDocument1.getTitle());
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
    ResponseEntity uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("email") String email) {
        PersonalDocument personalDocument = new PersonalDocument();
        personalDocument.setEmployee(employeeRepository.findByEmail(email));
        personalDocument.setTitle(title);

        String currentTime = getCurrentTime();

        personalDocument.setCreateDate(currentTime);
        personalDocumentRepositoty.save(personalDocument);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String newFileName = title + "_" + employeeRepository.findByEmail(email).getFirstName() + "_" + currentTime + ".pdf";
        Path path = Paths.get(fileBasePath + "/" + newFileName);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName)
                .toUriString();
        return ResponseEntity.ok("Upload Succeed!");

    }

    private String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd-HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        return sdf.format(date);

    }



}
