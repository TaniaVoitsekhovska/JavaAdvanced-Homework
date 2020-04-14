package ua.lviv.home.SpringCoreProject.dao;

import ua.lviv.home.SpringCoreProject.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CRUD {

    Student create(Student student);

    Optional<Student> readById(int id);

    List<Student> readAll();

    Student update(int id,Student student);

    void delete(int id);
}
