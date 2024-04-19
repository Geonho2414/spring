package dw.firstapp.controller;

import dw.firstapp.model.Employee;
import dw.firstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    // 의존성 주입 - 필드 주입
    // @Autowired
    EmployeeService employeeService;

    // 매개변수를 사용한 생성자 *기본생성자 필요 X
    // 의존성 주입 생성자 주입(권장!!)
    // 필드주입은 AutoWired 를 필드마다 꼭 다 달아줘야 되지만
    // 생성자주입은 생성자 안에 다 떄려넣으면 @Autowired 를 한번만 해도 됨
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        // service
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    // 전체직원조회
    @GetMapping("api/employee") // 이름은 위의 것과 같아도 post get이 다르기 때문에 상관 X
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // 아이디로 직원조회
    @GetMapping("api/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // 아이디로 직원정보 업데이트
    @PutMapping("api/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id,
                                       @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployeeById(id, employee), HttpStatus.OK);
    }

    // 아이디로 직원정보 삭제
    @DeleteMapping("api/employee/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable long id){
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }
}
