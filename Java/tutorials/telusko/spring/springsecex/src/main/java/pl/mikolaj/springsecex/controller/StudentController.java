package pl.mikolaj.springsecex.controller;

import org.springframework.web.bind.annotation.*;
import pl.mikolaj.springsecex.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", 85),
            new Student(2, "Jane", 90),
            new Student(3, "Bob", 78)
    ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
