package practice.java.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.java.demo.dto.DepartmentRequestDTO;
import practice.java.demo.dto.DepartmentResponseDTO;
import practice.java.demo.model.Department;
import practice.java.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save Department
    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO dto) {

        Department department = new Department();
        department.setName(dto.getName());

        Department saved = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());

        return response;
    }

    // Get All Departments
    public List<DepartmentResponseDTO> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        List<DepartmentResponseDTO> response = new ArrayList<>();

        for (Department department : departments) {

            DepartmentResponseDTO dto = new DepartmentResponseDTO();

            dto.setId(department.getId());
            dto.setName(department.getName());

            response.add(dto);
        }

        return response;
    }

    // Get Department By Id
    public DepartmentResponseDTO getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            throw new RuntimeException("Department not found");
        }

        DepartmentResponseDTO dto = new DepartmentResponseDTO();

        dto.setId(department.getId());
        dto.setName(department.getName());

        return dto;
    }

    // Update Department
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO dto) {

        Department department = departmentRepository.findById(id).orElse(null);

        if (department == null) {
            throw new RuntimeException("Department not found");
        }

        department.setName(dto.getName());

        Department updated = departmentRepository.save(department);

        DepartmentResponseDTO response = new DepartmentResponseDTO();

        response.setId(updated.getId());
        response.setName(updated.getName());

        return response;
    }

    // Delete Department
    public void deleteDepartment(Long id) {

        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }

        departmentRepository.deleteById(id);
    }

}