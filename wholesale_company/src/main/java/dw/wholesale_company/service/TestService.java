package dw.wholesale_company.service;

import dw.wholesale_company.exception.ResourceNotFoundException;
import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Employee;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.CustomerRepository;
import dw.wholesale_company.repository.EmployeeRepository;
import dw.wholesale_company.repository.OrderRepository;
import dw.wholesale_company.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    //1. 도시이름(city)을 매개변수로 받아 그 도시출신의 사원 정보를 보이시오.
    // 내 답
//    public List<Employee> getEmployeeByCity(String city) {
//        List<Employee> employeeList = employeeRepository.findAll();
//        return employeeList.stream()
//                .filter(employee -> employee.getCity().contains(city.toLowerCase()))
//                .collect(Collectors.toList());
//    }
    // 선생님 답
    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employees = employeeRepository.findByCity(city);
        return employees;
    }


    //2. 주문번호를 매개변수(orderId)로 받아 주문한 고객의 정보를 보이시오.
//    // 내 답 - 오답
//    public Customer getCustomerByOrderId(String orderId) {
//        List<Customer> customerList = customerRepository.findAll();
//        Order order = orderRepository.findByOrderId(orderId);
//        Customer customer = new Customer();
//        for (int i = 0; i < customerList.size() ; i++) {
//            if (customerList.get(i).getCustomerId().equals(order.getCustomer())) {
//                customer = customerList.get(i);
//            }
//        }
//        return customer;
//    }
    // 선생님 답
    public Customer getCustomerByOrderId(String orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new ResourceNotFoundException("Order", "ID", orderId);
        }
        return orderOptional.get().getCustomer();
    }


    //3. 주문년도(orderYear)를 매개변수로 받아 그 해의 주문건수(int)를 보이시오.
    // 내 답
//    public int getOrderNumByOrderYear(int orderYear) {
//        List<Order> orderList = orderRepository.findAll();
//        int count = 0;
//        for (int i = 0; i < orderList.size() ; i++) {
//            if (orderList.get(i).getOrderDate().getYear() == orderYear) {
//                count++;
//            }
//        }
//        return count;
//    }
    //선생님 답
    public int getOrderNumByOrderYear(int orderYear) {
        List<Order> orders = orderRepository.findAll();
        return (int)orders.stream()
                .filter(o -> o.getOrderDate().getYear() == orderYear)
                .count();
    }


    //4. 직위(position)와 나이대(year)를 매개변수로 받아 해당정보에 맞는 사원들의 정보를 보이시오.
    // 예를 들어 20대는 매개변수 year=20 이고 나이가 20살이상 30살미만을 의미함.
    // 나이계산은 (올해 - 태어난해)로 계산.
    public List<Employee> getEmployeeByPositionAndYear(String position, int year) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter(e ->
                        e.getPosition().equals(position) &&
                                (LocalDate.now().getYear() - e.getBirthDate().getYear()) >= year
                                && (LocalDate.now().getYear() - e.getBirthDate().getYear()) < (year+10))
                .collect(Collectors.toList());
    }
}
