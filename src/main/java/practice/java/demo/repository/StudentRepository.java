package practice.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.java.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}

