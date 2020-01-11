package ru.aahzbrut.reciperestapi.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryList;
import ru.aahzbrut.reciperestapi.dto.responses.CategoryResponse;
import ru.aahzbrut.reciperestapi.services.CategoryService;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with Category.")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Get Category by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/v1/categories/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryResponse getCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        CategoryResponse response = categoryService.getById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Get all Categories")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/v1/categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryList getAllCategories() {
        log.info(START + getCurrentMethodName());

        CategoryList response = new CategoryList();
        response.setCategories(categoryService.getAllCategories());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

}