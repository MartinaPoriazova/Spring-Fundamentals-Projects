package bg.softuni.shoppinglist.repository;

import bg.softuni.shoppinglist.model.entity.Product;
import bg.softuni.shoppinglist.model.enums.CategoryTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findAllByCategoryName(CategoryTypeEnum food);

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalPriceSum();
}
