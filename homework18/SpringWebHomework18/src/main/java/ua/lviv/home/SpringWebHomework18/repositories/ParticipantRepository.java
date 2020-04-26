package ua.lviv.home.SpringWebHomework18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.home.SpringWebHomework18.entities.Participant;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("select p.coverId from Participant p where p.id = :participantId")
    Optional<String> getCoverIdByParticipantId(@Param("participantId") int participantId);
}
