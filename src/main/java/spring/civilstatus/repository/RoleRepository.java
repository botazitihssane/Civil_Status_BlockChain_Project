package spring.civilstatus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.civilstatus.models.ERole;
import spring.civilstatus.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}