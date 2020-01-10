package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.UOMResponse;
import ru.aahzbrut.reciperestapi.exceptions.NotImplementedException;
import ru.aahzbrut.reciperestapi.repositories.UOMRepository;
import ru.aahzbrut.reciperestapi.services.UOMService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UOMServiceImpl implements UOMService {

    private final UOMRepository uomRepository;

    @Override
    public List<UOMResponse> getAllUoms() {
        throw new NotImplementedException();
    }

    @Override
    public UOMResponse getUomById(Long uomId) {
        throw new NotImplementedException();
    }

    @Override
    public UOMResponse getUomByName(String uomName) {
        throw new NotImplementedException();
    }

    @Override
    public UOMResponse createUom(UOMRequest uomRequest) {
        throw new NotImplementedException();
    }

    @Override
    public UOMResponse updateUom(UOMResponse uomResponse) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteUomById(Long uomId) {
        throw new NotImplementedException();
    }
}
