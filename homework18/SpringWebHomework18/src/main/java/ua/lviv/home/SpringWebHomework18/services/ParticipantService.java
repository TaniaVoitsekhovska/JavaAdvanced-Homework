package ua.lviv.home.SpringWebHomework18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.home.SpringWebHomework18.entities.Participant;
import ua.lviv.home.SpringWebHomework18.entities.ParticipantRequest;
import ua.lviv.home.SpringWebHomework18.repositories.ParticipantCoverFileRepository;
import ua.lviv.home.SpringWebHomework18.repositories.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;
    private final ParticipantCoverFileRepository coverFileRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository,
                              ParticipantCoverFileRepository coverFileRepository) {
        this.participantRepository = participantRepository;
        this.coverFileRepository = coverFileRepository;
    }
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public void save(ParticipantRequest participantRequest) {
        Participant participant=new Participant(participantRequest.getName(),participantRequest.getEmail(),
                participantRequest.getLevel(),participantRequest.getPrimarySkill(),participantRequest.getCoverId());
        participantRepository.save(participant);
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

//    public Participant findById(int id) {
//        return participantRepository.getOne(id);
//    }

    public Optional<Participant> findOne(int id) {
        return participantRepository.findById(id);
    }

    public Participant update(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteById(int id) {
        participantRepository.getCoverIdByParticipantId(id).ifPresent(coverFileRepository::deleteById);
        participantRepository.deleteById(id);
    }

}
