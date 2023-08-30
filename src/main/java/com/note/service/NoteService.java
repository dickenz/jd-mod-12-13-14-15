package com.note.service;

import com.note.entity.Note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private final Map<UUID, Note> notes = new HashMap<>();

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        UUID id = UUID.randomUUID();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(UUID id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        UUID id = note.getId();
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        notes.put(id, note);
    }

    public Note getById(UUID id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        return notes.get(id);
    }
}