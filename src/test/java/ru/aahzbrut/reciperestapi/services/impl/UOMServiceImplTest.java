package ru.aahzbrut.reciperestapi.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.repositories.UOMRepository;

import java.time.LocalDateTime;

class UOMServiceImplTest {

    private static final String NAME = "Barrel";
    private static final String DESCRIPTION = "Bottomless barrel";
    private static final Long ID = 1L;
    private static final LocalDateTime CREATED_DATE_TIME = LocalDateTime.now();
    private static final LocalDateTime UPDATED_DATE_TIME = LocalDateTime.now();

    @Mock
    UOMRepository uomRepository;

    @InjectMocks
    UOMServiceImpl uomService;

    UOMRequest uomRequest;

    UOMResponse uomResponse;

    UOM uom;

    @BeforeEach
    void setUp() {
        uomRequest = initUomRequest();
        uomResponse = initUomResponse();
        uom = initUom();

        MockitoAnnotations.initMocks(this);
    }

    private static UOM initUom() {
        UOM result = new UOM();
        result.setId(ID);
        result.setName(NAME);
        result.setDescription(DESCRIPTION);
        result.setCreatedDateTime(CREATED_DATE_TIME);
        result.setUpdatedDateTime(UPDATED_DATE_TIME);

        return result;
    }

    private static UOMResponse initUomResponse() {
        UOMResponse result = new UOMResponse();
        result.setId(ID);
        result.setName(NAME);
        result.setDescription(DESCRIPTION);
        result.setCreatedDateTime(CREATED_DATE_TIME);
        result.setUpdatedDateTime(UPDATED_DATE_TIME);

        return result;
    }

    private static UOMRequest initUomRequest() {
        UOMRequest result = new UOMRequest();
        result.setName(NAME);
        result.setDescription(DESCRIPTION);

        return  result;
    }

    @Test
    void getAllUoms() {
        // given

        // when

        // then

    }

    @Test
    void getUomById() {
        // given

        // when

        // then

    }

    @Test
    void getUomByName() {
        // given

        // when

        // then

    }

    @Test
    void createUom() {
        // given

        // when

        // then

    }

    @Test
    void updateUom() {
        // given

        // when

        // then

    }

    @Test
    void deleteUomById() {
        // given

        // when

        // then

    }
}