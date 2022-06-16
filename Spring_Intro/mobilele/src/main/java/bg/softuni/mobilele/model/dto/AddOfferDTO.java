package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.entity.enums.EngineEnum;

public class AddOfferDTO {

    private EngineEnum engineEnum;

    public EngineEnum getEngineEnum() {
        return engineEnum;
    }

    public AddOfferDTO setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
        return this;
    }
}
