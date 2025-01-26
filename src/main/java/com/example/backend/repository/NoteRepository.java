package com.example.backend.repository;

import com.example.backend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Find active (non-archived) notes
    List<Note> findByArchivedFalse();

    // Find archived notes
    List<Note> findByArchivedTrue();

    // Find active notes by a specific category
    List<Note> findByArchivedFalseAndCategoriesContaining(String category);

    // Find archived notes by a specific category
    List<Note> findByArchivedTrueAndCategoriesContaining(String category);

    // Find active notes matching any of the given categories
    List<Note> findByArchivedFalseAndCategoriesIn(List<String> categories);

    // Find archived notes matching any of the given categories
    List<Note> findByArchivedTrueAndCategoriesIn(List<String> categories);

    // Find notes (active or archived) matching any of the given categories
    List<Note> findByCategoriesIn(List<String> categories);

    // Custom query to get all distinct categories
    @Query("SELECT DISTINCT c FROM Note n JOIN n.categories c")
    Set<String> findDistinctCategories();
}
