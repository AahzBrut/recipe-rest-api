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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aahzbrut.reciperestapi.dto.requests.IngredientRequest;
import ru.aahzbrut.reciperestapi.dto.responses.IngredientResponse;
import ru.aahzbrut.reciperestapi.dto.responses.IngredientResponseList;
import ru.aahzbrut.reciperestapi.services.IngredientService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with Ingredient.")
@RequiredArgsConstructor
@RestController
public class IngredientController {

    public static final String API_V1_INGREDIENT_BY_ID = "/api/v1/ingredients/{id}";
    public static final String API_V1_ALL_INGREDIENTS = "/api/v1/ingredients";
    private final IngredientService ingredientService;


    @ApiOperation(value = "Get Category by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_INGREDIENT_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public IngredientResponse getCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        IngredientResponse response = ingredientService.getById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Delete Category by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = API_V1_INGREDIENT_BY_ID)
    public void deleteCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        ingredientService.deleteById(id);

        log.info(FINISH + getCurrentMethodName());
    }

    @ApiOperation(value = "Get all Categories")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_ALL_INGREDIENTS,
            produces = APPLICATION_JSON_VALUE)
    public IngredientResponseList getAllCategories() {
        log.info(START + getCurrentMethodName());

        IngredientResponseList response = new IngredientResponseList();
        response.setIngredients(ingredientService.getAllCategories());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Create new category")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = API_V1_ALL_INGREDIENTS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public IngredientResponse createNewCategory(@RequestBody IngredientRequest ingredientRequest) {
        log.info(START + getCurrentMethodName());

        IngredientResponse response = ingredientService.update(ingredientRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

}
