package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.UOMResponseMapper;

@Service
public class UOMResponseMapperImpl implements UOMResponseMapper {

    @Override
    public UOMResponse from(UOM uom) {

        UOMResponse result = new UOMResponse();
        result.setId(uom.getId());
        result.setName(uom.getName());
        result.setDescription(uom.getDescription());
        result.setCreatedDateTime(uom.getCreatedDateTime());
        result.setUpdatedDateTime(uom.getModifiedDateTime());

        return result;
    }
}
