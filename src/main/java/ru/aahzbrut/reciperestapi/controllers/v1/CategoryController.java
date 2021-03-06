package ru.aahzbrut.reciperestapi.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aahzbrut.reciperestapi.dto.requests.CategoryRequest;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponse;
import ru.aahzbrut.reciperestapi.dto.responses.category.CategoryResponseList;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with Category.")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    public static final String API_V1_CATEGORY_BY_ID = "/api/v1/categories/{id}";
    public static final String API_V1_ALL_CATEGORIES = "/api/v1/categories";
    private final CategoryService categoryService;

    @ApiOperation(value = "Get Category by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_CATEGORY_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public CategoryResponse getCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        CategoryResponse response = categoryService.getById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Delete Category by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = API_V1_CATEGORY_BY_ID)
    public void deleteCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        categoryService.deleteById(id);

        log.info(FINISH + getCurrentMethodName());
    }

    @ApiOperation(value = "Get all Categories")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_ALL_CATEGORIES,
            produces = APPLICATION_JSON_VALUE)
    public CategoryResponseList getAllCategories() {
        log.info(START + getCurrentMethodName());

        CategoryResponseList response = new CategoryResponseList();
        response.setCategories(categoryService.getAllCategories());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Create new category")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = API_V1_ALL_CATEGORIES,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public CategoryResponse createNewCategory(@RequestBody CategoryRequest categoryRequest) {
        log.info(START + getCurrentMethodName());

        CategoryResponse response = categoryService.create(categoryRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Update Category by id")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = API_V1_CATEGORY_BY_ID,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public CategoryResponse updateCategoryById(@PathVariable(name = "id") Long categoryId,
                                   @RequestBody CategoryRequest categoryRequest) {
        log.info(START + getCurrentMethodName());

        CategoryResponse categoryResponse = categoryService.update(categoryId, categoryRequest);

        log.info(FINISH + getCurrentMethodName());
        return categoryResponse;
    }
}
