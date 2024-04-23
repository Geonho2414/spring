package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "주문")
public class Order {
    @Column (name = "주문번호")
    private String orderId;
    @Column (name = "고객번호")
    private String customer;
    @Column (name = "사원번호")
    private String employee;
    @Column (name = "주문일")
    private LocalDate orderDate;
    @Column (name = "요청일")
    private LocalDate requestDate;
    @Column (name = "발송일")
    private LocalDate shippingDate;
}

