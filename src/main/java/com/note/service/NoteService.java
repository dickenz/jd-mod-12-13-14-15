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
