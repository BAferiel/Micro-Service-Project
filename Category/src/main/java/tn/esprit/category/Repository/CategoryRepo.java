package tn.esprit.category.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.category.Entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
