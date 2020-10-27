package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class UOMResponseMapper implements Mapper<UOMResponse, UOM> {

    @Override
    public UOMResponse from(UOM source) {

        return new UOMResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreatedDateTime(source.getCreatedDateTime())
                .setUpdatedDateTime(source.getModifiedDateTime());
    }
}
