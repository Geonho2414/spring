package dw.gameshop.Repository;

import dw.gameshop.Model.Gameshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameshopRepository extends JpaRepository<Gameshop, Long> {
}
