package softuni.bg.battleships.models.dtos;

import softuni.bg.battleships.models.Ship;

public class ShipDTO {

    private long id;

    private String name;

    private long health;

    private long power;

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.name = ship.getName();
        this.power = ship.getPower();
        this.health = ship.getHealth();
    }

    public long getId() {
        return id;
    }

    public ShipDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipDTO setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipDTO setPower(long power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        return "ShipDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", power=" + power +
                '}';
    }
}
