package ru.aahzbrut.reciperestapi.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aahzbrut.reciperestapi.domain.entities.Note;
import ru.aahzbrut.reciperestapi.dto.requests.NoteRequest;
import ru.aahzbrut.reciperestapi.dto.responses.note.NoteResponse;
import ru.aahzbrut.reciperestapi.mappers.NoteMapper;
import ru.aahzbrut.reciperestapi.mappers.NoteResponseMapper;
import ru.aahzbrut.reciperestapi.repositories.NoteRepository;
import ru.aahzbrut.reciperestapi.services.NoteService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.aahzbrut.reciperestapi.utils.DebugStrings.FINISH;
import static ru.aahzbrut.reciperestapi.utils.DebugStrings.START;
import static ru.aahzbrut.reciperestapi.utils.ReflectionUtils.getCurrentMethodName;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteResponseMapper noteResponseMapper;
    private final NoteMapper noteMapper;

    @Override
    public NoteResponse getNoteById(Long noteId) {
        log.debug(START + getCurrentMethodName());

        Note note = noteRepository.getOne(noteId);
        log.trace("Note with ID:" + noteId + " - " + note);

        NoteResponse noteResponse = noteResponseMapper.from(note);
        log.trace("NoteResponse with ID:" + noteId + " - " + noteResponse);

        log.debug(FINISH + getCurrentMethodName());
        return noteResponse;
    }

    @Override
    public List<NoteResponse> getAllNotes() {
        log.debug(START + getCurrentMethodName());

        List<NoteResponse> categories = noteRepository.findAll()
                .stream()
                .map(noteResponseMapper::from)
                .collect(Collectors.toList());
        log.trace("Notes: " + categories);

        log.debug(FINISH + getCurrentMethodName());
        return categories;
    }

    @Override
    public NoteResponse updateNote(NoteRequest noteRequest) {
        log.debug(START + getCurrentMethodName());

        Note noteEntity = noteMapper.from(noteRequest);
        log.trace("Note before update: " + noteEntity.toString());

        noteEntity = noteRepository.saveAndFlush(noteEntity);
        log.trace("Note after save: " + noteEntity.toString());

        NoteResponse noteResponse = noteResponseMapper.from(noteEntity);
        log.trace("NoteResponse: " + noteResponse);

        log.debug(FINISH + getCurrentMethodName());
        return noteResponse;
    }

    @Override
    public void deleteById(Long noteId) {
        log.debug(START + getCurrentMethodName());

        noteRepository.deleteById(noteId);
        log.trace("Note with ID: " + noteId + " was deleted from repository");

        log.debug(FINISH + getCurrentMethodName());
    }
}
