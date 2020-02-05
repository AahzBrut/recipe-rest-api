package ru.aahzbrut.reciperestapi.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.responses.NoteResponse;
import ru.aahzbrut.reciperestapi.dto.responses.NoteResponseList;
import ru.aahzbrut.reciperestapi.services.NoteService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Api(value = "CRUD operations with Note.")
@RequiredArgsConstructor
@RestController
public class NoteController {

    private static final String API_V1_NOTE_BY_ID = "/api/v1/notes/{id}";
    private static final String API_V1_ALL_NOTES = "/api/v1/notes";

    private final NoteService noteService;

    @ApiOperation(value = "Get Note by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_NOTE_BY_ID,
            produces = APPLICATION_JSON_VALUE)
    public NoteResponse getCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        NoteResponse response = noteService.getNoteById(id);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Delete Note by id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = API_V1_NOTE_BY_ID)
    public void deleteCategoryById(@PathVariable long id) {
        log.info(START + getCurrentMethodName());

        noteService.deleteById(id);

        log.info(FINISH + getCurrentMethodName());
    }

    @ApiOperation(value = "Get all Notes")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = API_V1_ALL_NOTES,
            produces = APPLICATION_JSON_VALUE)
    public NoteResponseList getAllCategories() {
        log.info(START + getCurrentMethodName());

        NoteResponseList response = new NoteResponseList();
        response.setNotes(noteService.getAllNotes());

        log.info(FINISH + getCurrentMethodName());
        return response;
    }

    @ApiOperation(value = "Create or update note")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = API_V1_ALL_NOTES,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public NoteResponse createNewCategory(@RequestBody NoteRequest noteRequest) {
        log.info(START + getCurrentMethodName());

        NoteResponse response = noteService.updateNote(noteRequest);

        log.info(FINISH + getCurrentMethodName());
        return response;
    }
}
