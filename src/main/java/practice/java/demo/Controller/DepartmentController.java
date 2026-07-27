package practice.java.demo.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import practice.java.demo.dto.DepartmentRequestDTO;
import practice.java.demo.dto.DepartmentResponseDTO;
import practice.java.demo.response.ApiResponse;
import practice.java.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponseDTO>> saveDepartment(
            @Valid @RequestBody DepartmentRequestDTO dto) {

        DepartmentResponseDTO department = departmentService.saveDepartment(dto);

        ApiResponse<DepartmentResponseDTO> response =
                new ApiResponse<>(
                        201,
                        "Department created successfully",
                        department);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DepartmentResponseDTO>>> getAllDepartments() {

        List<DepartmentResponseDTO> departments =
                departmentService.getAllDepartments();

        ApiResponse<List<DepartmentResponseDTO>> response =
                new ApiResponse<>(
                        200,
                        "Departments fetched successfully",
                        departments);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponseDTO>> getDepartmentById(
            @PathVariable Long id) {

        DepartmentResponseDTO department =
                departmentService.getDepartmentById(id);

        ApiResponse<DepartmentResponseDTO> response =
                new ApiResponse<>(
                        200,
                        "Department fetched successfully",
                        department);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponseDTO>> updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDTO dto) {

        DepartmentResponseDTO department =
                departmentService.updateDepartment(id, dto);

        ApiResponse<DepartmentResponseDTO> response =
                new ApiResponse<>(
                        200,
                        "Department updated successfully",
                        department);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        200,
                        "Department deleted successfully",
                        null);

        return ResponseEntity.ok(response);
    }
}