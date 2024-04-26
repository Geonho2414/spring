package dw.wholesale_company.repository;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByOrderDate(LocalDate orderDate);

    Order findByOrderId(String orderId);
}
