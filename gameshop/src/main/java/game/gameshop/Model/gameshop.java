package game.gameshop.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "gameshopdb")
public class gameshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "genre", nullable = false, length = 100)
    private String genre;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "image", length = 65535)
    private String image;
    @Column(name = "text", length = 65535)
    private String text;
}
