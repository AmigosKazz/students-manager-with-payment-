package amigoskazz.spring.repo;

import amigoskazz.spring.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByCode(String code);
    List<Student> findByProgrammId(String programmId);

}
