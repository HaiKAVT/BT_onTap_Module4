package codegym.service;

import codegym.model.Student;
import codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public ArrayList<Student> findAll() {
        return (ArrayList<Student>) studentRepository.findAll();
    }

    @Override
    public ArrayList<Student> findAllByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);

    }
}
