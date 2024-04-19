package dw.firstapp.service;

import dw.firstapp.exception.ResourceNotFoundException;
import dw.firstapp.model.Employee;
import dw.firstapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    // 의존성주입
    // 모든 repository 의 의존성 주입을 받아야 한다
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee) {
        // repository code - save
        employeeRepository.save(employee);
        return employee;
    }

    //전체직원조회
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //아이디로 직원 조회
    /* Optional<> 이라는 객채로 랩핑을 해야되는 이유
    : 만약 매칭이 되는 아이디가 없으면 null이 된다. 그럼 컴퓨터가 죽는다.
    그러나 Optional<>로 래핑을 하게되면 null이어도 알아서 empty를 true로 세팅해 false를 출력하지 않는다.
     */
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            //예외처리
            throw new ResourceNotFoundException("Employee", "ID", id);
        } else {
            return employee.get();
            // Optional로 포장을 하였기 때문에 바로 return employee 를 하면 안되고
            // employee.get()으로 내용을 가져와야 한다.
        }
    }

    // 아이디로 직원정보 업데이트
    public Employee updateEmployeeById(long id, Employee employee) {
        //ID로 해당데이터 찾기
        Optional<Employee> employee1 = employeeRepository.findById(id);
        if (employee1.isPresent()) {
            // 데이터 업데이트
            employee1.get().setEmail(employee.getEmail());
            employee1.get().setFirstName(employee.getFirstName());
            employee1.get().setLastName(employee.getLastName());
            // 실제로 DB에 저장하기
            employeeRepository.save(employee1.get());
            return employee1.get();
        }else {
            throw new ResourceNotFoundException("Employee", "ID", id);
        }
    }

    public Employee deleteEmployeeById(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            //예외처리
            throw new ResourceNotFoundException("Employee", "ID", id);
        } else {
            employeeRepository.deleteById(id);
            return employee.get();
            // Optional로 포장을 하였기 때문에 바로 return employee 를 하면 안되고
            // employee.get()으로 내용을 가져와야 한다.
        }
    }
}
