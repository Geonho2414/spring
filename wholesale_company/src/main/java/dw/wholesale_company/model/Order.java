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
    public String orderId;
    @Column (name = "고객번호")
    public String customer;
    @Column (name = "사원번호")
    public String employee;
    @Column (name = "주문일")
    public LocalDate orderDate;
    @Column (name = "요청일")
    public LocalDate requestDate;
    @Column (name = "발송일")
    public LocalDate shippingDate;
}

