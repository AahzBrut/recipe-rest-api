package ru.aahzbrut.reciperestapi.dto.responses.step;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StepResponseList {

    private List<StepResponse> steps = new LinkedList<>();
}
