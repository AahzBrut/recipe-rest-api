package ru.aahzbrut.reciperestapi.services;

import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;

import java.util.List;

public interface UOMService {

    List<UOMResponse> getAllUoms();
    UOMResponse getUomById(Long uomId);
    UOMResponse getUomByName(String uomName);
    UOMResponse createUom(UOMRequest uomRequest);
    UOMResponse updateUom(UOMResponse uomResponse);
    void deleteUomById(Long uomId);
}
