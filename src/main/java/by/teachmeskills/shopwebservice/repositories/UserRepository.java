package by.teachmeskills.shopwebservice.repositories;

import by.teachmeskills.shopwebservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
