package dw.firstapp.model;

import jakarta.persistence.*;

// Entity 는 집에 비유하면 가구배치를 바꾸는 것과 같다. 정말 큰 일이기 때문에 함부로 바꾸면 안된다.
// 신중하게 사용하고 자주 공유하자.
@Entity // JPA hibernate 가 읽어서 테이블로 만들어줌
@Table(name = "employees") // 없어도 되지만 데이터는 복수이름을 많이써서 이름을 정의해주는 역할
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Id는 기본적으로 int 를 넘을 가능성이 있기 때문에 Long 형을 사용한다.
    private long id;
    @Column(name = "first_name", nullable = false) //컬럼은 없어도 자동생성되지만 '특성'을 정의해주는 역할을 하기 때문에 정의
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
