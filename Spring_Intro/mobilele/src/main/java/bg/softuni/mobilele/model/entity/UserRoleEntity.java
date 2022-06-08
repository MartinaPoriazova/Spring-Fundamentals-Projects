package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.BaseEntity;
import bg.softuni.mobilele.model.entity.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum name;

    public UserRoleEntity() {
    }

    public UserRoleEnum getName() {
        return name;
    }

    public void setName(UserRoleEnum name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "name=" + name +
                '}';
    }
}
