package gameshop.gameshop.Repository;

import gameshop.gameshop.Model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
