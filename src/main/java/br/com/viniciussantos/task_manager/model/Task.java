package br.com.viniciussantos.task_manager.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {

    @Id
    private String id;
    private User user;
    private String title;
    private String description;
    private Boolean completed = Boolean.FALSE;
}
