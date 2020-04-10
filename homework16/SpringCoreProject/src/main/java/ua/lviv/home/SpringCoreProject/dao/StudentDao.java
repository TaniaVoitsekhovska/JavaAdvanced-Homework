package ua.lviv.home.SpringCoreProject.dao;

import ua.lviv.home.SpringCoreProject.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements CRUD {

    List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        student.setId(students.size());
        students.add(student);
        return student;
    }

    @Override
    public Student readById(int id) {
        Student student = students.get(id - 1);
        return student;
    }

    @Override
    public List<Student> readAll() {

        return students;
    }

    @Override
    public Student update(int id,Student student) {
        student.setId(id-1);
        students.set(id - 1, student);
        return student;
    }

    @Override
    public void delete(int id) {
        students.remove(id - 1);
    }


}
