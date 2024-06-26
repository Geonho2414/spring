package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    //실습 : 고객 전체의 평균 마일리지보다 마일리지가 큰 고객 정보
    @GetMapping("/customers/highmilethanavg")
    public ResponseEntity<List<Customer>> getCustomerWithHighMileThanAvg() {
        return new ResponseEntity<>(customerService.getCustomerWithHighMileThenAvg(),
                HttpStatus.OK);
    }

    //실습 : 마일리지 등급별로 고객수를 보이시오
    @GetMapping("/customers/grade/{grade}")
    public ResponseEntity<List<Customer>> getCustomerByMileageGrade(@PathVariable String grade){
        return new ResponseEntity<>(customerService.getCustomerByMileageGrade(grade), HttpStatus.OK);
    }
}
