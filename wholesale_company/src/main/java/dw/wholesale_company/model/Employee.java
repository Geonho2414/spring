package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "사원")
public class Employee {
    @Column(name = "사원번호")
    public String employeeId;
    @Column(name = "이름")
    public String name;
    @Column(name = "영문이름")
    public String englishName;
    @Column(name = "직위")
    public String position;
    @Column(name = "성별")
    public String gender;
    @Column(name = "생일")
    public LocalDate birthDate;
    @Column(name = "입사일")
    public LocalDate hireDate;
    @Column(name = "주소")
    public String address;
    @Column(name = "도시")
    public String city;
    @Column(name = "지역")
    public String area;
    @Column(name = "집전화")
    public String telephoneNo;
    @Column(name = "상사번호")
    public String managerId;
    @Column(name = "부서번호")
    public String department;
}
