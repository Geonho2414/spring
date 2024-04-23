package dw.gameshop.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "game")
    private Gameshop gameshop;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @Column(name = "point")
    private int point;
    @Column(name = "review_text", length = 65535)
    private String reviewText;
    //한번 생성된 날짜는 바뀌면 안되기 때문에 updatable = false 는
    //업데이트가 불가능하게 해준다.
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
