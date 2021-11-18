package kz.maratbekovaidar.forum.repository;

import kz.maratbekovaidar.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
