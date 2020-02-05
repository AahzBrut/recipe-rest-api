package ru.aahzbrut.reciperestapi.mappers;

import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;


public interface UOMMapper {

    UOM from(UOMRequest uomRequest);

    UOM from(UOMResponse uomResponse);
}
