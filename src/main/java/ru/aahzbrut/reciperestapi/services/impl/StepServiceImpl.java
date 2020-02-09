package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Step;
import ru.aahzbrut.reciperestapi.dto.requests.StepRequest;
import ru.aahzbrut.reciperestapi.dto.responses.step.StepResponse;
import ru.aahzbrut.reciperestapi.mappers.StepMapper;
import ru.aahzbrut.reciperestapi.mappers.StepResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.StepRepository;
import ru.aahzbrut.reciperestapi.services.StepService;

import java.util.List;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.STEP_TRACE;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Service
@RequiredArgsConstructor
public class StepServiceImpl implements StepService {

    private final StepRepository stepRepository;
    private final StepMapper stepMapper;
    private final StepResponseMapper stepResponseMapper;

    @Override
    public StepResponse getById(Long stepId) {
        log.debug(START + getCurrentMethodName());

        Step step = stepRepository.getOne(stepId);

        StepResponse result = stepResponseMapper.from(step);
        log.trace(STEP_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    public void deleteById(Long stepId) {
        log.debug(START + getCurrentMethodName());

        stepRepository.deleteById(stepId);

        log.debug(FINISH + getCurrentMethodName());
    }

    @Override
    public List<StepResponse> getAllSteps() {
        log.debug(START + getCurrentMethodName());
        List<Step> steps = stepRepository.findAll();
        log.trace(STEP_TRACE + steps.toString());

        List<StepResponse> result = stepResponseMapper.from(steps);
        log.trace(STEP_TRACE + result.toString());

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }

    @Override
    public StepResponse addNew(StepRequest stepRequest) {
        log.debug(START + getCurrentMethodName());

        Step step = stepMapper.from(stepRequest);

        step = stepRepository.saveAndFlush(step);

        log.debug(FINISH + getCurrentMethodName());
        return stepResponseMapper.from(step);
    }

    @Override
    public StepResponse update(Long stepId, StepRequest stepRequest) {
        log.debug(START + getCurrentMethodName());

        Step oldStep = stepRepository.getOne(stepId);

        Step newStep = stepMapper.merge(oldStep, stepRequest);

        newStep = stepRepository.saveAndFlush(newStep);

        StepResponse result = stepResponseMapper.from(newStep);
        log.trace(STEP_TRACE + result);

        log.debug(FINISH + getCurrentMethodName());
        return result;
    }
}
