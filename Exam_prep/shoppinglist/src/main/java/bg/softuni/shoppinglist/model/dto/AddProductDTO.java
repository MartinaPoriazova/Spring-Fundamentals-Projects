package bg.softuni.shoppinglist.model.dto;

import bg.softuni.shoppinglist.model.entity.Category;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddProductDTO {
    @Size(min = 3, max = 20)
    @NotBlank
    private String name;

    @Size(min = 5)
    @NotBlank
    private String description;

    @Positive
    private BigDecimal price;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;

    @NotBlank
    private Category category;

    public AddProductDTO() {
    }

    public String getName() {
        return name;
    }

    public AddProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public AddProductDTO setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public AddProductDTO setCategory(Category category) {
        this.category = category;
        return this;
    }
}
