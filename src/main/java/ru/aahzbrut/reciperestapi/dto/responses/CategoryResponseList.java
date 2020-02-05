package ru.aahzbrut.reciperestapi.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseList {

    List<CategoryResponse> categories = new LinkedList<>();
}
