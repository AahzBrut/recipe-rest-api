package ru.aahzbrut.reciperestapi.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.UOMMapper;
import ru.aahzbrut.reciperestapi.mappers.UOMResponseMapper;
import ru.aahzbrut.reciperestapi.mappers.impl.UOMMapperImpl;
import ru.aahzbrut.reciperestapi.mappers.impl.UOMResponseMapperImpl;
import ru.aahzbrut.reciperestapi.repositories.UOMRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class UOMServiceImplTest {

    private static final String NAME = "Barrel";
    private static final String DESCRIPTION = "Bottomless barrel";
    private static final Long ID = 1L;
    private static final LocalDateTime CREATED_DATE_TIME = LocalDateTime.now();
    private static final LocalDateTime UPDATED_DATE_TIME = LocalDateTime.now();

    @Mock
    UOMRepository uomRepository;

    @Spy
    UOMMapper uomMapper = new UOMMapperImpl();

    @Spy
    UOMResponseMapper uomResponseMapper = new UOMResponseMapperImpl();

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
        result.setModifiedDateTime(UPDATED_DATE_TIME);

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
        when(uomRepository.findAll()).thenReturn(Collections.singletonList(uom));
        List<UOMResponse> uomResponses = uomService.getAllUoms();

        // then
        assertEquals(1, uomResponses.size());
        assertEquals(ID, uomResponses.get(0).getId());
        assertEquals(NAME, uomResponses.get(0).getName());
        assertEquals(DESCRIPTION, uomResponses.get(0).getDescription());
        assertEquals(CREATED_DATE_TIME, uomResponses.get(0).getCreatedDateTime());
        assertEquals(UPDATED_DATE_TIME, uomResponses.get(0).getUpdatedDateTime());

        verify(uomRepository, times(1)).findAll();
        verifyNoMoreInteractions(uomRepository);

    }

    @Test
    void getUomById() {
        // given

        // when
        when(uomRepository.getOne(anyLong())).thenReturn(uom);
        UOMResponse response = uomService.getUomById(ID);

        // then
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED_DATE_TIME, response.getCreatedDateTime());
        assertEquals(UPDATED_DATE_TIME, response.getUpdatedDateTime());

        verify(uomRepository, times(1)).getOne(anyLong());
        verifyNoMoreInteractions(uomRepository);
    }

    @Test
    void getUomByName() {
        // given

        // when
        when(uomRepository.getFirstByName(anyString())).thenReturn(uom);
        UOMResponse response = uomService.getUomByName(NAME);

        // then
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED_DATE_TIME, response.getCreatedDateTime());
        assertEquals(UPDATED_DATE_TIME, response.getUpdatedDateTime());

        verify(uomRepository, times(1)).getFirstByName(anyString());
        verifyNoMoreInteractions(uomRepository);
    }

    @Test
    void createUom() {
        // given

        // when
        when(uomRepository.saveAndFlush(any())).thenReturn(uom);
        UOMResponse response = uomService.createUom(uomRequest);

        // then
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED_DATE_TIME, response.getCreatedDateTime());
        assertEquals(UPDATED_DATE_TIME, response.getUpdatedDateTime());

        verify(uomRepository, times(1)).saveAndFlush(any());
        verifyNoMoreInteractions(uomRepository);
    }

    @Test
    void updateUom() {
        // given

        // when
        when(uomRepository.save(any())).thenReturn(uom);
        UOMResponse response = uomService.updateUom(uomResponse);

        // then
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED_DATE_TIME, response.getCreatedDateTime());
        assertEquals(UPDATED_DATE_TIME, response.getUpdatedDateTime());

        verify(uomRepository, times(1)).save(any());
        verifyNoMoreInteractions(uomRepository);
    }

    @Test
    void deleteUomById() {
        // given

        // when
        uomService.deleteUomById(ID);

        // then
        verify(uomRepository, times(1)).deleteById(ID);
        verifyNoMoreInteractions(uomRepository);
    }
}