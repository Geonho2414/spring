package dw.jdbcproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// Entity 는 Jpa 이기 때문에 사용 불가
public class Member {
    private long id;
    private String name;
}
