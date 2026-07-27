package practice.java.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {

    @NotBlank(message = "Student name is required")
    private String name;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age cannot be greater than 100")
    private int age;

    @NotNull(message = "Department is required")
    private Long departmentId;

    public StudentRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}