package gameshop.gameshop.Repository;

import gameshop.gameshop.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
