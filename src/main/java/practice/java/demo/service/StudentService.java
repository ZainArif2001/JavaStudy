package practice.java.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.java.demo.dto.StudentNameDTO;
import practice.java.demo.dto.StudentRequestDTO;
import practice.java.demo.dto.StudentResponseDTO;
import practice.java.demo.model.Department;
import practice.java.demo.model.Student;
import practice.java.demo.repository.DepartmentRepository;
import practice.java.demo.repository.StudentRepository;
import practice.java.demo.response.PaginationResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save Student
    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {

        Department department = departmentRepository
                .findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(department);

        Student saved = studentRepository.save(student);

        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setAge(saved.getAge());
        response.setDepartmentName(saved.getDepartment().getName());

        return response;
    }

    // Get Student By Id
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Get All Students
    public PaginationResponse<StudentNameDTO> getAllStudents(Pageable pageable) {

    Page<Student> page = studentRepository.findAll(pageable);

    List<StudentNameDTO> students = new ArrayList<>();

    for (Student student : page.getContent()) {

        StudentNameDTO dto = new StudentNameDTO();

        dto.setName(student.getName());
        dto.setAge(student.getAge());

        students.add(dto);
    }

    PaginationResponse<StudentNameDTO> response =
            new PaginationResponse<>();

    response.setContent(students);
    response.setCurrentPage(page.getNumber());
    response.setTotalPages(page.getTotalPages());
    response.setTotalElements(page.getTotalElements());
    response.setPageSize(page.getSize());

    return response;
    }
    // Update Student
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(department);

        Student updated = studentRepository.save(student);

        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(updated.getId());
        response.setName(updated.getName());
        response.setAge(updated.getAge());
        response.setDepartmentName(updated.getDepartment().getName());

        return response;
    }

    // Delete Student
    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(id);
    }


    public List<StudentNameDTO> searchStudentsByName(String name) {

        List<Student> students = studentRepository.findByNameContainingIgnoreCase(name);
    
        List<StudentNameDTO> dtos = new ArrayList<>();
    
        for (Student student : students) {
    
            StudentNameDTO dto = new StudentNameDTO();
    
            dto.setName(student.getName());
            dto.setAge(student.getAge());
    
            if (student.getDepartment() != null) {
                dto.setDepartmentName(student.getDepartment().getName());
            } else {
                dto.setDepartmentName("No Department");
            }
    
            dtos.add(dto);
        }
    
        return dtos;
    }
}