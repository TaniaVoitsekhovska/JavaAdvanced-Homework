package ua.lviv.home.SpringDataJPA;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> saveAll(List<University> universities) {
        return universityRepository.saveAll(universities);
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public Optional<University> findById(int id) {
        return universityRepository.findById(id);
    }

    public Optional<University> findByName(String name) {
        return universityRepository.findByName(name);
    }

    public void deleteById(int id) {
        universityRepository.deleteById(id);
    }

    public UniversityDTO getNameAndAddressById(int id) {
        return universityRepository.getNameAndAddressById(id);
    }

    public List<UniversityDTO> findByAmountOfStudentsWhereMoreThan(int amountOfStudents) {
        return universityRepository.findByAmountOfStudentsWhereMoreThan(amountOfStudents);
    }

    public void updateNameById(int id, String name) {
        universityRepository.updateNameById(id, name);
    }
}
