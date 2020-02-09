package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;

import java.util.List;

public interface UOMService {

    List<UOMResponse> getAllUoms();
    UOMResponse getUomById(Long uomId);
    UOMResponse getUomByName(String uomName);
    UOMResponse createUom(UOMRequest uomRequest);
    UOMResponse updateUom(Long uomId, UOMRequest uomRequest);
    void deleteUomById(Long uomId);
}
