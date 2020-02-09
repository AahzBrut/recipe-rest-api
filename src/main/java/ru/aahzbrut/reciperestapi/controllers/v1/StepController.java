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
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponseList;
import ru.aahzbrut.reciperestapi.services.StepService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with recipe step.")
@RequiredArgsConstructor
@RestController
public class StepController {
    public static final String API_V1_STEP_BY_ID = "/api/v1/steps/{id}";
    public static final String API_V1_ALL_STEPS = "/api/v1/steps";
    private final StepService stepService;

    @ApiOperation(value = "Get step by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_STEP_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public StepResponse getStepById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        StepResponse response = stepService.getById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Delete step by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = API_V1_STEP_BY_ID)
    public void deleteStepById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        stepService.deleteById(id);

        log.info(FINISH + getCurrentMethodName());
    }

    @ApiOperation(value = "Get all steps")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_ALL_STEPS,
            produces = APPLICATION_JSON_VALUE)
    public StepResponseList getAllSteps() {
        log.info(START + getCurrentMethodName());

        StepResponseList response = new StepResponseList();
        response.setSteps(stepService.getAllSteps());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Create new step")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = API_V1_ALL_STEPS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public StepResponse createNewStep(@RequestBody StepRequest stepRequest) {
        log.info(START + getCurrentMethodName());

        StepResponse response = stepService.addNew(stepRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Update existing step")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = API_V1_STEP_BY_ID,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public StepResponse updateStep(@PathVariable long id, @RequestBody StepRequest stepRequest) {
        log.info(START + getCurrentMethodName());

        StepResponse response = stepService.update(id, stepRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }
}
