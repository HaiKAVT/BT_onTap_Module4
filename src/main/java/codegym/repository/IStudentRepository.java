package codegym.repository;

import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface IStudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Query(value = "select c from Student as c where c.name like  concat('%', :name ,'%') ")
    ArrayList<Student> findAllByName(@Param("name") String name);
}
