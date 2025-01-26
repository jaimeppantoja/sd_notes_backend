package com.example.backend.controller;

import com.example.backend.model.Note;
import com.example.backend.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from your React app
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    // Create a new note
    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note) {
        return ResponseEntity.ok(noteService.createNote(note));
    }

    // Update an existing note
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note noteDetails) {
        return ResponseEntity.ok(noteService.updateNote(id, noteDetails));
    }

    // Delete a note
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/archive") // Use PATCH instead of POST for updates
    public ResponseEntity<Note> archiveNote(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.archiveNote(id));
    }

    // Unarchive a note
    @PostMapping("/{id}/unarchive")
    public ResponseEntity<Note> unarchiveNote(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.unarchiveNote(id));
    }

    // Add a category to a note
    @PostMapping("/{id}/categories")
    public ResponseEntity<Note> addCategory(@PathVariable Long id, @RequestParam String category) {
        return ResponseEntity.ok(noteService.addCategory(id, category));
    }

    // Remove a category from a note
    @DeleteMapping("/{id}/categories")
    public ResponseEntity<Note> removeCategory(@PathVariable Long id, @RequestParam String category) {
        return ResponseEntity.ok(noteService.removeCategory(id, category));
    }

    // Get all notes (both active and archived)
    @GetMapping("/all")
    public ResponseEntity<List<Note>> listAllNotes() {
        List<Note> activeNotes = noteService.listActiveNotes();
        List<Note> archivedNotes = noteService.listArchivedNotes();

        // Combine both lists into one
        List<Note> allNotes = new ArrayList<>();
        allNotes.addAll(activeNotes);
        allNotes.addAll(archivedNotes);

        return ResponseEntity.ok(allNotes);
    }

    // List active notes
    @GetMapping("/active")
    public ResponseEntity<List<Note>> listActiveNotes() {
        return ResponseEntity.ok(noteService.listActiveNotes());
    }

    // List archived notes
    @GetMapping("/archived")
    public ResponseEntity<List<Note>> listArchivedNotes() {
        return ResponseEntity.ok(noteService.listArchivedNotes());
    }

    // Find notes by category
    @GetMapping("/category")
    public ResponseEntity<List<Note>> findNotesByCategory(@RequestParam String category) {
        return ResponseEntity.ok(noteService.findNotesByCategory(category));
    }

    // Find archived notes by category
    @GetMapping("/archived/category")
    public ResponseEntity<List<Note>> findArchivedNotesByCategory(@RequestParam String category) {
        return ResponseEntity.ok(noteService.findArchivedNotesByCategory(category));
    }

    // Get a specific note
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Get categories
    @GetMapping("/categories")
    public ResponseEntity<Set<String>> getAllCategories() {
        Set<String> categories = noteService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

}