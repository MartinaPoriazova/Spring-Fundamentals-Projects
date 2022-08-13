package bg.softuni.coffeeshop.model.entity;

import bg.softuni.coffeeshop.model.enums.CategoryTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private CategoryTypeEnum name;

    @Column(name = "needed_time", nullable = false)
    private int neededTime;

    public Category() {
    }

    public Category(CategoryTypeEnum name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Category setId(long id) {
        this.id = id;
        return this;
    }

    public CategoryTypeEnum getName() {
        return name;
    }

    public Category setName(CategoryTypeEnum name) {
        this.name = name;
        return this;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(int neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
