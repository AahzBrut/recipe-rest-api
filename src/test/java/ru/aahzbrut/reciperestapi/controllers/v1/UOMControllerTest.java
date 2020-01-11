package ru.aahzbrut.reciperestapi.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMList;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.services.UOMService;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.aahzbrut.reciperestapi.controllers.v1.UOMController.API_V1_ALL_UOMS;
import static ru.aahzbrut.reciperestapi.controllers.v1.UOMController.API_V1_UOM_BY_ID;
import static ru.aahzbrut.reciperestapi.controllers.v1.UOMController.API_V1_UOM_CREATE;
import static ru.aahzbrut.reciperestapi.controllers.v1.UOMController.API_V1_UOM_SAVE;
import static ru.aahzbrut.reciperestapi.tools.MatcherHelpers.getLocalDateTimeAsList;

class UOMControllerTest {

    private static final String NAME = "Barrel";
    private static final String DESCRIPTION = "Bottomless barrel";
    private static final Long ID = 1L;
    private static final LocalDateTime CREATED_DATE_TIME = LocalDateTime.now();
    private static final LocalDateTime UPDATED_DATE_TIME = LocalDateTime.now();

    @Mock
    UOMService uomService;

    @InjectMocks
    UOMController uomController;

    MockMvc mockMvc;

    UOMRequest uomRequest;

    UOMResponse uomResponse;

    UOMList uomList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(uomController).build();

        uomRequest = initUOMRequest();

        uomResponse = initUOMResponse();

        uomList = initUOMList();
    }

    private static UOMList initUOMList() {
        UOMList uomList = new UOMList();
        uomList.setUoms(Arrays.asList(initUOMResponse(), initUOMResponse(), initUOMResponse()));

        return uomList;
    }

    private static UOMResponse initUOMResponse() {
        UOMResponse uomResponse = new UOMResponse();
        uomResponse.setId(ID);
        uomResponse.setName(NAME);
        uomResponse.setDescription(DESCRIPTION);
        uomResponse.setCreatedDateTime(CREATED_DATE_TIME);
        uomResponse.setUpdatedDateTime(UPDATED_DATE_TIME);

        return uomResponse;
    }

    private static UOMRequest initUOMRequest() {
        UOMRequest uomRequest = new UOMRequest();
        uomRequest.setName(NAME);
        uomRequest.setDescription(DESCRIPTION);

        return uomRequest;
    }

    @Test
    void getAllUoms() throws Exception {
        //given

        //when
        when(uomService.getAllUoms()).thenReturn(uomList.getUoms());

        //then
        mockMvc.perform(get(API_V1_ALL_UOMS)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.uoms", hasSize(uomList.getUoms().size())))
                .andExpect(jsonPath("$.uoms[0].id", is(ID.intValue())))
                .andExpect(jsonPath("$.uoms[0].name", is(NAME)))
                .andExpect(jsonPath("$.uoms[0].description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.uoms[0].createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.uoms[0].updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))))
                .andExpect(jsonPath("$.uoms[1].id", is(ID.intValue())))
                .andExpect(jsonPath("$.uoms[1].name", is(NAME)))
                .andExpect(jsonPath("$.uoms[1].description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.uoms[1].createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.uoms[1].updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))))
                .andExpect(jsonPath("$.uoms[2].id", is(ID.intValue())))
                .andExpect(jsonPath("$.uoms[2].name", is(NAME)))
                .andExpect(jsonPath("$.uoms[2].description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.uoms[2].createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.uoms[2].updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))));

        verify(uomService, times(1)).getAllUoms();
        verifyNoMoreInteractions(uomService);
    }

    @Test
    void getUomById() throws Exception {
        //given
        //when
        when(uomService.getUomById(anyLong())).thenReturn(uomResponse);

        //then
        mockMvc.perform(get(API_V1_UOM_BY_ID, ID)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(ID.intValue())))
                .andExpect(jsonPath("$.name", is(NAME)))
                .andExpect(jsonPath("$.description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))));

        verify(uomService, times(1)).getUomById(ID);
        verifyNoMoreInteractions(uomService);
    }

    @Test
    void updateUom() throws Exception {
        //given
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String parameter = mapper.writeValueAsString(uomResponse);

        //when
        when(uomService.updateUom(any())).thenReturn(uomResponse);

        //then
        mockMvc.perform(put(API_V1_UOM_SAVE)
                .accept(APPLICATION_JSON)
                .content(parameter)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(ID.intValue())))
                .andExpect(jsonPath("$.name", is(NAME)))
                .andExpect(jsonPath("$.description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))));

        verify(uomService, times(1)).updateUom(any());
        verifyNoMoreInteractions(uomService);
    }

    @Test
    void createUom() throws Exception {
        //given
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String parameter = mapper.writeValueAsString(uomRequest);

        //when
        when(uomService.createUom(any())).thenReturn(uomResponse);

        //then
        mockMvc.perform(post(API_V1_UOM_CREATE)
                .accept(APPLICATION_JSON)
                .content(parameter)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(ID.intValue())))
                .andExpect(jsonPath("$.name", is(NAME)))
                .andExpect(jsonPath("$.description", is(DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime", is(getLocalDateTimeAsList(CREATED_DATE_TIME))))
                .andExpect(jsonPath("$.updatedDateTime", is(getLocalDateTimeAsList(UPDATED_DATE_TIME))));

        verify(uomService, times(1)).createUom(any());
        verifyNoMoreInteractions(uomService);
    }

    @Test
    void deleteUom() throws Exception {
        //given
        //when

        //then
        mockMvc.perform(delete(API_V1_UOM_BY_ID, ID)                )
                .andExpect(status().isOk());

        verify(uomService, times(1)).deleteUomById(ID);
        verifyNoMoreInteractions(uomService);
    }
}