package ru.aahzbrut.reciperestapi.controllers.v1;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMReponseList;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.services.UOMService;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with UOM")
@RequiredArgsConstructor
@RestController
public class UOMController {

    public static final String API_V1_ALL_UOMS = "/api/v1/uoms";
    public static final String API_V1_UOM_BY_ID = "/api/v1/uoms/{id}";
    public static final String API_V1_UOM_SAVE = "/api/v1/uoms/save";

    private final UOMService uomService;

    @ApiOperation(value = "Returns list of all UOMs")
    @ResponseStatus(OK)
    @GetMapping(value = API_V1_ALL_UOMS,
            produces = APPLICATION_JSON_VALUE)
    public UOMReponseList getAllUoms() {
        log.info(START + getCurrentMethodName());

        UOMReponseList uomReponseList = new UOMReponseList();
        uomReponseList.setUoms(uomService.getAllUoms());

        log.info(FINISH + getCurrentMethodName());
        return uomReponseList;
    }

    @ApiOperation(value = "Returns UOM by ID")
    @ResponseStatus(OK)
    @GetMapping(value = API_V1_UOM_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public UOMResponse getUomById(@PathVariable(name = "id") Long uomId) {
        log.info(START + getCurrentMethodName());

        UOMResponse response = uomService.getUomById(uomId);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Update UOM by ID and new attributes")
    @ResponseStatus(OK)
    @PutMapping(value = API_V1_UOM_SAVE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UOMResponse updateUom(@RequestBody UOMResponse uomResponse) {
        log.info(START + getCurrentMethodName());

        UOMResponse result = uomService.updateUom(uomResponse);

        log.info(FINISH + getCurrentMethodName());
        return  result;
    }

    @ApiOperation(value = "Create new UOM")
    @ResponseStatus(OK)
    @PostMapping(value = API_V1_ALL_UOMS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UOMResponse createUom(@RequestBody UOMRequest uomRequest) {
        log.info(START + getCurrentMethodName());

        UOMResponse result = uomService.createUom(uomRequest);

        log.info(FINISH + getCurrentMethodName());
        return  result;
    }

    @ApiOperation(value = "Delete UOM by id")
    @ResponseStatus(OK)
    @DeleteMapping(value = API_V1_UOM_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public void deleteUom(@PathVariable(name = "id") Long uomId) {
        log.info(START + getCurrentMethodName());

        uomService.deleteUomById(uomId);

        log.info(FINISH + getCurrentMethodName());
    }
}
