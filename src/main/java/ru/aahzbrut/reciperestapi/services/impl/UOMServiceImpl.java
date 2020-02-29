package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.dto.responses.uom.UOMResponse;
import ru.aahzbrut.reciperestapi.mappers.UOMMapper;
import ru.aahzbrut.reciperestapi.mappers.UOMResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.UOMRepository;
import ru.aahzbrut.reciperestapi.services.UOMService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.UOM_TRACE;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Service
@RequiredArgsConstructor
public class UOMServiceImpl implements UOMService {

    private final UOMRepository uomRepository;
    private final UOMMapper uomMapper;
    private final UOMResponseMapper uomResponseMapper;

    @Override
    public List<UOMResponse> getAllUoms() {
        log.debug(START + getCurrentMethodName());

        List<UOMResponse> result = uomRepository.findAll()
                .stream()
                .map(uomResponseMapper::from)
                .collect(Collectors.toList());

        log.trace("UOMs:\n" + result);

        log.debug(FINISH + getCurrentMethodName());

        return result;
    }

    @Transactional
    @Override
    public UOMResponse getUomById(Long uomId) {
        log.debug(START + getCurrentMethodName());

        UOMResponse result = uomResponseMapper.from(uomRepository.getOne(uomId));
        log.trace(UOM_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    public UOMResponse getUomByName(String uomName) {
        log.debug(START + getCurrentMethodName());

        UOMResponse result = uomResponseMapper.from(uomRepository.getFirstByName(uomName));
        log.trace(UOM_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    @Transactional
    public UOMResponse createUom(UOMRequest uomRequest) {
        log.debug(START + getCurrentMethodName());

        UOM newUom = uomMapper.from(uomRequest);

        newUom = uomRepository.saveAndFlush(newUom);

        UOMResponse result = uomResponseMapper.from(newUom);
        log.trace(UOM_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    @Transactional
    public UOMResponse updateUom(Long uomId, UOMRequest uomRequest) {
        log.debug(START + getCurrentMethodName());

        UOM oldUom = uomRepository.getOne(uomId);

        UOM newUom = uomMapper.merge(oldUom, uomRequest);

        newUom = uomRepository.saveAndFlush(newUom);

        UOMResponse result = uomResponseMapper.from(newUom);
        log.trace(UOM_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    @Transactional
    public void deleteUomById(Long uomId) {
        log.debug(START + getCurrentMethodName());

        uomRepository.deleteById(uomId);

        log.debug(FINISH + getCurrentMethodName());
    }
}
