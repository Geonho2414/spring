package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    // 실습 : 주문일이 5월 1일 이후인 주문 정보 얻기
    @GetMapping("/orders/date/after/{date}")
    public ResponseEntity<List<Order>> getOrderByDateAfter(@PathVariable LocalDate date) {
        return new ResponseEntity<>(orderService.getOrderByDateAfter(date), HttpStatus.OK);
    }

    // 2020년 4월 9일에 주문한 고객의 모든 정보를 보이시오.
    // .map 사용
    @GetMapping("/orders/date/customers/{date}")
    public ResponseEntity<List<Customer>> getCustomerByOrderDate(@PathVariable LocalDate date) {
        return new ResponseEntity<>(orderService.getCustomerByOrderDate(date), HttpStatus.OK);
    }
}
