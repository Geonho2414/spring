package dw.wholesale_company.service;

import dw.wholesale_company.model.Employee;
import dw.wholesale_company.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //실습 : 사원의 직위가 '사원'인 사람들 중에서 가장 최근에 입사한 사원의 정보
    public Employee getEmployeeByHireLatest(){
        return employeeRepository.findAll()
                .stream().filter(e->e.getPosition().equals("사원"))
                .sorted(Comparator.comparing(Employee::getHireDate).reversed())
                .findFirst().get();
    }
}
