package com.da.prova1;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Note {

    private @Id @GeneratedValue Long id;
    private String title;
    private String content;
    private Timestamp timestamp;

    

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

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

    Note() {}

    public Note(String title, String content, Timestamp timestamp) {
        super();
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }


    
}
