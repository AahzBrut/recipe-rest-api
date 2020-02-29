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
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponseList;
import ru.aahzbrut.reciperestapi.services.RecipeService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with recipes.")
@RequiredArgsConstructor
@RestController
public class RecipeController {

    private static final String API_V_1_RECIPES_ID = "/api/v1/recipes/{id}";
    private static final String API_V_1_ALL_RECIPES = "/api/v1/recipes";

    private final RecipeService recipeService;


    @ApiOperation(value = "Get recipe by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V_1_RECIPES_ID,
            produces = APPLICATION_JSON_VALUE)
    public RecipeResponse getRecipeById(@PathVariable(name = "id") long id) {
        log.info(START + getCurrentMethodName());

        RecipeResponse response = recipeService.getById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Delete recipe by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = API_V_1_RECIPES_ID)
    public void deleteRecipeById(@PathVariable(name = "id") long id) {
        log.info(START + getCurrentMethodName());

        recipeService.deleteById(id);

        log.info(FINISH + getCurrentMethodName());
    }

    @ApiOperation(value = "Get all recipes")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V_1_ALL_RECIPES,
            produces = APPLICATION_JSON_VALUE)
    public RecipeResponseList getAllRecipes() {
        log.info(START + getCurrentMethodName());

        RecipeResponseList response = new RecipeResponseList();
        response.setSteps(recipeService.getAllRecipes());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Create new recipe")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = API_V_1_ALL_RECIPES,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public RecipeResponse createNewRecipe(@RequestBody RecipeRequest recipeRequest) {
        log.info(START + getCurrentMethodName());

        RecipeResponse response = recipeService.addNew(recipeRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Update existing recipe")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = API_V_1_RECIPES_ID,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public RecipeResponse updateRecipe(@PathVariable(name = "id") long id, @RequestBody RecipeRequest recipeRequest) {
        log.info(START + getCurrentMethodName());

        RecipeResponse response = recipeService.update(id, recipeRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }
}
