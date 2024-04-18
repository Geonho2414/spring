package dw.firstapp.controller;

import dw.firstapp.model.Student;
import dw.firstapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudenController {

    // 이게 Bean. component가 있는곳은 Bean선언
    @Autowired
    StudentService studentService;

    //객체하나 보내주기
    @GetMapping("/Student")
    public Student getStudent(){
        return new Student("Tom","Smith");
    }

    //객체 리스트에 묶어서 보냄
    @GetMapping("/Student2")
    public List<Student> getStudent2() {
        List<Student> student2 = new ArrayList<>();
        student2.add(new Student("Tom","Smith"));
        student2.add(new Student("John","Long"));
        student2.add(new Student("JJ","JJ"));
        student2.add(new Student("Leon","red"));
        student2.add(new Student("Yunji","SD"));
        return student2;
    }

    //사용자 입력 보내주기
    @GetMapping("/Student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable String firstname, @PathVariable String lastname) {
        return new Student(firstname, lastname);
    }

    @GetMapping("/Student/query")
    // localhost:8080/Student/query?firstName=John&lastName=Cho
    public Student studentRequestParam(@RequestParam String firstName, @RequestParam String lastName) {
        return new Student(firstName, lastName);
    }

    @PostMapping("/Student/post")
    // 이거는 포스트맨에서만 가능 브라우저X
    public Student studentPost(@RequestBody Student student) {
        System.out.println(student.getFirstName() +" "+ student.getLastName());
        return new Student(student.getFirstName(), student.getLastName());
    }

    @GetMapping("/Student/score/{firstName}/{lastName}")
    public int getStudentScore(@PathVariable String firstName, @PathVariable String lastName) {
        Student student = new Student(firstName, lastName);
        //StudentService 는 Bean 이므로 인스턴스화하지 않는다.
        //StudentService studentService = new StudentService();
        return studentService.getStudentScore(student);
    }
}