package ru.aahzbrut.reciperestapi.mappers;

import org.junit.jupiter.api.Test;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.impl.UOMMapperImpl;
import ru.aahzbrut.reciperestapi.mappers.impl.UOMResponseMapperImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UOMMapperTest {

    private static final UOMResponseMapper uomResponseMapper = new UOMResponseMapperImpl();
    private static final UOMMapper uomMapper = new UOMMapperImpl();
    private static final Long UOM_ID = 1L;
    private static final String UOM_NAME = "Barrel";
    private static final String UOM_DESCRIPTION = "Bottomless barrel";
    private static final LocalDateTime CREATED_DATETIME = LocalDateTime.now();
    private static final LocalDateTime UPDATED_DATETIME = LocalDateTime.now();
    private static final Object NULL = null;

    @Test
    void uomToUomResponse() {
        //given
        UOM uom = new UOM();
        uom.setId(UOM_ID);
        uom.setName(UOM_NAME);
        uom.setDescription(UOM_DESCRIPTION);
        uom.setCreatedDateTime(CREATED_DATETIME);
        uom.setModifiedDateTime(UPDATED_DATETIME);

        //when
        UOMResponse uomResponse = uomResponseMapper.from(uom);

        //then
        assertEquals(UOM_ID, uomResponse.getId());
        assertEquals(UOM_NAME, uomResponse.getName());
        assertEquals(UOM_DESCRIPTION, uomResponse.getDescription());
        assertEquals(CREATED_DATETIME, uomResponse.getCreatedDateTime());
        assertEquals(UPDATED_DATETIME, uomResponse.getUpdatedDateTime());
    }

    @Test
    void uomRequestToUOM() {
        //given
        UOMRequest uomRequest = new UOMRequest();
        uomRequest.setName(UOM_NAME);
        uomRequest.setDescription(UOM_DESCRIPTION);

        //when
        UOM uom = uomMapper.from(uomRequest);

        //then
        assertEquals(NULL, uom.getId());
        assertEquals(UOM_NAME, uom.getName());
        assertEquals(UOM_DESCRIPTION, uom.getDescription());
        assertEquals(NULL, uom.getCreatedDateTime());
        assertEquals(NULL, uom.getModifiedDateTime());
    }

    @Test
    void uomResponseToUOM() {
        //given
        UOMResponse uomResponse = new UOMResponse();
        uomResponse.setId(UOM_ID);
        uomResponse.setName(UOM_NAME);
        uomResponse.setDescription(UOM_DESCRIPTION);
        uomResponse.setCreatedDateTime(CREATED_DATETIME);
        uomResponse.setUpdatedDateTime(UPDATED_DATETIME);

        //when
        UOM uom = uomMapper.from(uomResponse);

        //then
        assertEquals(UOM_ID, uom.getId());
        assertEquals(UOM_NAME, uom.getName());
        assertEquals(UOM_DESCRIPTION, uom.getDescription());
        assertEquals(CREATED_DATETIME, uom.getCreatedDateTime());
        assertEquals(UPDATED_DATETIME, uom.getModifiedDateTime());
    }
}