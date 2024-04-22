package dw.gameshop.Repository;

import dw.gameshop.Model.Gameshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameshopRepository extends JpaRepository<Gameshop, Long> {
    // JPQL 적용
    // Top 1 뽑기
    @Query("select g1 from Gameshop g1 where g1.price = (select max(g2.price) from Gameshop g2)")
    Gameshop getGameWithMaxPrice();
    // Top 2 뽑기
    @Query("select g1 from Gameshop g1 order by g1.price desc")
    public List<Gameshop> getGameWithMaxPriceTop3();
}
