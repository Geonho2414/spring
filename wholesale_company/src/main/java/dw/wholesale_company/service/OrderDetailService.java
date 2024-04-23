package dw.wholesale_company.service;

import dw.wholesale_company.model.OrderDetail;
import dw.wholesale_company.repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail){
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> getOrderDetail(){
        return orderDetailRepository.findAll();
    }
}
