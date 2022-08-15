package bg.softuni.shoppinglist.seeder;

import bg.softuni.shoppinglist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryService categoryService;

    @Autowired
    public CategorySeeder(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.categoryService.seedCategories();
    }
}
