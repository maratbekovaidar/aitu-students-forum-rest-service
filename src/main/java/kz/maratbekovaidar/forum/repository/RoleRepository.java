package kz.maratbekovaidar.forum.repository;

import kz.maratbekovaidar.forum.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}