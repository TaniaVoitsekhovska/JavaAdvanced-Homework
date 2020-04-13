package ua.lviv.home.SpringCoreProject.dao;

import ua.lviv.home.SpringCoreProject.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentDao implements CRUD {

    List<Student> students = new ArrayList<>();

    @Override
    public Student create(Student student) {
        if(student.getId()==0){
            throw new RuntimeException("id cannot be empty or 0!!!");
        }
        boolean checkStudentByNameExistence = students.stream()
                .anyMatch(std -> std.getId() == student.getId());
        if (!checkStudentByNameExistence) {
//            student.setId(students.size() - 1);
            students.add(student);
            return student;
        } else {
            throw new RuntimeException(String.format("Student with same id=%d already exists!", student.getId()));
        }
    }

    @Override
    public Student readById(int id) {
        Student student = students.stream()
                .filter(std -> std.getId() == id).findFirst()
                .orElseGet(null);
        if (student == null) {
            System.out.println(String.format("There is no student with id=%d", id));
        }
        return student;
    }

    @Override
    public List<Student> readAll() {

        return students;
    }

    @Override
    public Student update(int idToUpdate, Student student) {
        Student studentToUpdate = students.stream()
                .filter(std -> std.getId() == idToUpdate).findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no student with id=%d", idToUpdate)));

        student.setId(idToUpdate);
        students.set(students.indexOf(studentToUpdate), student);
        return student;
    }

    @Override
    public void delete(int id) {
        try {
            students.removeIf(student -> student.getId() == id);
        } catch (Exception e) {
            throw new NoSuchElementException(String.format("There is no student with id=%d", id));
        }
    }


}
