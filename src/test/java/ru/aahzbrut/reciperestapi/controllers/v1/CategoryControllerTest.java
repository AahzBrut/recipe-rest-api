package ru.aahzbrut.reciperestapi.controllers.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CategoryControllerTest {

    static final Long ID = 1L;
    static final String CATEGORY_NAME = "Category 1";
    static final String CATEGORY_DESCRIPTION = "First Category";
    static final LocalDateTime CREATED_TIME = LocalDateTime.now();
    static final LocalDateTime UPDATED_TIME = LocalDateTime.now();
    CategoryResponse categoryResponse;


    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders
                .standaloneSetup(categoryController)
                .build();

        categoryResponse = new CategoryResponse();
        categoryResponse.setId(ID);
        categoryResponse.setName(CATEGORY_NAME);
        categoryResponse.setDescription(CATEGORY_DESCRIPTION);
        categoryResponse.setCreatedDateTime(CREATED_TIME);
        categoryResponse.setUpdatedDateTime(UPDATED_TIME);
    }

    @Test
    void getCategoryById() throws Exception {
        //given

        //when
        when(categoryService.getById(anyLong())).thenReturn(categoryResponse);

        //then
        mockMvc.perform(get("/api/v1/categories/{id}", ID)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(ID.intValue())))
                .andExpect(jsonPath("$.name", is(CATEGORY_NAME)))
                .andExpect(jsonPath("$.description", equalTo(CATEGORY_DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime[0]", is(CREATED_TIME.getYear())))
                .andExpect(jsonPath("$.createdDateTime[1]", is(CREATED_TIME.getMonthValue())))
                .andExpect(jsonPath("$.createdDateTime[2]", is(CREATED_TIME.getDayOfMonth())))
                .andExpect(jsonPath("$.createdDateTime[3]", is(CREATED_TIME.getHour())))
                .andExpect(jsonPath("$.createdDateTime[4]", is(CREATED_TIME.getMinute())))
                .andExpect(jsonPath("$.createdDateTime[5]", is(CREATED_TIME.getSecond())))
                .andExpect(jsonPath("$.createdDateTime[6]", is(CREATED_TIME.getNano())))
                .andExpect(jsonPath("$.updatedDateTime[0]", is(UPDATED_TIME.getYear())))
                .andExpect(jsonPath("$.createdDateTime[1]", is(UPDATED_TIME.getMonthValue())))
                .andExpect(jsonPath("$.createdDateTime[2]", is(UPDATED_TIME.getDayOfMonth())))
                .andExpect(jsonPath("$.createdDateTime[3]", is(UPDATED_TIME.getHour())))
                .andExpect(jsonPath("$.createdDateTime[4]", is(UPDATED_TIME.getMinute())))
                .andExpect(jsonPath("$.createdDateTime[5]", is(UPDATED_TIME.getSecond())))
                .andExpect(jsonPath("$.createdDateTime[6]", is(UPDATED_TIME.getNano())));
        verify(categoryService, times(1)).getById(ID);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    void getAllCategories() throws Exception {
        //given

        //when
        when(categoryService.getAllCategories()).thenReturn(Collections.singletonList(categoryResponse));

        //then
        mockMvc.perform(get("/api/v1/categories")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.categories", hasSize(1)))
                .andExpect(jsonPath("$.categories[0].id", is(ID.intValue())))
                .andExpect(jsonPath("$.categories[0].name", is(CATEGORY_NAME)))
                .andExpect(jsonPath("$.categories[0].description", is(CATEGORY_DESCRIPTION)))
                .andExpect(jsonPath("$.categories[0].createdDateTime[0]", is(CREATED_TIME.getYear())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[1]", is(CREATED_TIME.getMonthValue())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[2]", is(CREATED_TIME.getDayOfMonth())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[3]", is(CREATED_TIME.getHour())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[4]", is(CREATED_TIME.getMinute())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[5]", is(CREATED_TIME.getSecond())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[6]", is(CREATED_TIME.getNano())))
                .andExpect(jsonPath("$.categories[0].updatedDateTime[0]", is(UPDATED_TIME.getYear())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[1]", is(UPDATED_TIME.getMonthValue())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[2]", is(UPDATED_TIME.getDayOfMonth())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[3]", is(UPDATED_TIME.getHour())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[4]", is(UPDATED_TIME.getMinute())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[5]", is(UPDATED_TIME.getSecond())))
                .andExpect(jsonPath("$.categories[0].createdDateTime[6]", is(UPDATED_TIME.getNano())));
        verify(categoryService, times(1)).getAllCategories();
        verifyNoMoreInteractions(categoryService);
    }
}