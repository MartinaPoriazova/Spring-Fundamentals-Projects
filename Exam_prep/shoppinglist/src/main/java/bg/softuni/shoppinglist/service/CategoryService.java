package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.enums.CategoryTypeEnum;
import bg.softuni.shoppinglist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seedCategories() {
        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryTypeEnum.values())
                    .map(Category::new)
                    .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
        }
    }

    public Category findCategoryByName(CategoryTypeEnum name) {
        return categoryRepository.findByName(name);
    }
}
