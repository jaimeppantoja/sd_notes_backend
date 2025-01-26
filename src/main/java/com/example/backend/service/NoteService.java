// package com.example.backend.service;

// import com.example.backend.model.Note;
// import com.example.backend.repository.NoteRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Optional;
// import java.util.Set;

// @Service
// @RequiredArgsConstructor
// public class NoteService {
//     private final NoteRepository noteRepository;

//     // Create a new note
//     @Transactional
//     public Note createNote(Note note) {
//         return noteRepository.save(note);
//     }

//     // Update an existing note
//     @Transactional
//     public Note updateNote(Long id, Note noteDetails) {
//         Note existingNote = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
        
//         existingNote.setTitle(noteDetails.getTitle());
//         existingNote.setContent(noteDetails.getContent());
//         existingNote.setCategories(noteDetails.getCategories());
        
//         return noteRepository.save(existingNote);
//     }

//     // Delete a note
//     @Transactional
//     public void deleteNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         noteRepository.delete(note);
//     }

//     // Archive a note
//     @Transactional
//     public Note archiveNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.setArchived(!note.isArchived());
//         return noteRepository.save(note);
//     }

//     // Unarchive a note
//     @Transactional
//     public Note unarchiveNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.setArchived(false);
//         return noteRepository.save(note);
//     }

//     // Add a category to a note
//     @Transactional
//     public Note addCategory(Long id, String category) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.getCategories().add(category);
//         return noteRepository.save(note);
//     }

//     // Remove a category from a note
//     @Transactional
//     public Note removeCategory(Long id, String category) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.getCategories().remove(category);
//         return noteRepository.save(note);
//     }

//     // List active notes
//     public List<Note> listActiveNotes() {
//         return noteRepository.findByArchivedFalse();
//     }

//     // List archived notes
//     public List<Note> listArchivedNotes() {
//         return noteRepository.findByArchivedTrue();
//     }

//     // Find notes by category
//     public List<Note> findNotesByCategory(String category) {
//         return noteRepository.findByArchivedFalseAndCategoriesContaining(category);
//     }

//     // Find archived notes by category
//     public List<Note> findArchivedNotesByCategory(String category) {
//         return noteRepository.findByArchivedTrueAndCategoriesContaining(category);
//     }

//     // Get a specific note
//     public Optional<Note> getNoteById(Long id) {
//         return noteRepository.findById(id);
//     }

//     @Transactional
//     public Set<String> getAllCategories() {
//         List<Note> notes = noteRepository.findAll();  // Get all notes
//         Set<String> allCategories = new HashSet<>();

//         // Collect all categories from the notes
//         for (Note note : notes) {
//             allCategories.addAll(note.getCategories());
//         }

//         return allCategories;
//     }
    
// }

// SECOND

// package com.example.backend.service;

// import com.example.backend.model.Note;
// import com.example.backend.repository.NoteRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Optional;
// import java.util.Set;

// @Service
// @RequiredArgsConstructor
// public class NoteService {
//     private final NoteRepository noteRepository;

//     // Create a new note
//     @Transactional
//     public Note createNote(Note note) {
//         return noteRepository.save(note);
//     }

//     // Update an existing note
//     @Transactional
//     public Note updateNote(Long id, Note noteDetails) {
//         Note existingNote = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));

//         existingNote.setTitle(noteDetails.getTitle());
//         existingNote.setContent(noteDetails.getContent());
//         existingNote.setCategories(noteDetails.getCategories());

//         return noteRepository.save(existingNote);
//     }

//     // Delete a note
//     @Transactional
//     public void deleteNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         noteRepository.delete(note);
//     }

//     // Archive a note
//     @Transactional
//     public Note archiveNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.setArchived(!note.isArchived());
//         return noteRepository.save(note);
//     }

//     // Unarchive a note
//     @Transactional
//     public Note unarchiveNote(Long id) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.setArchived(false);
//         return noteRepository.save(note);
//     }

//     // Add a category to a note
//     @Transactional
//     public Note addCategory(Long id, String category) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.getCategories().add(category);
//         return noteRepository.save(note);
//     }

//     // Remove a category from a note
//     @Transactional
//     public Note removeCategory(Long id, String category) {
//         Note note = noteRepository.findById(id)
//             .orElseThrow(() -> new RuntimeException("Note not found"));
//         note.getCategories().remove(category);
//         return noteRepository.save(note);
//     }

//     // List active notes
//     public List<Note> listActiveNotes() {
//         return noteRepository.findByArchivedFalse();
//     }

//     // List archived notes
//     public List<Note> listArchivedNotes() {
//         return noteRepository.findByArchivedTrue();
//     }

//     // Find notes by category
//     public List<Note> findNotesByCategory(String category) {
//         return noteRepository.findByArchivedFalseAndCategoriesContaining(category);
//     }

//     // Find archived notes by category
//     public List<Note> findArchivedNotesByCategory(String category) {
//         return noteRepository.findByArchivedTrueAndCategoriesContaining(category);
//     }

//     // Get a specific note
//     public Optional<Note> getNoteById(Long id) {
//         return noteRepository.findById(id);
//     }

//     // Retrieve all unique categories
//     @Transactional(readOnly = true)
//     public Set<String> getAllCategories() {
//         List<Note> notes = noteRepository.findAll(); // Retrieve all notes
//         Set<String> allCategories = new HashSet<>();

//         // Collect unique categories from all notes
//         notes.forEach(note -> allCategories.addAll(note.getCategories()));

//         return allCategories;
//     }
// }

package com.example.backend.service;

import com.example.backend.model.Note;
import com.example.backend.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    // Create a new note
    @Transactional
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    // Update an existing note
    @Transactional
    public Note updateNote(Long id, Note noteDetails) {
        Note existingNote = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));

        existingNote.setTitle(noteDetails.getTitle());
        existingNote.setContent(noteDetails.getContent());
        existingNote.setCategories(noteDetails.getCategories());

        return noteRepository.save(existingNote);
    }

    // Delete a note
    @Transactional
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(note);
    }

    // Archive a note
    @Transactional
    public Note archiveNote(Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setArchived(!note.isArchived());
        return noteRepository.save(note);
    }

    // Unarchive a note
    @Transactional
    public Note unarchiveNote(Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setArchived(false);
        return noteRepository.save(note);
    }

    // Add a category to a note
    @Transactional
    public Note addCategory(Long id, String category) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));
        note.getCategories().add(category);
        return noteRepository.save(note);
    }

    // Remove a category from a note
    @Transactional
    public Note removeCategory(Long id, String category) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Note not found"));
        note.getCategories().remove(category);
        return noteRepository.save(note);
    }

    // List active notes
    public List<Note> listActiveNotes() {
        return noteRepository.findByArchivedFalse();
    }

    // List archived notes
    public List<Note> listArchivedNotes() {
        return noteRepository.findByArchivedTrue();
    }

    // Find notes by category
    public List<Note> findNotesByCategory(String category) {
        return noteRepository.findByArchivedFalseAndCategoriesContaining(category);
    }

    // Find archived notes by category
    public List<Note> findArchivedNotesByCategory(String category) {
        return noteRepository.findByArchivedTrueAndCategoriesContaining(category);
    }

    // Get a specific note
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // Retrieve all unique categories
    @Transactional(readOnly = true)
    public Set<String> getAllCategories() {
        return noteRepository.findDistinctCategories();
    }
}
