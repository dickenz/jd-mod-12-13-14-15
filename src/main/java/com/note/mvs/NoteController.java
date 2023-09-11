package com.note.mvs;

import com.note.entity.Note;
import com.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam UUID id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam UUID id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String saveNote(@ModelAttribute("note") Note note) {
        System.out.println("Before Update: " + note);
        noteService.update(note);
        System.out.println("After Update: " + note);
        return "redirect:/note/list";
    }

}
