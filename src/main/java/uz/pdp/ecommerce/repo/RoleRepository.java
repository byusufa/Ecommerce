package uz.pdp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}