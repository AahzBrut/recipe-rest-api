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
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.aahzbrut.reciperestapi.controllers.v1.CategoryController.API_V1_ALL_CATEGORIES;
import static ru.aahzbrut.reciperestapi.controllers.v1.CategoryController.API_V1_CATEGORY_BY_ID;

class CategoryControllerTest {

    static final Long ID = 1L;
    static final String CATEGORY_NAME = "Category 1";
    static final String CATEGORY_DESCRIPTION = "First Category";
    static final LocalDateTime CREATED_TIME = LocalDateTime.now();
    static final LocalDateTime UPDATED_TIME = LocalDateTime.now();

    CategoryResponse categoryResponse;

    CategoryRequest categoryRequest;


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

        initCategoryResponse();

        initCategoryRequest();
    }

    private void initCategoryRequest() {
        categoryRequest = new CategoryRequest();
        categoryRequest.setName(CATEGORY_NAME);
        categoryRequest.setDescription(CATEGORY_DESCRIPTION);
    }

    private void initCategoryResponse() {
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
        mockMvc.perform(get(API_V1_CATEGORY_BY_ID, ID)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(ID.intValue())))
                .andExpect(jsonPath("$.name", is(CATEGORY_NAME)))
                .andExpect(jsonPath("$.description", equalTo(CATEGORY_DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime", is(CREATED_TIME.toString())))
                .andExpect(jsonPath("$.updatedDateTime", is(UPDATED_TIME.toString())));

        verify(categoryService, times(1)).getById(ID);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    void getAllCategories() throws Exception {
        //given

        //when
        when(categoryService.getAllCategories()).thenReturn(Collections.singletonList(categoryResponse));

        //then
        mockMvc.perform(get(API_V1_ALL_CATEGORIES)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.categories", hasSize(1)))
                .andExpect(jsonPath("$.categories[0].id", is(ID.intValue())))
                .andExpect(jsonPath("$.categories[0].name", is(CATEGORY_NAME)))
                .andExpect(jsonPath("$.categories[0].description", is(CATEGORY_DESCRIPTION)))
                .andExpect(jsonPath("$.categories[0].createdDateTime", is(CREATED_TIME.toString())))
                .andExpect(jsonPath("$.categories[0].updatedDateTime", is(UPDATED_TIME.toString())));

        verify(categoryService, times(1)).getAllCategories();
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    void createNewCategory() throws Exception {
        //given
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String parameter = mapper.writeValueAsString(categoryRequest);

        //when
        when(categoryService.save(any())).thenReturn(categoryResponse);

        //then
        mockMvc.perform(post(API_V1_ALL_CATEGORIES)
                .content(parameter)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(ID.intValue())))
                .andExpect(jsonPath("$.name", is(CATEGORY_NAME)))
                .andExpect(jsonPath("$.description", equalTo(CATEGORY_DESCRIPTION)))
                .andExpect(jsonPath("$.createdDateTime", is(CREATED_TIME.toString())))
                .andExpect(jsonPath("$.updatedDateTime", is(UPDATED_TIME.toString())));

        verify(categoryService).save(any());
        verifyNoMoreInteractions(categoryService);
    }
}