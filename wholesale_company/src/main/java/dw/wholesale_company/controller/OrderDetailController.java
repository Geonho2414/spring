package dw.wholesale_company.controller;

import dw.wholesale_company.model.OrderDetail;
import dw.wholesale_company.service.OrderDetailService;
import dw.wholesale_company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/orderdetail")
    public ResponseEntity<OrderDetail> saveOrderDetail(@RequestBody OrderDetail orderDetail){
        return new ResponseEntity<>(orderDetailService.saveOrderDetail(orderDetail), HttpStatus.OK);
    }

    @GetMapping("/orderdetails")
    public ResponseEntity<List<OrderDetail>> getOrderDetail(){
        return new ResponseEntity<>(orderDetailService.getOrderDetail(), HttpStatus.OK);
    }
}
