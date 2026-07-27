package practice.java.demo.dto;

public class StudentResponseDTO {

    private Long id;
    private String name;
    private int age;
    private String departmentName;

    public StudentResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}