package bg.softuni.shoppinglist.service;

import bg.softuni.shoppinglist.model.dto.AddProductDTO;
import bg.softuni.shoppinglist.model.dto.ProductDTO;
import bg.softuni.shoppinglist.model.entity.Category;
import bg.softuni.shoppinglist.model.entity.Product;
import bg.softuni.shoppinglist.model.enums.CategoryTypeEnum;
import bg.softuni.shoppinglist.model.mapper.ProductMapper;
import bg.softuni.shoppinglist.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productMapper = productMapper;
    }

    public Set<Product> findProductsByCategory(CategoryTypeEnum food, ProductDTO productDTO) {
        return productRepository.findAllByCategoryName(food)
                .stream()
                .map(product -> product = productMapper.productDTOToProduct(productDTO))
                .collect(Collectors.toSet());
    }

    public BigDecimal getTotalProductsPrice() {
        return productRepository.findTotalPriceSum();
    }

    public void addProduct(AddProductDTO addProductDTO) {
        Product newProduct = productMapper.addProductDTOToProduct(addProductDTO);
        Category category = categoryService.findCategoryByName(addProductDTO.getCategory().getName());
        newProduct.setCategory(category);

        productRepository.save(newProduct);
    }
}
