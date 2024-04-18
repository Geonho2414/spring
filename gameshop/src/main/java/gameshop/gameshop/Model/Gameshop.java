package gameshop.gameshop.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "gameshopdb")
public class Gameshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "title", nullable = false, length = 100)
    public String title;
    @Column(name = "genre", nullable = false, length = 100)
    public String genre;
    @Column(name = "price")
    public int price;
    @Column(name = "image", length = 65535)
    public String image;
    @Column(name = "text", length = 65535)
    public String text;

    public Gameshop() {
    }

    public Gameshop(long id, String title, String genre, int price, String image, String text) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.image = image;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


