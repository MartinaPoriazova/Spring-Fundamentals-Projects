package softuni.bg.battleships.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.battleships.models.Category;
import softuni.bg.battleships.models.enums.ShipType;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(ShipType name);
}