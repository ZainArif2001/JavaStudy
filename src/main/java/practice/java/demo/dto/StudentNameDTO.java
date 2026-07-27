package practice.java.demo.dto;

public class StudentNameDTO {

    private String name;
    private int age;
    private String departmentName;

    public StudentNameDTO() {
    }

    public StudentNameDTO(String name, int age, String departmentName) {
        this.name = name;
        this.age = age;
        this.departmentName = departmentName;
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