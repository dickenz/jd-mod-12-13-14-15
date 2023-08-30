package com.note.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Note {
    private UUID id;
    private String title;
    private String content;

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
}
