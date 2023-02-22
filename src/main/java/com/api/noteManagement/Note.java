package com.api.noteManagement;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Note {

    private @Id @GeneratedValue Long id;

    private String title;
    private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Note(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Note() {
		super();
	}

}
