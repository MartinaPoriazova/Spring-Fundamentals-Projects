package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.Category;
import bg.softuni.coffeeshop.model.enums.CategoryTypeEnum;
import bg.softuni.coffeeshop.repository.CategoryRepository;
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
                    .map(categoryTypeEnum -> {
                                Category category = new Category();
                                category.setName(categoryTypeEnum);
                                switch (categoryTypeEnum) {
                                    case CAKE -> category.setNeededTime(10);
                                    case DRINK -> category.setNeededTime(1);
                                    case COFFEE -> category.setNeededTime(2);
                                    case OTHER -> category.setNeededTime(5);
                                }
                                return category;
                            }
                    ).collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
        }
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category findByName(CategoryTypeEnum name) {
        return this.categoryRepository.findByName(name).orElse(null);
    }
}
