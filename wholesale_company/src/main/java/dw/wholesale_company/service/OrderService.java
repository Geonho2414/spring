package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }



    // 실습 : 주문일이 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOrderByDateAfter(LocalDate date) {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().filter(a -> a.getOrderDate().compareTo(date)>0).collect(Collectors.toList());
    }

    // 2020년 4월 9일에 주문한 고객의 모든 정보를 보이시오.
    // .map 사용
    // 내 답
    /*
    public List<Customer> getCustomerByOrderDate(LocalDate date) {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream()
                .filter(a -> a.getOrderDate().equals(date))
                .map(c->c.getCustomer()).collect(Collectors.toList());
    }
     */
    // 선생님 답
    public List<Customer> getCustomerByOrderDate(LocalDate orderDate) {
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        return orders.stream().map(order -> order.getCustomer())
                .collect(Collectors.toList());
    }

    //도시별로 주문금액합을 보이되 주문금액합이 많은 상위 5개의 도시에 대한 결과만 보이시오.
    public List<Object[]> getTopCitiesByTotalOrderAmount(int limit) {
        List<Object[]> cities = orderRepository.getTopCitiesByTotalOrderAmount();
        return cities.stream().limit(limit).collect(Collectors.toList());
//        return entityManager.createQuery(
//                        "SELECT c.city, SUM(od.orderQuantity * od.unitPrice) " +
//                                "FROM OrderDetail od " +
//                                "JOIN od.order o " +
//                                "JOIN o.customer c " +
//                                "GROUP BY c.city " +
//                                "ORDER BY SUM(od.orderQuantity * od.unitPrice) DESC")
//                .setMaxResults(limit)
//                .getResultList();
    }

    //‘서울특별시’ 고객들에 대해 주문년도별 주문건수를 보이시오
    public List<Object[]> getOrderCountByYearForCity(String city) {
        return orderRepository.getOrderCountByYearForCity(city);
    }
}
