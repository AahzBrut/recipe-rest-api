package ru.aahzbrut.reciperestapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;

@Mapper
@SuppressWarnings("squid:S1214")
public interface UOMMapper {

    UOMMapper INSTANCE = Mappers.getMapper(UOMMapper.class);

    UOMResponse uomToUomResponse(UOM uom);

    UOM uomRequestToUOM(UOMRequest uomRequest);

    @Mapping(target = "createdDateTime", ignore = true)
    @Mapping(target = "updatedDateTime", ignore = true)
    UOM uomResponseToUOM(UOMResponse uomResponse);
}
