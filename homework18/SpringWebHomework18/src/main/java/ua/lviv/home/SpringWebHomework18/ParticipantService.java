package ua.lviv.home.SpringWebHomework18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }
    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public void save(ParticipantRequest participantRequest) {
        Participant participant=new Participant(participantRequest.getName(),participantRequest.getEmail(),
                participantRequest.getLevel(),participantRequest.getPrimarySkill());
        participantRepository.save(participant);
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Participant findById(int id) {
        return participantRepository.getOne(id);
    }

    public Optional<Participant> findOne(int id) {
        return participantRepository.findById(id);
    }

    public Participant update(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteById(int id) {
        participantRepository.deleteById(id);
    }

}
