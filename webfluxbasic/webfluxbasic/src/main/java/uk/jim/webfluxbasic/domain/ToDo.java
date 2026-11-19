package uk.jim.webfluxbasic.domain;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ToDo {
    private String id;
    private String descripton;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean completed;

    //No-args constructor (required for bean creation)
    public ToDo() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    //Just a description constructor
    public ToDo(String descripton) {
        this();
        this.descripton = descripton;
    }

    //Description and completed constructor this will chain things back.
    public ToDo(String descripton, boolean completed) {
        this(descripton);
        this.completed = completed;
    }

}
