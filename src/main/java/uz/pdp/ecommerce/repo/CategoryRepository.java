package uz.pdp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


}