package ua.lviv.home.SpringWebHomework18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.home.SpringWebHomework18.entities.ParticipantCoverFile;
import ua.lviv.home.SpringWebHomework18.services.ParticipantCoverFileService;

@RestController
@RequestMapping("/participant-cover-files")
public class ParticipantCoverFileRestController {
    @Autowired
    private ParticipantCoverFileService participantCoverFileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("coverFile") MultipartFile file){
        ParticipantCoverFile participantCoverFile = participantCoverFileService.save(file);
        return participantCoverFile.getId();
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId){
        ParticipantCoverFile participantCoverFile = participantCoverFileService.findById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(participantCoverFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + participantCoverFile.getFileName())
                .body(new ByteArrayResource(participantCoverFile.getData()));
    }
}