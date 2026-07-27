package practice.java.demo.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import practice.java.demo.dto.StudentNameDTO;
import practice.java.demo.dto.StudentRequestDTO;
import practice.java.demo.dto.StudentResponseDTO;
import practice.java.demo.model.Student;
import practice.java.demo.response.ApiResponse;
import practice.java.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDTO>> saveStudent(@Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO student = studentService.saveStudent(dto);

        ApiResponse<StudentResponseDTO> response =
                new ApiResponse<>(
                        201,
                        "Student created successfully",
                        student
                );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>(
                        200,
                        "Student fetched successfully",
                        student
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentNameDTO>>> getAllStudents() {

        List<StudentNameDTO> students = studentService.getAllStudents();

        ApiResponse<List<StudentNameDTO>> response =
                new ApiResponse<>(
                        200,
                        "Students fetched successfully",
                        students
                );

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(@PathVariable Long id,@Valid @RequestBody StudentRequestDTO dto) {
    
        StudentResponseDTO updatedStudent = studentService.updateStudent(id, dto);
        ApiResponse<StudentResponseDTO> response =
                new ApiResponse<>(
                        200,
                        "Student updated successfully",
                        updatedStudent
                );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        200,
                        "Student deleted successfully",
                        null
                );

        return ResponseEntity.ok(response);
    }
}