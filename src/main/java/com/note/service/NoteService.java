package com.note.service;

import com.note.data.NoteRepository;
import com.note.entity.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void initializeNotes() {
        Note note1 = new Note();
        note1.setTitle("Sample Note 1");
        note1.setContent("This is the content of note 1.");
        noteRepository.save(note1);

        Note note2 = new Note();
        note2.setTitle("Sample Note 2");
        note2.setContent("This is the content of note 2.");
        noteRepository.save(note2);
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " not found"));
    }

}
