package pl.hotowy.springsecurity.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hotowy.springsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
