package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.UOMMapper;

@Service
public class UOMMapperImpl implements UOMMapper {

    @Override
    public UOM from(UOMRequest uomRequest) {

        UOM result = new UOM();
        result.setName(uomRequest.getName());
        result.setDescription(uomRequest.getDescription());

        return result;
    }

    @Override
    public UOM from(UOMResponse uomResponse) {

        UOM result = new UOM();
        result.setId(uomResponse.getId());
        result.setName(uomResponse.getName());
        result.setDescription(uomResponse.getDescription());
        result.setCreatedDateTime(uomResponse.getCreatedDateTime());
        result.setModifiedDateTime(uomResponse.getUpdatedDateTime());

        return result;
    }
}
