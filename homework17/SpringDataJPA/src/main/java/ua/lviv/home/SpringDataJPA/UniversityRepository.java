package ua.lviv.home.SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    Optional<University> findByName(String name);

    @Query("SELECT u.name as name,u.address as address From University u WHERE u.id=?1")
    UniversityDTO getNameAndAddressById(int id);

    @Query("SELECT u.id as id, u.name as name,u.address as address,u.amountOfStudents as students From University u " +
            "WHERE u.amountOfStudents>?1")
    List<UniversityDTO> findByAmountOfStudentsWhereMoreThan(int amountOfStudents);

    @Modifying
    @Transactional
    @Query("UPDATE University u SET u.name=?2 where u.id=?1")
    void updateNameById(int id, String name);
}
