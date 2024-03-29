package bg.softuni.shoppinglist.repository;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.enums.CategoryTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryTypeEnum name);
}
