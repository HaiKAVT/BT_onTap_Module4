package codegym.service;

import codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IStudentService{
    Student save(Student student);

    Student findById(long id);

    ArrayList<Student> findAll();
    ArrayList<Student> findAllByName(String name);
    Page<Student> findAll(Pageable pageable);

    void delete(Student student);
}
