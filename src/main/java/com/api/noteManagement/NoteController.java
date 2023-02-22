package com.api.noteManagement;


import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository repository) {
        this.noteRepository = repository;
    }

    @GetMapping("/notes")
    Iterable<Note> getNote() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{noteId}")
    Note getNote(@PathVariable Long noteId) {
        return noteRepository.findById(noteId).orElseThrow();
    }

    @PostMapping("/notes")
    Note createNote(@RequestBody Note newNote) {
        return noteRepository.save(newNote);
    }

    @PutMapping("/notes/{noteId}")
    Note updateNote(@PathVariable Long noteId, @RequestBody Note noteDTO) {
        Note noteToUpdate = noteRepository.findById(noteId).orElseThrow();
        noteToUpdate.setTitle(noteDTO.getTitle());
        noteToUpdate.setContent(noteDTO.getContent());
        return noteRepository.save(noteToUpdate);
    }

    @DeleteMapping("/notes/{noteId}")
    void deleteNote(@PathVariable Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        noteRepository.delete(note);
    }
}
