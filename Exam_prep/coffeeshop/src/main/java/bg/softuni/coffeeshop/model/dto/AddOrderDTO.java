package bg.softuni.coffeeshop.model.dto;

import bg.softuni.coffeeshop.model.entity.Category;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @Positive
    private BigDecimal price
            ;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    @NotBlank
    private Category category;

    @NotBlank
    @Size(min = 5)
    private String description;

    public AddOrderDTO() {
    }


    public String getName() {
        return name;
    }

    public AddOrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOrderDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public AddOrderDTO setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public AddOrderDTO setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOrderDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "AddOrderDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", orderTime=" + orderTime +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
