package practice.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.java.demo.model.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
