package softuni.bg.battleships.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private long health;

    private long power;

    private LocalDate created;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    public Ships() {
    }

    public long getId() {
        return id;
    }

    public Ships setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ships setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public Ships setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPower() {
        return power;
    }

    public Ships setPower(long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Ships setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ships setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ships setUser(User user) {
        this.user = user;
        return this;
    }
}
