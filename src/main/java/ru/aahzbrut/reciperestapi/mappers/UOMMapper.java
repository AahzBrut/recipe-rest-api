package ru.aahzbrut.reciperestapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;

@Mapper
public interface UOMMapper {

    UOMResponse uomToUomResponse(UOM uom);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdDateTime", ignore = true),
            @Mapping(target = "updatedDateTime", ignore = true)})
    UOM from(UOMRequest uomRequest);

    @Mappings(value = {
            @Mapping(target = "createdDateTime", ignore = true),
            @Mapping(target = "updatedDateTime", ignore = true)})
    UOM from(UOMResponse uomResponse);
}
