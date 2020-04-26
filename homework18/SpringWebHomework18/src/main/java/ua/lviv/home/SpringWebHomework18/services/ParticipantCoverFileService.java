package ua.lviv.home.SpringWebHomework18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.home.SpringWebHomework18.entities.ParticipantCoverFile;
import ua.lviv.home.SpringWebHomework18.repositories.ParticipantCoverFileRepository;

import java.io.IOException;

@Service
public class ParticipantCoverFileService {
    private final ParticipantCoverFileRepository participantCoverFileRepository;

    @Autowired
    public ParticipantCoverFileService(ParticipantCoverFileRepository participantCoverFileRepository) {
        this.participantCoverFileRepository = participantCoverFileRepository;
    }

    public ParticipantCoverFile save(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            ParticipantCoverFile participantCoverFile =
                    new ParticipantCoverFile(fileName, file.getContentType(), file.getBytes());
            return participantCoverFileRepository.save(participantCoverFile);
        } catch (IOException ex) {
            throw new RuntimeException(String.format("Can't save file %s", fileName));
        }
    }

    public ParticipantCoverFile findById(String fileId){
        return participantCoverFileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException(String.format("File not found with id =%s ",fileId)));
    }
}
