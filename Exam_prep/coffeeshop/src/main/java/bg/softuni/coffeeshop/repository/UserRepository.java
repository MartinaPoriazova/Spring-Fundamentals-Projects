package bg.softuni.coffeeshop.repository;

import bg.softuni.coffeeshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    @Query("select u from User u order by size(u.orders) desc ")
    List<User> findByOrdersOrderByOrdersSize();
}

