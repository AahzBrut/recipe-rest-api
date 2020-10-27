package ru.aahzbrut.reciperestapi.mappers.impl;

import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.UOM;
import ru.aahzbrut.reciperestapi.dto.requests.UOMRequest;
import ru.aahzbrut.reciperestapi.mappers.Merger;

@Service
public class UOMMerger implements Merger<UOM, UOMRequest> {

    @Override
    public UOM merge(UOM source1, UOMRequest source2) {

        return source1
                .setName(source2.getName())
                .setDescription(source2.getDescription());
    }
}
