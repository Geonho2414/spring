package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "제품")
public class Product {
    @Id
    @Column(name="제품번호")
    private int productId;
    @Column(name = "제품명")
    private String productName;
    @Column(name = "포장단위")
    private String pkgUnit;
    @Column(name = "단가")
    private int unitPrice;
    @Column(name = "재고")
    private int inventory;
}
