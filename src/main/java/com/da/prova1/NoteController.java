package com.da.prova1;



import java.sql.Timestamp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;
    
    NoteController(NoteRepository repository) {
        noteRepository = repository;
    }

    @GetMapping("/notes")
    Iterable<Note> getNotes(){
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{noteId}")
    Note getNote(@PathVariable Long noteId){
        return noteRepository.findById(noteId).orElse(new Note());
    }

    @PostMapping("/notes")
    Note createNote(@RequestBody Note newNote) {
        newNote.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return noteRepository.save(newNote);
    }
    
    @PutMapping("/notes/{noteId}")
    Note updateNote(@PathVariable Long noteId, @RequestBody Note noteDto){
        Note noteToUpdate = noteRepository.findById(noteId).orElseThrow();
        noteToUpdate.setTitle(noteDto.getTitle());
        noteToUpdate.setContent(noteDto.getContent());
        noteToUpdate.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return noteRepository.save(noteToUpdate);

    }

    @DeleteMapping("/notes/{noteId}")
    void deleteNote(@PathVariable Long noteId){
        Note note= noteRepository.findById(noteId).orElseThrow();
        noteRepository.delete(note);
    }
}
