package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.mappers.Mapper;

@Service
public class UOMMapper implements Mapper<UOM, UOMRequest> {

    @Override
    public UOM from(UOMRequest source) {

        return new UOM()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}