package gameshop.gameshop.Repository;

import gameshop.gameshop.Model.Gameshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameshopRepository extends JpaRepository<Gameshop, Long> {
}
