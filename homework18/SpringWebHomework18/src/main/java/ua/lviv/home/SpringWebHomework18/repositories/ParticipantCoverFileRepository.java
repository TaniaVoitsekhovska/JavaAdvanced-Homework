package ua.lviv.home.SpringWebHomework18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.home.SpringWebHomework18.entities.ParticipantCoverFile;

@Repository
public interface ParticipantCoverFileRepository extends JpaRepository<ParticipantCoverFile, String> {

}
