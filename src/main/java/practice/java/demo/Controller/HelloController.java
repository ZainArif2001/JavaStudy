package practice.java.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello Spring Boot!";
    }
    @GetMapping("/hello")
    public String hello() {
        String name = "John Doe";
        int age = 30;
        String message = "Hello, my name is " + name + " and I am " + age + " years old.";
        return message;
    }
    @GetMapping("/greet")
    public String studentdetails(){
        String std_name = "zain";
        int st_age = 20;
        String message = "Hello, my name is " + std_name + " and I am " + st_age + " years old.";
        return message;
    }

    // export JAVA_HOME=/usr/lib/jvm/java-25-openjdk-amd64
    // export PATH=$JAVA_HOME/bin:$PATH
    // hash -r
}