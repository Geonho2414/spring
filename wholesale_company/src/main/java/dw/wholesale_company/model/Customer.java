package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "고객")
public class Customer {
    @Column(name = "고객번호")
    public String customerId;
    @Column(name = "고객회사명")
    public String customerName;
    @Column(name = "담당자명")
    public String customerEmployee;
    @Column(name = "담당자직위")
    public String employeeTitle;
    @Column(name = "주소")
    public String address;
    @Column(name = "도시")
    public String city;
    @Column(name = "지역")
    public String area;
    @Column(name = "전화번호")
    public String phoneNumber;
    @Column(name = "마일리지")
    public int mileage;
}
