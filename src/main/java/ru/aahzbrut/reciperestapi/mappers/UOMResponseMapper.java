package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;

public interface UOMResponseMapper {

    UOMResponse from(UOM uom);

}
