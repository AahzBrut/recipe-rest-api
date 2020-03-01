package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Recipe;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.requests.RecipeRequest;
import ru.aahzbrut.reciperestapi.dto.responses.recipe.RecipeResponse;
import ru.aahzbrut.reciperestapi.mappers.NoteMapper;
import ru.aahzbrut.reciperestapi.mappers.RecipeMapper;
import ru.aahzbrut.reciperestapi.mappers.RecipeResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.RecipeRepository;
import ru.aahzbrut.reciperestapi.services.NoteService;
import ru.aahzbrut.reciperestapi.services.RecipeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final NoteService noteService;

    private final RecipeResponseMapper recipeResponseMapper;
    private final RecipeMapper recipeMapper;
    private final NoteMapper noteMapper;

    @Override
    public RecipeResponse getById(Long recipeId) {
        return recipeResponseMapper.from(recipeRepository.getOne(recipeId));
    }

    @Override
    public void deleteById(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<RecipeResponse> getAllRecipes() {
        return recipeResponseMapper.from(recipeRepository.findAll());
    }

    @Override
    public RecipeResponse addNew(RecipeRequest recipeRequest) {

        Recipe recipe = recipeMapper.from(recipeRequest);

        recipe = recipeRepository.saveAndFlush(recipe);

        return recipeResponseMapper.from(recipe);
    }

    @Override
    public RecipeResponse update(Long recipeId, RecipeRequest recipeRequest) {

        Recipe recipe = recipeRepository.getOne(recipeId);

        recipe = recipeMapper.merge(recipe, recipeRequest);

        recipe = recipeRepository.saveAndFlush(recipe);

        return recipeResponseMapper.from(recipe);
    }

    @Override
    @Transactional
    public RecipeResponse deleteNote(long recipeId, long noteId) {

        noteService.deleteById(noteId);

        return recipeResponseMapper.from(recipeRepository.getOne(recipeId));
    }

    @Override
    @Transactional
    public RecipeResponse addNote(long recipeId, NoteRequest noteRequest) {

        noteService.createNote(noteRequest);

        return recipeResponseMapper.from(recipeRepository.getOne(recipeId));
    }

    @Override
    @Transactional
    public RecipeResponse updateNote(long recipeId, long noteId, NoteRequest noteRequest) {

        noteService.updateNote(noteId, noteRequest);

        return recipeResponseMapper.from(recipeRepository.getOne(recipeId));
    }
}
