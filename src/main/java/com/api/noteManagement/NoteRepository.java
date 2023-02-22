package com.api.noteManagement;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository <Note, Long > {
}
