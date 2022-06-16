package softuni.bg.battleships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.battleships.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
