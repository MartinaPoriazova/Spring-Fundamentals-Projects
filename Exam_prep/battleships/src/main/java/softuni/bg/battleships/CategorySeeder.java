package softuni.bg.battleships;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.battleships.models.Category;
import softuni.bg.battleships.models.enums.ShipType;
import softuni.bg.battleships.repositories.CategoryRepository;

import java.util.Arrays;

@Component
public class CategorySeeder implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(ShipType.values())
                    .map(Category::new)
                    .forEach(category -> this.categoryRepository.save(category));
        }
    }
}
